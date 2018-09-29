package com.ssmdemo.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 使用时出现问题和解决办法
 * 1、before、after、around的顺序是 around的Object value = proceedingJoinPoint.proceed()，前的方法会在before之前执行
 * 	 after方法会在value赋值之后执行，然后再执行value赋值之后的around方法
 * 2、around方法必须要有joinPoint加载
 * 3、around方法写的存在问题，出现了不加载before方法的现象，解决办法是在around方法加上joinpoint参数并调用value赋值
 * 
 * 
 * 
 * @Title:ControllerAdivce.java
 * @Package:com.ssmdemo.aop
 * @Description:TODO(用一句话描述该文件做什么)
 * @author:Kylin
 * @date:2018年9月29日上午11:45:40
 * @version:V1.0
 */


@Aspect
public class ControllerAdivce {
	@Before("execution(* com.ssmdemo.web.PersonController.*(..))")
	public void beforePersonlist() {
		System.out.println("aaaaaaaaaaaaaaaa");
	}

	@Around("execution(* com.ssmdemo.web.PersonController.findAll())")
	public Object  around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		 System.out.println("........织入前........");
		 Object value = proceedingJoinPoint.proceed();
		 System.out.println("........织入后........");
		 return value;
	}
	
	@After("execution(* com.ssmdemo.web.PersonController.findAll())")
	public void afterPersonList() {
		System.out.println("cccccccccc");
	}
	

}
