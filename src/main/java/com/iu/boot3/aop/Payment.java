package com.iu.boot3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Payment {
	
	@Around("execution( * com.iu.boot3.aop.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{ 
		//join Point 핵심 로직 메서드(but,subway)
		System.out.println("탑승 전 카드 체크");
		
		Object obj = joinPoint.proceed();
		//obj는 핵심로직 메서드의 리턴
		
		System.out.println("하차 시 카드 체크");
		
		return obj;
	}
	

	
	@Before("execution (* com.iu.boot3.board.BoardService.get*(..))")
	public void info() {
		System.out.println("before");
	}
	
	@After("execution (* com.iu.boot3.aop.Transfer.*())")
	public void after() {
		System.out.println("AfterReturining + AfterThrowing");
	}
	
	@AfterReturning("execution (* com.iu.boot3.aop.Transfer.*())")
	public void afterReturning() {
		System.out.println("AfterReturining");
	}
	
	@AfterThrowing("execution (* com.iu.boot3.board.BoardService.get*(..))")
	public void afterThrowing() {
		System.out.println("AfterThrowing");
	}
	
//	@Around("execution (* com.iu.boot3.board.BoardService.get*(..))")
//	public void around() {
//		System.out.println("before + after");
//	}
}
