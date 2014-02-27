package com.answer1991.utils.logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.answer1991.utils.qualifier.HelloLogger;

public class LoggerProducer {
	@Produces
	@HelloLogger
	@RequestScoped
	public Logger produceLogger() {
		System.out.println("123");
		return LoggerFactory.getLogger(this.getClass());
	}
}
