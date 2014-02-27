package com.answer1991.utils.logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.answer1991.utils.qualifier.HelloLogger;

@RequestScoped
public class Hello {
	@Inject
	@HelloLogger
	private Logger logger;
	
	public String getMsg() {
		logger.debug("Hello visited!");
		return "hello";
	}
}
