package com.answer1991.jsf.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("student")
public class Student {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
