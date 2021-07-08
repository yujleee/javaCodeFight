package com.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GoodsVo {
	private int no;
	private String item;
	private int price;
	private int qty;
	private String fname;

}
