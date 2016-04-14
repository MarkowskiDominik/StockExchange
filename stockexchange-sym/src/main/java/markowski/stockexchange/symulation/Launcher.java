package markowski.stockexchange.symulation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		Symulation symulation = (Symulation) context.getBean("symulation");
		symulation.start();
		((ConfigurableApplicationContext)context).close();
	}
}