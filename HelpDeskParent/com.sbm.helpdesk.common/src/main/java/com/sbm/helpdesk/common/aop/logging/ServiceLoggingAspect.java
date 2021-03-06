package com.sbm.helpdesk.common.aop.logging;

import java.util.Arrays;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.slf4j.*;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class ServiceLoggingAspect {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("com.sbm.helpdesk.common.aop.config.AOPJoinPointConfig.serviceExecution()")
	public void beforeController(JoinPoint joinPoint) {
		System.out.println(" **************** Start {} **************** "+
				joinPoint.toString());
		System.out.println(" **************** Params passed = {} **************** "+
				Arrays.toString(joinPoint.getArgs()));
	}

	@After("com.sbm.helpdesk.common.aop.config.AOPJoinPointConfig.serviceExecution()")
	public void afterController(JoinPoint joinPoint) {
		System.out.println(" **************** Finish {} **************** "+
				joinPoint.toString());
	}

	@Around("com.sbm.helpdesk.common.aop.config.AOPJoinPointConfig.serviceExecution()")
	public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;		
		result = joinPoint.proceed();
		System.out.println("The result of " 
				+ joinPoint.getSignature().getDeclaringType().getSimpleName() 
				+ " class in " + joinPoint.getSignature().getName() 
				+ " method is : {}"+ result);
		return result;
	}
}
