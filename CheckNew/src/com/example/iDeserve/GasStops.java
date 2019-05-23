package com.example.iDeserve;

public class GasStops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "ramakrishna";
		String nameU = "RAMAKRISHNA";
		if(name.toUpperCase().equals(nameU)) {
			System.out.println("Equal");
		}
		int cap = 4;
		int a[] = {0,2,3,5,7,8};
		int fuelR = cap;
		int numOfStops = 0;
		for(int i =1;i<a.length-1;i++) {
			fuelR = fuelR-a[1];
			if(fuelR<(a[i]-a[i+1])) {
				System.out.println(" i"+a[i]+" i+1"+a[i+1]);
				numOfStops++;
				fuelR = cap;
			}
		}
		System.out.println(numOfStops);
		
	}

}
