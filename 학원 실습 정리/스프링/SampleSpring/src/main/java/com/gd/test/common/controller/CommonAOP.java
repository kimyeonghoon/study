package com.gd.test.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class CommonAOP {
	//Pointcut -> 적용범위
	//@Pointcut(범위설정)
	/*
	 * 범위
	 * execution -> include필터
	 * !execution -> exclude필터
	 * * -> 모든것
	 * *(..) -> 모든 메소드
	 * .. -> 모든 경로
	 * && -> 필터 추가
	 */
	// TestController 밑에 있는 b로 시작하는 메소드에 걸겠다.
	@Pointcut("execution(* com.gd.test..TestController.*(..))" 
	          + "&&!execution(* com.gd.test..TestController.*Log*(..))"
	          + "&&!execution(* com.gd.test..TestController.*Join(..))"
	          + "&&!execution(* com.gd.test..TestController.*Ajax(..))"
			  + "&&!execution(* com.gd.test..TestController.*s(..))")
	public void testAOP() {}
	
	//ProceedingJoinPoint -> 대상 적용 이벤트 필터
	/*
	 * @Before -> 메소드 실행 전
	 * @After -> 메소드 실행 후
	 * @After-returning -> 메소드 정상실행 후
	 * @After-throwing -> 메소드 예외 발생 후
	 * @Around -> 모든 동작시점
	 */
	@Around("testAOP()") // @Around(포인트컷메소드) : 포인트컷에 할당된 메소드의 모든 동작시점에 적용 
	public ModelAndView testAOP(ProceedingJoinPoint joinPoint)
														throws Throwable {
		ModelAndView mav = new ModelAndView();
		
		//Request 객체 취득
		HttpServletRequest request
		= ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpSession session = request.getSession(); // Session 취득
		if(session.getAttribute("sBmNo") != null) {
			mav = (ModelAndView) joinPoint.proceed(); //기존 이벤트 처리 행위를 이어서 진행
		} else {
			mav.setViewName("redirect:bLogin");
		}
		
		
		System.out.println("------- testAOP 실행됨 ------");
		
		return mav;
	}
}













