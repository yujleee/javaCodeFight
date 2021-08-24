package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import kr.co.youiwe.webservice.BitSms;

@SpringBootApplication
public class BoardTestApplication {

	public static void main(String[] args) {
		/*
		 * String from = "01025598279"; String to = "01088751926"; String msg =
		 * "회원가입을 축하합니다."; BitSms sms = new BitSms(); sms.sendMsg(from, to, msg);
		 * System.out.println("문자전송 하였습니다.");
		 */
		
		SpringApplication.run(BoardTestApplication.class, args);
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
}
