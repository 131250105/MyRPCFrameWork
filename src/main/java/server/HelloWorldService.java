package server;

import core.RPCService;

@RPCService(HelloWorldService.class)
public interface HelloWorldService {

	public String hello(String hello);
}
