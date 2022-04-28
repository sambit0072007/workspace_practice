package com.demo.shopper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseModel {
	private String itemName;
	private String itemCode;
	private String itemPrice;
	

}
