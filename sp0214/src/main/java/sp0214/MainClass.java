package sp0214;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//[ xml 설정방법 ]
		//AbstractApplicationContext ctx = new GenericXmlApplicationContext("sp0214/app_config.xml");
		//My myInfo = ctx.getBean("myInfo",My.class);
		
		//[ 어노테이션 설정방법 ]
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/sp0214/app_config2.xml");
		My myInfo = ctx.getBean(My.class);
		
		
		myInfo.getInfo();
		
		
	}

}
