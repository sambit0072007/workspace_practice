package com.demo.shopper.repo;

import org.springframework.http.ResponseEntity;

import com.demo.shopper.model.PurchaseModel;

public interface PurchaseRepo {

	public ResponseEntity<Object> createPurchase(PurchaseModel purchase);
}
