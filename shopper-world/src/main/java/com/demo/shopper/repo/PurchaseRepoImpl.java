package com.demo.shopper.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.shopper.model.PurchaseModel;

import lombok.extern.slf4j.Slf4j;
@Repository
@Slf4j
public class PurchaseRepoImpl implements PurchaseRepo {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public ResponseEntity<Object> createPurchase(PurchaseModel purchase) {
		// TODO Auto-generated method stub
		int status=-1;
		String operationCompleted="-";
		StringBuffer sql= new StringBuffer();
		log.info("{}",purchase);
		List<String> alreadyPresentData=getAllItemCodes();
		boolean isDataPresent=alreadyPresentData.stream().anyMatch(x->x.equalsIgnoreCase(purchase.getItemCode()+"-"+purchase.getItemName()));
		System.out.println(" Is Data  "+purchase.getItemCode()+"-"+purchase.getItemName() +" present: "+isDataPresent);
		if(!isDataPresent) {
			System.out.println("Insert Operation in Progress");
			sql.append("insert into PurchaseItems(item_code,item_name,item_price) values (?,?,?)");
			status=template.update(sql.toString(), purchase.getItemCode(),purchase.getItemName(), purchase.getItemPrice());
			operationCompleted="SUCCESSFULLY INSERTED";
		}else {
			System.out.println("Update Operation in Progress");
			sql.append("update PurchaseItems set item_name=?, item_price=? where item_code=?");
			status=template.update(sql.toString(), purchase.getItemName(),purchase.getItemPrice(),purchase.getItemCode());
			operationCompleted="SUCCESSFULLY UPDATED";
		}
		//Object args= new Object[] {purchase.getItemCode(),purchase.getItemName(), purchase.getItemPrice()};
		return new ResponseEntity(operationCompleted, HttpStatus.OK);
		//return new ResponseEntity(template.update(sql.toString(), args), HttpStatus.OK);
	}
	
	public List<String> getAllItemCodes(){
		
		String sql="select concat_ws('-',item_code,item_name) from PurchaseItems ";
		return template.queryForList(sql, String.class);
				
	}

}
