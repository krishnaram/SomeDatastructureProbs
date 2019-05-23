package com.example.tg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HereC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] roads = { "2#3", "1#2", "1#5", "2#5", "3#4", "4#5", "4#6","1#6" ,"3#6","2#6","1#3","5#6","1#4","6#7"};
		int minRoads = minRoads(roads);
		System.out.println("Min roads to break "+minRoads);
	}

	//Got 100% in first submit 0.075 Sec
	public static int minRoads(String[] input1) {
		Set<Long> cities = new HashSet<Long>();
		String[] twoCities;
		ArrayList<Long> pathNode = new ArrayList<Long>();
		ArrayList<Long> pathNode2 = new ArrayList<Long>();

		HashMap<Long,HashSet<Long>> nodeConnected = new HashMap<Long,HashSet<Long>>();
		for (String path : input1) {
			twoCities = path.split("#");
			if(twoCities.length == 2)
			{
				if(nodeConnected.get(Long.parseLong(twoCities[0])) != null)
				{
					nodeConnected.get(Long.parseLong(twoCities[0])).add(Long.parseLong(twoCities[1]));
				}
				if(nodeConnected.get(Long.parseLong(twoCities[1])) != null)
				{
					nodeConnected.get(Long.parseLong(twoCities[1])).add(Long.parseLong(twoCities[0]));
				}
				if(nodeConnected.get(Long.parseLong(twoCities[0])) == null)
				{
					nodeConnected.put(Long.parseLong(twoCities[0]),new HashSet<Long>());
					nodeConnected.get(Long.parseLong(twoCities[0])).add(Long.parseLong(twoCities[1]));
				}
				if(nodeConnected.get(Long.parseLong(twoCities[1])) == null)
				{
					nodeConnected.put(Long.parseLong(twoCities[1]),new HashSet<Long>());
					nodeConnected.get(Long.parseLong(twoCities[1])).add(Long.parseLong(twoCities[0]));
				}
				cities.add(Long.parseLong(twoCities[0]));
				cities.add(Long.parseLong(twoCities[1]));
			}
			else{
				return 0;
			}
		}
	
		
		
		
		Long baseStationOne = getMin(cities);
		Long baseStationTwo = getMax(cities);
		int i = 0;
		int count = input1.length;
		HashSet<Long> tempSet = new HashSet<Long>();
		HashSet<Long> initialSet = new HashSet<Long>();
		for(Long node:nodeConnected.keySet())
		{
			i=0;
			initialSet = nodeConnected.get(node);
			tempSet=(HashSet)initialSet.clone();
			for(Long path:initialSet)
			{
				i++;
				
				tempSet.remove(path);
				nodeConnected.put(node,tempSet);
				//printList(tempSet);
				if(findWay(baseStationOne, baseStationTwo, nodeConnected, baseStationOne,new ArrayList<Long>(),tempSet,node))
				{
					//printList(tempSet);
					continue;
				}
				else{
					if(count>i)
					{
						//printList(tempSet);
						count = i;
					}
					break;
				}
				
			}
			nodeConnected.put(node,initialSet);
			
		}
		//System.out.println(baseStationOne);
		//System.out.println(baseStationTwo);
		ArrayList<Long> interMediate = new ArrayList<Long>(pathNode) ;
		ArrayList<Long> interMediate2 = new ArrayList<Long>(pathNode2) ;
		ArrayList<Number> interMediate3 = new ArrayList<Number>();
		interMediate3.add(new Integer(4));
		String mn = "Krishna";
		mn+="ram";
		
		int minPath = pathNode.size()*2;
		
		
		return count;
		// Write code here
	}

	public static Long getMin(Set<Long> cities) {
		Long min = null;
		for (Long l : cities) {
			if (min == null) {
				min = l;
				continue;
			}
			if (min.intValue() > l.intValue()) {
				min = l;
			}
		}
		return min;
	}

	public static Long getMax(Set<Long> cities) {
		Long max = null;
		for (Long l : cities) {
			if (max == null) {
				max = l;
				continue;
			}
			if (max.intValue() < l.intValue()) {
				max = l;
			}
		}
		return max;
	}
	
	public static boolean findWay(Long source,Long destination,HashMap<Long,HashSet<Long>> pathNodes,Long startPoint,ArrayList<Long> visited, HashSet<Long> tempSet, Long node) {
		//System.out.println("---------------------------------------------------------------------------------------");
		boolean flag = false;
		if(startPoint == destination)
		{
			return true;
		}
		
		//printList(pathNodes.get(startPoint));
		for(Long point:pathNodes.get(startPoint))
		{
			if(point == node && !tempSet.contains(startPoint))
			{
				continue;
			}
				if(!visited.contains(point) && point != 0L)
				{
					visited.add(point);
					flag = findWay(source, destination, pathNodes, point, visited,tempSet,node);
					if(flag)
						break;
				}
		}
		
		//System.out.println("---------------------------------------------------------------------------------------");
		return flag;
	}
	
	public static void printList(HashSet<Long> list)
	{
		for(Long i:list)
		{
			System.out.print(i+",");
		}
		System.out.println();
	}

}

