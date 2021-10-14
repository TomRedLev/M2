package client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import DefaultNamespace.Hello;
import DefaultNamespace.HelloServiceLocator;

public class ClientStub {

	public static void main(String[] args) throws ServiceException, RemoteException {
		Hello service = new HelloServiceLocator().getHello();
		System.out.println(service.sayHello("Mahdi"));
	}

}
