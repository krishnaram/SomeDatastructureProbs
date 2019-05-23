package com.example.tg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ConnectedComps {

	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
        */
        //BufferedReader
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        String[] strs= line.trim().split("\\s+");
	        
	        int n = Integer.parseInt(strs[0]);
	        int m =  Integer.parseInt(strs[1]);
	        

	        //Scanner
	        /*Scanner s = new Scanner(System.in);
	        */
	        Long comp;
	        Long direction;
	         ArrayList<Long> directionList;
	       Map<Long,ArrayList<Long>> cP = new HashMap<Long,ArrayList<Long>>();
	        for (int i = 0; i < m; i++) {
	            line = br.readLine();
	            strs= line.trim().split("\\s+");
	            
	            comp = Long.parseLong(strs[0]);
	            direction = Long.parseLong(strs[1]);
	            directionList = cP.get(comp);
	            if(cP.get(comp) != null && cP.get(comp).size() >= 1)
	            {
	                directionList.add(direction);    
	            }
	            else{
	                directionList = new ArrayList<Long>();
	                directionList.add(direction);
	                cP.put(comp,directionList);
	            }
	            directionList = cP.get(direction);
	            if(cP.get(direction) != null &&cP.get(direction).size() >= 1)
	            {
	                directionList.add(comp);    
	            }
	            else{
	                directionList = new ArrayList<Long>();
	                directionList.add(comp);
	                cP.put(direction,directionList);
	            }
	            
	        }
	        ArrayList<Long> tempPath;
	        boolean flag = false;
	        for(Long  compNode:cP.keySet())
	        {
	        	tempPath = (ArrayList<Long>) cP.get(compNode).clone();
	        	cP.put(compNode, new ArrayList<Long>());
	        	flag = findWay(cP);
	        	
	        	if(flag == false)
	        	{
	        		break;
	        	}
	        	cP.put(compNode, tempPath);
	        }
	        if(flag)
	        {
	        	System.out.println("Safe");
	        }
	        else{
	        	System.out.println("Unsafe");
	        }
		}
		catch(Exception e)
		{
			System.out.println("Unsafe");
		}
        
    }
	
	public static boolean findWay(Map<Long,ArrayList<Long>> cP)
	{
		ArrayList<Long> tempPath;
		HashSet<Long> visitedNodes = new HashSet<Long>();
		 for(Long  compNode:cP.keySet())
	        {
	        	tempPath =  cP.get(compNode);
	        	if(tempPath!=null && tempPath.size()>=1)
	        	{
	        		for(Long nextNode:tempPath)
		        	{
		        		if(!visitedNodes.contains(nextNode))
		        		{
		        			visitedNodes.add(nextNode);
		        		}
		        		
		        	}
	        	}
	        	
	        }
		 if(visitedNodes.size() == cP.size())
		 {
			 return true;
		 }
		return false;
	}

}