/*ArrayList<Long> path = new ArrayList<Long>();

for(int i = 0;i<pathNode.size();i++)
{
	if(pathNode.get(i) != null)
	{
		if(path.size() ==0 && pathNode.get(i) == source)
		{
			path.add(pathNode.get(i));
		}
		else if(path.size() ==0 && pathNode2.get(i) == source)
		{
			path.add(pathNode2.get(i));
		}
		else if(path.size()> 0 && pathNode.get(i) ==path.get(path.size()-1))
		{
			path.add(pathNode2.get(i));
		}
		else if(path.size()> 0 && pathNode2.get(i) ==path.get(path.size()-1))
		{
			path.add(pathNode.get(i));
		}
		
		if(path.size()> 0 && path.get(path.size()-1) ==  destination)
		{
			return true;
		}
		
	}
}*/

/*	Long temp;
for(int i=0; i < pathNode.size(); i++){  
    for(int j=1; j < (pathNode.size()-i); j++){
   	 if(pathNode.get(j-1) > pathNode.get(j)){
   		 temp = pathNode.get(j);  
   		 pathNode.set(j,pathNode.get(j-1));  
   		 pathNode.set(j-1,temp); 
   		 
   		 temp = pathNode2.get(j);  
   		 pathNode2.set(j,pathNode2.get(j-1));  
   		 pathNode2.set(j-1,temp); 
   	 }
   	 else if(pathNode2.get(j-1) > pathNode2.get(j)){
   		 temp = pathNode.get(j);  
   		 pathNode.set(j,pathNode.get(j-1));  
   		 pathNode.set(j-1,temp); 
   		 
   		 temp = pathNode2.get(j);  
   		 pathNode2.set(j,pathNode2.get(j-1));  
   		 pathNode2.set(j-1,temp);
   	 }
   	 
   
    }
}*/

/*
 * interMediate = pathNode.get(i);
			interMediate2 = pathNode2.get(i);
			if(pathNode.get(i) != baseStationOne && pathNode2.get(i) != baseStationOne)
			{
				pathNode.set(i,null);
				pathNode2.set(i,null);
			}
			
			
			if(!findWay(baseStationOne, baseStationTwo, pathNode, pathNode2 ))
			{
				return 1;
			}
			
			pathNode.set(i,interMediate);
			pathNode2.set(i,interMediate2);
			for(int i = 0;i<pathNode.size();i++)
		{
			interMediate = new ArrayList<Long>(pathNode) ;
			interMediate2 = new ArrayList<Long>(pathNode2) ;
			count = 0;
			interMediate.set(i,null);
			interMediate2.set(i,null);
			printList(interMediate);
			printList(interMediate2);
			count++;
			if(findWay(baseStationOne,baseStationTwo,interMediate,interMediate2) == false)
			{
				//System.out.println("In first block");
				if(count < minPath)
				{
					minPath = count;
				}
				continue;
			}
			else{
				for(int j = 0;j<pathNode.size();j++)
				{
					interMediate.set(j,null);
					interMediate2.set(j,null);
					//System.out.println("In else block");
					printList(interMediate);
					printList(interMediate2);
					count++;
					if(findWay(baseStationOne,baseStationTwo,interMediate,interMediate2)  == false)
					{
						if(count < minPath)
						{
							minPath = count;
						}
						continue;
					}
				}
			}
			
		}
		
		
*/