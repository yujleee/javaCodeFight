package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //�Ű����� ��� ���� ������
@NoArgsConstructor	//�Ű����� ���� ������
public class CustomerVO {
	private int custid;
	private String name;
	private String address;
	private String phone;
	
	
}
