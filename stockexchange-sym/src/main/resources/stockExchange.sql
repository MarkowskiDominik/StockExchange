-- -----------------------------------------------------
-- Schema stock_exchange
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `stock_exchange` ;
CREATE SCHEMA `stock_exchange` ;

-- -----------------------------------------------------
-- Schema stock_exchange
-- -----------------------------------------------------
USE `stock_exchange` ;

-- -----------------------------------------------------
-- Table `stock_exchange`.`listed_companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`listed_companies` (
  `companyName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`companyName`));

LOAD DATA LOCAL INFILE 'C:/Users/DMARKOWS/Desktop/dane.csv' 
INTO TABLE `stock_exchange`.`listed_companies`
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n' 
(`companyName`, @dummy, @dummy);

-- -----------------------------------------------------
-- Table `stock_exchange`.`stock_quotes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`stock_quotes` (
  `idStockQuotes` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `companyName` VARCHAR(45) NOT NULL,
  `unitPrice` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idStockQuotes`),
  INDEX `fk_stock_quotes_stock_company1_idx` (`companyName` ASC),
  CONSTRAINT `fk_stock_quotes_stock_company`
    FOREIGN KEY (`companyName`)
    REFERENCES `stock_exchange`.`listed_companies` (`companyName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

LOAD DATA LOCAL INFILE 'C:/Users/DMARKOWS/Desktop/dane.csv' 
INTO TABLE `stock_exchange`.`stock_quotes`
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n' 
(`companyName`, `date`, `unitPrice`);

-- -----------------------------------------------------
-- Table `stock_exchange`.`bank_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`bank_account` (
  `bankAccount` BIGINT(19) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bankAccount`))
ENGINE = InnoDB;

INSERT INTO `stock_exchange`.`bank_account` (`bankAccount`)
VALUES
	(1000),
    (1001),
    (1002),
    (1003);

-- -----------------------------------------------------
-- Table `stock_exchange`.`broker_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`broker_account` (
  `brokerAccount` BIGINT(19) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`brokerAccount`))
ENGINE = InnoDB;

INSERT INTO `stock_exchange`.`broker_account` (`brokerAccount`)
VALUES
    (2001),
    (2002),
    (2003);

-- -----------------------------------------------------
-- Table `stock_exchange`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`client` (
  `idClient` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `bankAccount` BIGINT(19) NOT NULL,
  `brokerAccount` BIGINT(19) NOT NULL,
  PRIMARY KEY (`idClient`),
  INDEX `fk_person_bank_account_idx` (`bankAccount` ASC),
  INDEX `fk_person_broker_account_idx` (`brokerAccount` ASC),
  CONSTRAINT `fk_person_bank_account`
    FOREIGN KEY (`bankAccount`)
    REFERENCES `stock_exchange`.`bank_account` (`bankAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_broker_account`
    FOREIGN KEY (`brokerAccount`)
    REFERENCES `stock_exchange`.`broker_account` (`brokerAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `stock_exchange`.`client` (`name`, `bankAccount`, `brokerAccount`)
VALUES
	('client_1',1001,2001),
	('client_2',1002,2002),
	('client_3',1002,2003);

-- -----------------------------------------------------
-- Table `stock_exchange`.`stocks_purchased_by_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`stocks_purchased_by_client` (
  `idClientStocks` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `brokerAccount` BIGINT(19) NOT NULL,
  `companyName` VARCHAR(45) NOT NULL,
  `numberOfStocks` INT NOT NULL,
  `averagePurchasePrice` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idClientStocks`),
  INDEX `fk_client_stock_broker_account_idx` (`brokerAccount` ASC),
  INDEX `fk_client_stock_stock_company_idx` (`companyName` ASC),
  CONSTRAINT `fk_client_stock_broker_account`
    FOREIGN KEY (`brokerAccount`)
    REFERENCES `stock_exchange`.`broker_account` (`brokerAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_stock_stock_company`
    FOREIGN KEY (`companyName`)
    REFERENCES `stock_exchange`.`listed_companies` (`companyName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `stock_exchange`.`currency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`currency` (
  `code` VARCHAR(3) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`code`));

INSERT INTO `stock_exchange`.`currency` (`code`, `name`)
VALUES
	('PLN','Polski Złoty'),
	('EUR','Euro');

-- -----------------------------------------------------
-- Table `stock_exchange`.`currency_exchange_rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`currency_exchange_rate` (
  `date` DATE NOT NULL,
  `currencyCode` VARCHAR(3) NOT NULL,
  `currencyRate` DECIMAL(8,6) NOT NULL,
  PRIMARY KEY (`date`, `currencyCode`),
  INDEX `fk_exchangeRate_currency_idx` (`currencyCode` ASC),
  CONSTRAINT `fk_exchangeRate_currency`
    FOREIGN KEY (`currencyCode`)
    REFERENCES `stock_exchange`.`currency` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `stock_exchange`.`currency_exchange_rate` (`date`, `currencyCode`, `currencyRate`)
SELECT tmp.date, 'EUR', round(rand(4)/5,6)+3.9 as rate
FROM (
	SELECT distinct sq.date
	FROM `stock_exchange`.`stock_quotes` as sq
)tmp;

-- -----------------------------------------------------
-- Table `stock_exchange`.`bank_account_funds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`bank_account_funds` (
  `idBankAccountFunds` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `bankAccount` BIGINT(19) NOT NULL,
  `currencyCode` VARCHAR(3) NOT NULL,
  `funds` DECIMAL(10,2) NOT NULL,
  INDEX `fk_bankAccountFunds_currency_idx` (`currencyCode` ASC),
  INDEX `fk_bank_account_funds_bank_account_idx` (`bankAccount` ASC),
  PRIMARY KEY (`idBankAccountFunds`),
  CONSTRAINT `fk_bankAccountFunds_currency`
    FOREIGN KEY (`currencyCode`)
    REFERENCES `stock_exchange`.`currency` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bank_account_funds_bank_account`
    FOREIGN KEY (`bankAccount`)
    REFERENCES `stock_exchange`.`bank_account` (`bankAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `stock_exchange`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_exchange`.`transaction` (
  `idTransaction` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `brokerAccount` BIGINT(19) NOT NULL,
  `companyName` VARCHAR(45) NOT NULL,
  `numberOfStocks` INT NOT NULL,
  `totalPrice` DECIMAL(10,2) NOT NULL,
  `type` ENUM('buy', 'sell') NOT NULL,
  `status` ENUM('offer', 'done') NOT NULL,
  PRIMARY KEY (`idTransaction`),
  INDEX `fk_transaction_broker_account1_idx` (`brokerAccount` ASC),
  INDEX `fk_transaction_stock_company1_idx` (`companyName` ASC),
  CONSTRAINT `fk_transaction_broker_account`
    FOREIGN KEY (`brokerAccount`)
    REFERENCES `stock_exchange`.`broker_account` (`brokerAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_stock_company`
    FOREIGN KEY (`companyName`)
    REFERENCES `stock_exchange`.`listed_companies` (`companyName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;