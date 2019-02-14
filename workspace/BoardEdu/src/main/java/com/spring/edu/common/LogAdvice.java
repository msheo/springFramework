package com.spring.edu.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LogAdvice {
	
	
	
	public void beforeLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		
		System.out.println("[BeforeAdvice]"+jp.getSignature().getName() + "함수 인자 : " + args[0].toString());
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println("[AroundAdvice]" + pjp.getSignature().getName() + "실행시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	}
	
	
	
}
