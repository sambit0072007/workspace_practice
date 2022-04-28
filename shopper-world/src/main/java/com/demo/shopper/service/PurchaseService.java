package com.demo.shopper.service;

import org.springframework.http.ResponseEntity;

import com.demo.shopper.model.PurchaseModel;

public interface PurchaseService {
	public ResponseEntity<Object> createPurchase(PurchaseModel purchase);

}
