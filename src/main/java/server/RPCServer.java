package server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import core.ServiceRegister;

public class RPCServer implements ApplicationContextAware,InitializingBean {

	
	private String serverAddress ;
	private ServiceRegister serviceRegister;
	private Map<String, Object> handlerMap = new HashMap<String,Object>();
	
	public RPCServer(String serverAddress ,ServiceRegister serviceRegister){
		   this.serverAddress = serverAddress;
		   this.serviceRegister = serviceRegister;
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public ServiceRegister getServiceRegister() {
		return serviceRegister;
	}

	public void setServiceRegister(ServiceRegister serviceRegister) {
		this.serviceRegister = serviceRegister;
	}

}
