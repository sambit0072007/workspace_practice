package com.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class MyPredicate implements Predicate<Integer>{

	int numberToMatch;
	MyPredicate(int numberToMatch){
		this.numberToMatch=numberToMatch;
		
	}
	@Override
	public boolean test(Integer t) {
		// TODO Auto-generated method stub
		return numberToMatch>t;
	}
	
}

class MyConsumer implements Consumer {

	
	@Override
	public void accept(Object t) {
		// TODO Auto-generated method stub
		
		System.out.println("Custom Consumer ::: "+t.toString().toUpperCase());
	}
	
}


public class PracticeStreams {

	List<String> strList= new ArrayList<>();
	
	public void testStreams() {
		Predicate<String> testPredicate= str->(str.length()<4);
		
		strList.addAll(Arrays.asList("Rita","Jim","Carl","Li","Josh"));
		List listOfJ=strList.stream().filter(x->x.contains("J")).collect(Collectors.toList());
		System.out.println("Items Containing J:"+listOfJ);
		List listBasedOnLen=strList.stream().filter(testPredicate).collect(Collectors.toList());
		System.out.println(listBasedOnLen);
		
		String name="Josh";
		MyPredicate lenPredicate= new MyPredicate( new Integer(8));//Anything less then prescribed Length will be shown. Prescribed at constructor of the  CustomPredicate
		List listBasedOn4Len=strList.stream().filter(x->lenPredicate.test(x.length())).collect(Collectors.toList());
		System.out.println("Hi ::  "+listBasedOn4Len);
		
		
		strList.stream().forEach(x-> new MyConsumer().accept(x));
		strList.forEach(x->System.out.println("For Each Printing:  "+x));
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//
//		PracticeStreams obj= new PracticeStreams();
//		obj.testStreams();
//	}

}
