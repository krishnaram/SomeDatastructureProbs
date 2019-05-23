package com.example.tg;

import java.util.LinkedHashMap;
import java.util.Map;

public class HackerEarth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int i =0;
			int j= 0;
			
			for(int z=0;z<5;z++)
			{
				if((++i)>3 || (++j)>3)
					i++;
			}
			System.out.println(i);
			
			//n.getBytes()new Exception();
			String n= "ram";
			n.getBytes();
			for(Byte k:n.getBytes())
				System.out.println(k);
			
			int a=1;int b=2;int c=3;
			
			a|=4;
			b>>=1;
			c<<=1;
			a^=c;
			System.out.println(a+" "+b+" "+c);
			
			 Map<String, String> p =new LinkedHashMap<String, String>();
			 
			
					
	}

}
