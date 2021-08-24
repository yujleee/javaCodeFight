package com.example.demo.advice;

import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.demo.db.DBManger;
import com.example.demo.vo.Sist_log;

//@Component //dao, controller 그 이외의 객체들을 자동 스캔하여 객체 생성
@Aspect
public class ControllerLogging {
	
	//타겟으로 지정할 메소드 설정
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	private void profileTarget() {}
	
	@Around("profileTarget()")
	public Object logging(ProceedingJoinPoint joinPoint) {
		Object ret = null;
		long start = System.currentTimeMillis();
		try {
			ret = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO: handle exception
		}
		long end = System.currentTimeMillis();
		long stay = end-start; //걸린시간
		
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr(); //요청한 ip
		Date today = new Date(); //요청시간
		int year = today.getYear()+ 1900;
		int month = today.getMonth() +1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int second = today.getSeconds();
		
		String time = year + "년" + month + "월" + date + "일 " + hours +":" + minutes + ":" 
				+ second;
		
		Sist_log log = new Sist_log(0, uri, time, (int)stay, ip);
		DBManger.insertLog(log);
		
		return ret;
	}
	/*
	 * @AfterThrowing("profileTarget()") public void after_error(JoinPoint
	 * joinPoint) { String methodName = joinPoint.getSignature().toShortString();
	 * System.out.println(methodName + "가 비정상적으로 완료되었습니다."); //비정상적으로 수행되면 실행 }
	 */
	/*
	 * @AfterReturning("profileTarget()") public void after_ok(JoinPoint joinPoint)
	 * { String methodName = joinPoint.getSignature().toShortString();
	 * System.out.println(methodName + "가 정상 완료되었습니다."); //비정상적으로 수행되면 실행하지 않음 }
	 */	
	
	/*
	 * @After("profileTarget()") public void after(JoinPoint joinpoint) { String
	 * methodName = joinpoint.getSignature().toShortString();
	 * System.out.println(methodName + " 핵심관심사항 동작 후 입니다."); }
	 */
	
	/*
	 * @Before("profileTarget()") public void before() {
	 * System.out.println("핵심관심사항 동작 전입니다."); }
	 */
	
	//타겟이 될 pointcut 아이디 지정 (전, 후에 pro 메소드가 실행시킴)
	/*
	 * @Around("profileTarget()") public Object pro(ProceedingJoinPoint joinPoint) {
	 * //타겟 메소드 실행 전, 후에 해야할 일이 있기 때문에 타겟 메소드를 직접 호출해야함. Object ret = null; String
	 * methodName = joinPoint.getSignature().toShortString();
	 * System.out.println(methodName +"이 동작하기 전입니다."); long start =
	 * System.currentTimeMillis(); try { ret = joinPoint.proceed(); //타겟 메소드 호출 이 문장
	 * 기준으로 전에는 호출 전, 후에는 호출 후에 해야할 일 작성 //예외를 갖고있기 때문에 Throwable 이 있는 try-catch문에
	 * 넣음 } catch (Throwable e) { System.out.println(e.getMessage()); } long end =
	 * System.currentTimeMillis(); System.out.println(methodName +"이 동작한 후입니다.");
	 * System.out.println("걸린시간: " + (end-start));
	 * 
	 * return ret; }
	 */
	
	
	

}
