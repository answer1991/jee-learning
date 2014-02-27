package com.answer1991.ws;

import java.rmi.RemoteException;

public interface HelloServiceRemote {
	public abstract Pet getPet(String id) throws RemoteException;
}
