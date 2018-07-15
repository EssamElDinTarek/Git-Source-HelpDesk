package com.sbm.helpdesk.aop.config;

import org.aspectj.lang.annotation.Pointcut;

public final class AOPJoinPointConfig {

	@Pointcut("execution(* com.sbm.helpdesk.HelpDeskIntegrationAPI.controller.*.*(..))")
	public void controllerExecution() {}
	@Pointcut("execution(* com.sbm.helpdesk.service.*.*(..))")
	public void serviceExecution() {}
}
