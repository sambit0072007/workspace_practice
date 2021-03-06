package com.java.practice.collectionsexample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;


interface MyTestInterface{
	public void showDetails(String name);
}


public class PracticeSetsAndMaps {

	
	Map<Integer, Object> myMap= new ConcurrentHashMap<>();
	//Map<Integer, Object> myMap= new HashMap<>();
	
	public void example() {
		myMap.put(101, "Spring Tools Suite");
		myMap.put(101, "Spring Tools Suite-duplicate");
		myMap.put(102, Arrays.asList("one","two","three"));
		//myMap.put(null, "testing null");  // In HashMap null null key is allowed but not in concurrent hashmap
		//myMap.put(null, "testing null1");
		System.out.println(myMap);
		//myMap.clear();
		myMap.forEach((k,v)->System.out.println("Key="+k +" and value="+v ));
		System.out.println(myMap);
		
		/*Concurrent Hashmap methods*/
		myMap.entrySet().stream().forEach(x->System.out.println("Printing the entry set from the Map:: "+x));
		myMap.keySet().stream().forEach(x->System.out.println("Printing the key set from the Map:: "+x));
	}
	
	public void userMethodReference(String name, Function<String, String> methodRefFunc) {
		methodRefFunc.apply(name);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PracticeSetsAndMaps obj = new PracticeSetsAndMaps();
		obj.example();
		//obj.showDetai
	}

}
