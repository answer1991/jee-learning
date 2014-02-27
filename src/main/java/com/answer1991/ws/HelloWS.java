package com.answer1991.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/fadsf")
public class HelloWS {
	@GET
	public Pet handle() {
		Pet pet = new Pet();
		pet.setName("hello");
		pet.setOwner("fsaf");
		return pet;
	}
}
