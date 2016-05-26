package server;


public class HelloWorldServiceImpl implements HelloWorldService {

	public String hello(String hello) {
		// TODO Auto-generated method stub
		if("hello".equals(hello))
			return "hello";
		else
			return "wrongInput";
	}

}
