package com.example.tg;

public class RajaBaja {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayOfMatrix = {"...","...","..."};
		int size =3;
		
		System.out.println(winnerCrown(size,arrayOfMatrix));
	}

	private static String winnerCrown(int size, String[] arrayOfMatrix) {
		// TODO Auto-generated method stub
		
		char[][] newCharMatrix = new char[size][size];
		char[] place;
		int count = 0;
		int crownRow;
		int crownCol = 0;
		boolean crownSet = false;
		for(String s:arrayOfMatrix)
		{
			
			place = s.toCharArray();
			if(!crownSet)
			{
				for(char crown:place)
				{
					if(crown == 'C')
					{
						crownRow = count;
						crownSet = true;
						break;
					}
					crownCol ++;
					
				}
			}
			
			newCharMatrix[0] = place;
			count++;
			crownCol = 0;
		}
		boolean moveRaja = true;
		int number;
		while(true)
		{
			number = (int)(Math.random()*1000)%3;
			switch(number)
			{
			case 0:
				moveUp();
				break;
			case 1:
				moveLeft()
				break;
			case 2:
				moveUpLeft();
				break;
			}
		}
		
		
		return null;
	}
	
	

}
