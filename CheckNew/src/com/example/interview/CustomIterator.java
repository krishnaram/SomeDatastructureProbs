package com.example.interview;

import java.util.ArrayList;
import java.util.Iterator;

class CustIterator<String> implements Iterable<String> {
	private String str;
	private int index;
	private ArrayList<String> myArrayList = new ArrayList<String>();

	public void add(String str) {
		this.myArrayList.add(str);
	}
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < myArrayList.size();
			}

			@Override
			public String next() {
				// TODO Auto-generated method stub
				str = (String) myArrayList.get(index); 
	            if (((java.lang.String) str).startsWith("ram"))
	                return (String) myArrayList.get(index++); 
	            index++; 
	            
				return null;
			}
		};
	}

}
public class CustomIterator{
	public static void main(String[] args) {
		CustIterator<String> newIterator = new CustIterator();
		newIterator.add("ram");
		newIterator.add("ramakrishna");
		newIterator.add("madhuri");
		newIterator.add("ramakrishnamadhuri");
		newIterator.add("ramdhuri");
		
		Iterator<String> newIt = newIterator.iterator();
		while(newIt.hasNext()) {
			System.out.println(newIt.next());
		}
	}
}
