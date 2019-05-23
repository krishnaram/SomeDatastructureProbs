package com.example.tg;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthProviderFinal {
	
	public static void main(String[] args)
	{
		//A:FRIEND:D#A:BLOOD_RELATION:B#A:PROF_RELATION:C#B:PROF_RELATION:C
		//A:100#B:100#C:100#D:100
		//C 
		//ans- 287.20
		
		//A:FRIEND:D#A:BLOOD_RELATION:B#A:PROF_RELATION:C#B:PROF_RELATION:C#B:FRIEND:D#D:PROF_RELATION:C
		//A:100#B:100#C:100#D:100
		//C 
		//ans - 485.60 
		
		String input1 = "A:FRIEND:D#A:BLOOD_RELATION:B#A:PROF_RELATION:C#B:PROF_RELATION:C#B:FRIEND:D#D:PROF_RELATION:C";
		String input2 = "A:100#B:100#C:100#D:100";
		String input3 = "C";
		
		Map<String,Double> score = new HashMap<String,Double>();
		
		String[] eachRelation = input1.split("#");
		String[] eachScore = input2.split("#");
		
		List<String> relationOperator = new ArrayList<String>();
		List<String> firstPerson = new ArrayList<String>();
		List<String> secondPerson = new ArrayList<String>();
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		String result = null;
		
		
		String[] temp;
		try{
			for(String str:eachRelation)
			{
				temp = str.split(":");
				firstPerson.add(temp[0]);
				relationOperator.add(temp[1]);
				secondPerson.add(temp[2]);
				firstPerson.add(temp[2]);
				relationOperator.add(temp[1]);
				secondPerson.add(temp[0]);
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			 result = df.format(new Double(0.00));
			 System.out.println("Result "+result);
			 System.exit(1);
		}
		
		
		try{
    		for(String str:eachScore)
    		{
    			temp = str.split(":");
    			score.put(temp[0],Double.parseDouble(temp[1]));
    		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			 result = df.format(new Double(0.00));
			 System.out.println("Result "+result);
			 System.exit(1);
			 
		}
		int i = 0;
		
	
		List<String> interRelationOperator = new ArrayList<String>();
		List<String> interFirstPerson = new ArrayList<String>();
		List<String> interSecondPerson = new ArrayList<String>();
		
		for(String rel:relationOperator)
		{
			if(!secondPerson.get(i).equals(input3))
			{
				interRelationOperator.add(rel);
				interFirstPerson.add(firstPerson.get(i));
				interSecondPerson.add(secondPerson.get(i));
			}
			i++;
		}
		
		relationOperator = interRelationOperator;
		firstPerson = interFirstPerson;
		secondPerson = interSecondPerson;
		
		i = 0;
		
		if(relationOperator.size() == firstPerson.size() && secondPerson.size() == firstPerson.size() )
		{
			 result = df.format(getScore(relationOperator,firstPerson,secondPerson,input3,input3,score));
		}
		else{
			 result = df.format(new Double(0.00));
		}
		
		System.out.println(result+" for "+input3);
		System.out.println(score.get("A")+" for A");
		System.out.println(score.get("B")+" for B");
		System.out.println(score.get("D")+" for D");
		
	}

	/*public Double getScore(List<String> relationOperator,List<String> firstPerson,List<String> secondPerson,String strIn,String strRes,Map<String,Double> score)
	{
		Double tempSum1 = 0.0;
		Double sum =0.0;
		int i = 0;
		int j = 0;
		
		
		List<String> interRelationOperator = new ArrayList<String>();
		List<String> interFirstPerson = new ArrayList<String>();
		List<String> interSecondPerson = new ArrayList<String>();
		
		List<String> passRelationOperator = new ArrayList<String>();
		List<String> passFirstPerson = new ArrayList<String>();
		List<String> passSecondPerson = new ArrayList<String>();
		
		//Removes other than first relation from the array list
		// If A comes then only A with first relation considered
		for(String rel:relationOperator)
		{
			if(firstPerson.get(i).equals(strIn))
			{
				interFirstPerson.add(firstPerson.get(i));
				interRelationOperator.add(rel);
				interSecondPerson.add(secondPerson.get(i));
			}
			i++;
		}
		 
		i = 0;
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Passed");
		System.out.println("For: "+strIn);
		printList(firstPerson, relationOperator, secondPerson);
		System.out.println("---------------------------------------------------------------------------------");
		
		
		printList(interFirstPerson, interRelationOperator, interSecondPerson);
	
			
			
		tempSum1 = score.get(strIn);
		sum = sum+ tempSum1;
		System.out.println("In last node:"+strIn+" sum"+tempSum1);
		
		
		for(String rel:interRelationOperator)
		{
			passRelationOperator = new ArrayList<String>();
			passFirstPerson = new ArrayList<String>();
			passSecondPerson = new ArrayList<String>();
			if(interFirstPerson.contains(strIn) && (!interFirstPerson.contains(strRes) || strIn.equals(strRes)))
			{
				tempSum1 = 0.0;
				if(rel.equals("BLOOD_RELATION"))
				{
					//Removes  than which having second relation as strIn from the array list
					// If A comes then only A with second relation removed
					for(String reltn:relationOperator)
					{
						if(!secondPerson.get(j).equals(strIn))
						{
							passFirstPerson.add(firstPerson.get(j));
							passRelationOperator.add(reltn);
							passSecondPerson.add(secondPerson.get(j));
						}
						j++;
					}
					j = 0;
					if(passFirstPerson.size() >= 1)
					{
						//System.out.println("-->Inside For: ");
						//printList(passFirstPerson, passRelationOperator, passSecondPerson);
						tempSum1 =  (0.8*getScore(passRelationOperator,passFirstPerson,passSecondPerson,interSecondPerson.get(i),strRes,score));
						System.out.println("BR In last node:"+strIn+" secondperson"+interSecondPerson.get(i)+" sum"+tempSum1);
					}
					else{
						
						tempSum1 = 0.8 * score.get(interSecondPerson.get(i));
						//System.out.println("BR In last node:"+strIn+" secondperson"+interSecondPerson.get(i)+" sum"+tempSum1);
					}
					
				}
				else if(rel.equals("FRIEND"))
				{

					//Removes  than which having second relation as strIn from the array list
					// If A comes then only A with second relation removed
					for(String reltn:relationOperator)
					{
						if(!secondPerson.get(j).equals(strIn))
						{
							passFirstPerson.add(firstPerson.get(j));
							passRelationOperator.add(reltn);
							passSecondPerson.add(secondPerson.get(j));
						}
						j++;
					}
					j = 0;
					if(passFirstPerson.size() >= 1)
					{
						//System.out.println("-->Inside For: ");
						//printList(passFirstPerson, passRelationOperator, passSecondPerson);
						tempSum1 = (0.6*getScore(passRelationOperator,passFirstPerson,passSecondPerson,interSecondPerson.get(i),strRes,score));
						System.out.println("FR In last node:"+strIn+" secondperson"+interSecondPerson.get(i)+" sum"+tempSum1);
					}
					else{
						tempSum1 =  score.get(interSecondPerson.get(i));
						//System.out.println("FR In last node:"+strIn+" secondperson"+interSecondPerson.get(i)+" sum"+tempSum1);
					}
				}
				else if(rel.equals("PROF_RELATION"))
				{

					//Removes  than which having second relation as strIn from the array list
					// If A comes then only A with second relation removed
					for(String reltn:relationOperator)
					{
						if(!secondPerson.get(j).equals(strIn))
						{
							passFirstPerson.add(firstPerson.get(j));
							passRelationOperator.add(reltn);
							passSecondPerson.add(secondPerson.get(j));
						}
						j++;
					}
					j = 0;
					if(passFirstPerson.size() >= 1)
					{
						//System.out.println("-->Inside For: ");
						//printList(passFirstPerson, passRelationOperator, passSecondPerson);
						tempSum1 = (0.4*getScore(passRelationOperator,passFirstPerson,passSecondPerson,interSecondPerson.get(i),strRes,score));
						System.out.println("PR In last node:"+strIn+" secondperson"+interSecondPerson.get(i)+" sum"+tempSum1);
					}
					else{
						
						tempSum1 = 0.4 * score.get(interSecondPerson.get(i));
						System.out.println("PR In last node:"+strIn+" secondperson"+interSecondPerson.get(i)+" sum"+tempSum1);
					}
				}
				sum = sum+ tempSum1;
			}
			i++;
		}
		
		
		//System.out.println("---------------------------------------------------------------------------------");
		return sum;
	}*/
	public static Double getScore(List<String> relationOperator,List<String> firstPerson,List<String> secondPerson,String strIn,String strRes,Map<String,Double> score)
	{
		Double tempSum1 = 0.0;
		Double sum =0.0;
		int i = 0;
		int j = 0;
		
		
		List<String> interRelationOperator = new ArrayList<String>();
		List<String> interFirstPerson = new ArrayList<String>();
		List<String> interSecondPerson = new ArrayList<String>();
		
		List<String> passRelationOperator = new ArrayList<String>();
		List<String> passFirstPerson = new ArrayList<String>();
		List<String> passSecondPerson = new ArrayList<String>();
		
		//Removes other than first relation from the array list
		// If A comes then only A with first relation considered
		for(String rel:relationOperator)
		{
			if(firstPerson.get(i).equals(strIn))
			{
				interFirstPerson.add(firstPerson.get(i));
				interRelationOperator.add(rel);
				interSecondPerson.add(secondPerson.get(i));
			}
			i++;
		}
		 
		i = 0;
		
		
		
			
		tempSum1 = score.get(strIn);
		sum = sum+ tempSum1;
		
		
		for(String rel:interRelationOperator)
		{
			passRelationOperator = new ArrayList<String>();
			passFirstPerson = new ArrayList<String>();
			passSecondPerson = new ArrayList<String>();
			if(interFirstPerson.contains(strIn) && (!interFirstPerson.contains(strRes) || strIn.equals(strRes)))
			{
				tempSum1 = 0.0;
				if(rel.equals("BLOOD_RELATION"))
				{
					//Removes  than which having second relation as strIn from the array list
					// If A comes then only A with second relation removed
					for(String reltn:relationOperator)
					{
						if(!secondPerson.get(j).equals(strIn))
						{
							passFirstPerson.add(firstPerson.get(j));
							passRelationOperator.add(reltn);
							passSecondPerson.add(secondPerson.get(j));
						}
						j++;
					}
					j = 0;
					if(passFirstPerson.size() >= 1)
					{
						tempSum1 =  (0.8*getScore(passRelationOperator,passFirstPerson,passSecondPerson,interSecondPerson.get(i),strRes,score));
					
					}
					else{
						
						tempSum1 = 0.8 * score.get(interSecondPerson.get(i));
						
					}
					
				}
				else if(rel.equals("FRIEND"))
				{

					//Removes  than which having second relation as strIn from the array list
					// If A comes then only A with second relation removed
					for(String reltn:relationOperator)
					{
						if(!secondPerson.get(j).equals(strIn))
						{
							passFirstPerson.add(firstPerson.get(j));
							passRelationOperator.add(reltn);
							passSecondPerson.add(secondPerson.get(j));
						}
						j++;
					}
					j = 0;
					if(passFirstPerson.size() >= 1)
					{
						tempSum1 = (0.6*getScore(passRelationOperator,passFirstPerson,passSecondPerson,interSecondPerson.get(i),strRes,score));
						
					}
					else{
						tempSum1 =  score.get(interSecondPerson.get(i));
					
					}
				}
				else if(rel.equals("PROF_RELATION"))
				{

					//Removes  than which having second relation as strIn from the array list
					// If A comes then only A with second relation removed
					for(String reltn:relationOperator)
					{
						if(!secondPerson.get(j).equals(strIn))
						{
							passFirstPerson.add(firstPerson.get(j));
							passRelationOperator.add(reltn);
							passSecondPerson.add(secondPerson.get(j));
						}
						j++;
					}
					j = 0;
					if(passFirstPerson.size() >= 1)
					{
						//System.out.println("-->Inside For: ");
						//printList(passFirstPerson, passRelationOperator, passSecondPerson);
						tempSum1 = (0.4*getScore(passRelationOperator,passFirstPerson,passSecondPerson,interSecondPerson.get(i),strRes,score));
						
					}
					else{
						
						tempSum1 = 0.4 * score.get(interSecondPerson.get(i));
						
					}
				}
				sum = sum+ tempSum1;
			}
			i++;
		}
		return sum;
	}
	/*public Double getScore(List<String> relationOperator,List<String> firstPerson,List<String> secondPerson,String strIn,String strRes,Map<String,Double> score,List<String> considered)
	{
		Double tempSum1 = 0.0;
		Double sum =0.0;
		int i = 0;
		
		
		considered.add(strIn);
		
		List<String> interConsidered = new ArrayList<String>();
		for(String str:considered)
		{
			interConsidered.add(str);
		}
		List<String> interRelationOperator = new ArrayList<String>();
		List<String> interFirstPerson = new ArrayList<String>();
		List<String> interSecondPerson = new ArrayList<String>();
		
		List<String> interSecRelationOperator = new ArrayList<String>();
		List<String> interSecFirstPerson = new ArrayList<String>();
		List<String> interSecSecondPerson = new ArrayList<String>();
		for(String rel:relationOperator)
		{
			if(firstPerson.get(i).equals(strIn))
			{
				interFirstPerson.add(firstPerson.get(i));
				interRelationOperator.add(rel);
				interSecondPerson.add(secondPerson.get(i));
			}
			i++;
		}
		i = 0;
		for(String rel:relationOperator)
		{
			if(!secondPerson.get(i).equals(strIn))
			{
				interSecRelationOperator.add(rel);
				interSecFirstPerson.add(firstPerson.get(i));
				interSecSecondPerson.add(secondPerson.get(i));
			}
			i++;
		}
		i = 0;
		System.out.println("For :"+strIn);
		printList(interFirstPerson, interRelationOperator, interSecondPerson);
		for(String rel:interRelationOperator)
		{
			if(interFirstPerson.contains(strIn) && (!interFirstPerson.contains(strRes) || strIn.equals(strRes)))
			{
				tempSum1 = 0.0;
				if(rel.equals("BLOOD_RELATION"))
				{
					if(interConsidered.contains(interSecondPerson.get(i)))
					{
						tempSum1 = 0.8*score.get(interFirstPerson.get(i));
						//System.out.println("First person "+interFirstPerson.get(i)+" relation " +rel+ " second person "+interSecondPerson.get(i));
					}
					else{
						tempSum1 = getScore(interSecRelationOperator,interSecFirstPerson,interSecSecondPerson,interSecondPerson.get(i),strRes,score,interConsidered);
						//System.out.println("Not in First person "+interFirstPerson.get(i)+" relation " +rel+ " second person "+interSecondPerson.get(i));
					}
				
				}
				else if(rel.equals("FRIEND"))
				{
					if(interConsidered.contains(interSecondPerson.get(i)))
					{
						tempSum1 = 0.6*score.get(interFirstPerson.get(i));
						//System.out.println("First person "+interFirstPerson.get(i)+" relation " +rel+ " second person "+interSecondPerson.get(i));
					}
					else{
					tempSum1 = getScore(interSecRelationOperator,interSecFirstPerson,interSecSecondPerson,interSecondPerson.get(i),strRes,score,interConsidered);
					//System.out.println("Not in First person "+interFirstPerson.get(i)+" relation " +rel+ " second person "+interSecondPerson.get(i));
					}
					
				}
				else if(rel.equals("PROF_RELATION"))
				{
					if(interConsidered.contains(interSecondPerson.get(i)))
					{
						tempSum1 = 0.4*score.get(interFirstPerson.get(i));
						//System.out.println("First person "+interFirstPerson.get(i)+" relation " +rel+ " second person "+interSecondPerson.get(i));
					}
					else{
						tempSum1 = getScore(interSecRelationOperator,interSecFirstPerson,interSecSecondPerson,interSecondPerson.get(i),strRes,score,interConsidered);
						//System.out.println("Not in First person "+interFirstPerson.get(i)+" relation " +rel+ " second person "+interSecondPerson.get(i));
					}
				}
				if(tempSum1 >0)
				{
					System.out.println("Temp sum: "+tempSum1);
					sum = sum+tempSum1;
				}
				
				
			}
			//System.out.println("Sum = "+sum);
			i++;
		}
		if(sum > 0)
		{
			sum = sum+ score.get(strIn);
		}
		return sum;
		
	}*/
	public void printList(List<String> a, List<String> b, List<String> c)
	{
		for(int i = 0;i< a.size();i++)
		{
			System.out.println(a.get(i)+" "+b.get(i)+" "+c.get(i));
		}
	}
}
