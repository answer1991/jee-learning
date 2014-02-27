package com.answer1991.servlet.ejb;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.servlet.AsyncContext;

import com.answer1991.servlet.asyc.PriceVolumeServlet;

@Singleton
@Startup
public class PriceVolumeBean {
	@Resource
	private TimerService timeService;
	
	private PriceVolumeServlet servlet;
	
	
	public void setServlet(PriceVolumeServlet servlet) {
		this.servlet = servlet;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("PriceVolumeBean inited!");
		timeService.createIntervalTimer(10000, 10000, new TimerConfig());
	}
	
	@Timeout
	public void doEveryTimeout() {
		servlet.sendTimeToAllRequest();
	}
}
