package com.answer1991.ws2;

import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Echo {
	@WebMethod
	public abstract String getEcho(String msg) throws RemoteException;
	
	@WebMethod
	public abstract String notWebMethod(String msg) throws RemoteException;
}
