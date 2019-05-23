package com.example.tg;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DoubleValueCheck {
	String v;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		double s = 0.0;
		List<Double> ld = Arrays.asList(1.2,2.3,3.5);
		System.out.println(ld.get(2));
		for(Number n: ld)
		{
			s+= n.doubleValue();
			System.out.println(n.doubleValue());
		}
		System.out.println(s);
		Date d = new Date();
		
		String className = "com.example.tg.DoubleValueCheck";
		
		DoubleValueCheck doubleValueCheckClass = null;
		
		Class doubleValueCheck = Class.forName(className) ;
		doubleValueCheckClass = (DoubleValueCheck) doubleValueCheck.newInstance();
		doubleValueCheckClass.v = "ram";
		
		System.out.println(doubleValueCheckClass.v);
		
		String a = "ram";
		
		String b = "ram";
		
		if(a==b)
		{
			System.out.println("equal");
		}
		

	}

}
