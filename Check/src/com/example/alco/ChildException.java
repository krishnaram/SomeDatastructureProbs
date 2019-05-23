package com.example.alco;

public class ChildException extends ParentException{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			throw new ChildException();
		}
		catch(ChildException e)
		{
			System.out.println("In Child catch");
		}
		catch(ParentException e)
		{
			System.out.println("In Parent catch");
		}
	}

}
