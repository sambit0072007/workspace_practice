package com.demo.shopper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.shopper.model.PurchaseModel;
import com.demo.shopper.repo.PurchaseRepo;

@Service
public class PurchaseServiceImpl  implements PurchaseService{

	@Autowired
	PurchaseRepo repo;
	
	@Override
	public ResponseEntity<Object> createPurchase(PurchaseModel purchase) {
		// TODO Auto-generated method stub
		return repo.createPurchase(purchase);
	}

}
