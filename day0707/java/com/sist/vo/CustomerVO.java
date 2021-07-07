package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //매개변수 모두 갖는 생성자
@NoArgsConstructor	//매개변수 없는 생성자
public class CustomerVO {
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	
}
