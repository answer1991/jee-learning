package com.answer1991.ws;

import javax.jws.WebService;

@WebService(name = "HelloService", portName = "PetPort", serviceName = "HelloService", targetNamespace = "http://ws.answer1991.com")
public class HelloServiceImpl implements HelloService {
	@Override
	public Pet getPet(String id) {
		Pet pet = new Pet();
		pet.setName(id);
		pet.setOwner("Joe");
		return pet;
	}
}
