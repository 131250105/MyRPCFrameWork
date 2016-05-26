package core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RPCBootstrap {

	public static void main(String[] args){
		System.out.println("调用");
		new ClassPathXmlApplicationContext("spring.xml");
	}
}
