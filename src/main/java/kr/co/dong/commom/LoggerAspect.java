package kr.co.dong.commom;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sun.tools.sjavac.Log;

import kr.co.dong.HomeController;
import kr.co.dong.controller.BoardController;

// advice : 공통업무를 지원하는 클래스

@Component
@Aspect
public class LoggerAspect {
	protected Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	//컨트롤러 작업전에 실행됨
	//컨트롤러 시작전과 후에 타이머를 작동시키자.
	@Around("execution(* kr.co.dong.controller.*Controller.*(..))")
	public Object logPrint(ProceedingJoinPoint joinpoint) throws Throwable {
		// 핵심업무 실행전
		Object result = null;
		long start = System.currentTimeMillis();
		
		// 핵심업무 실행  .lang
		result = joinpoint.proceed();
		// 핵심업무 실행후 
		
		long end = System.currentTimeMillis();
		
		log.info("-> 수행시간 :" + (end-start) + "ms");
		return result;
	}
}
