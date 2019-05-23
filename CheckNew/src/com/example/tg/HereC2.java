package com.example.tg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Path Finder (100 Marks)

Problem Statement:

In a busy city, like Mumbai, a smart navigation system is required, which will take a user profile as its input, instead of just the source and destination. This profile includes the following parameters:

Source, destination, type of route (FASTEST / SHORTEST), start time and target time (time is specified in minutes, as an integer number starting from 0 and not timestamp)

Note: 
a) SHORTEST means path with minimum numbers of nodes between source and destination. 
b) FASTEST means fastest path between source and destination.

User Profile Example: (A,D,FASTEST,1,6)
The user will travel, only if, the user is able to reach the destination, on or before the specified target time.
Also, because of the heavy traffic, a rule is passed in the city, stating, only 1 vehicle can travel at a time on a given link. This is why, while calculating the travel time for a link, our smart navigation system should consider the time taken by the previous users, who have already decided to travel.
We need to build this system, which will take the profile(s) as input and prints the decisions of the user(s). ('Y' if the user will travel, else 'N')
Rules of the System:

Shortest/fastest path needs to be determined using the ideal travel time of the links at the beginning.
Actual travel time of the above path needs to be calculated, considering the output or all previously processed profiles. If any previous user's profile is chosen and if that user's route is in conflict with current user's path links, current user need to resolve the conflicts by waiting until a proper time window is found to travel on that link.
Check the actual time, calculated above, against target time, mentioned in the user profile, and take decision to travel or not.
Routes (in point 1) should be selected by considering only the ideal travel time and not the actual travel time calculated in point 2.
Current user cannot make previous users, whose decision was 'Y' to wait in any case.
If user profile is incorrect, then the decision for that user would be 'N'.
Input to the system (all without spaces):

Nodes (Comma separated)
Links - Are unidirectional and equal length, connecting the nodes and has ideal travel time (Comma separated)
Profile(s) (Comma separated)
Output from the system (all without spaces):

Comma separated decisions for corresponding to each profile.

Example:

Input: 
A,B,C,D,E,F
(A,B,1),(A,C,2),(B,E,1),(E,A,2),(E,D,1),(D,F,1),(D,C,3),(F,E,1),(F,D,1),(C,A,2),(C,D,3)
(A,F,FASTEST,1,6),(A,E,FASTEST,1,3),(A,D,SHORTEST,2,9),(A,E,FASTEST,3,5)

Output: 
Y,N,Y,Y 
Explanation:       Based on the Nodes and Links, we can prepare the below graph:

img

Now, for 1st user, source and destination are node A and node F respectively, with 'FASTEST' route. Also, it says that user will leave from node A on 1st min and would like to reach node F on or before 6th min.
Step 1: From the above graph, based on the ideal travel time, the fastest route is A-B-E-D-F.
Step 2: Actual travel time: 1+1+1+1 = 4
Step 3: User would reach node F on 5th min (1+4), which is less than 6. Hence result for this user is 'Y'

For 2nd user:
Step 1: Fastest route between A and E: A-B-E
Step 2: Because result of 1st user was 'Y', he will travel on A-B-E-D-F starting on 1st min. Since, only 1 user can travel at a time on any given link, this user would not be able to start on 1st min, and will have to wait until user 1 completely travels link A-B. Thus, this user will start on 2nd min and would reach node E on 4th min (No need to wait on B, since this user will reach B on 3rd min, at which point user 1 had already traveled link B-E)
Step 3: User would reach on 4th min, which is more than 3. Hence result for this profile is 'N'.

For 3rd User:
Step 1: Shortest route between A and D is A-C-D.
Step 2: Since no other previous accepted profile's path conflicts with this path, actual travel time is same as ideal travel time, which is 5 minutes.
Step 3: User would reach on 7th min, which is less than 9. Hence result for this profile is 'Y'.

For 4th User:
Step 1: Fastest route between A and E is A-B-E.
Step 2: Total travel time: 2 (No need to wait as by 3rd min, User 1 would have traveled link A-B, making it free for other users)
Step 3: User would reach on 5th min, which is equal to 5. Hence result for this profile is 'Y'.
 */
public class HereC2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getdecisions("A,B,C,D,E,F","(A,B,1),(A,C,2),(B,E,1),(E,A,2),(E,D,1),(D,F,1),(D,C,3),(F,E,1),(F,D,1),(C,A,2),(C,D,3)"
				,"(A,F,FASTEST,1,6),(A,E,FASTEST,1,3),(A,D,SHORTEST,2,9),(A,E,FASTEST,3,5)");
	}
	
	 public static String getdecisions(String input1,String input2,String input3)
	    {
		 String[] temp = input1.split(",");
		 String[] temp1 = input2.split(",");
		 String[] temp2 = input3.split(",");
		 String[] tempVar;
		 String[] source =new String[temp2.length];
		 String[] destination =new String[temp2.length];
		 String[] stratergy =new String[temp2.length];
		 int[] startTime =new int[temp2.length];
		 int[] endTime =new int[temp2.length];
		 
		 Map<String,Integer> timeBound = new HashMap<String, Integer>();
		 ArrayList<HashMap<String, Integer>> varListMap;
		 Map<String, Integer> varMap;
		 Map<String, ArrayList<HashMap<String, Integer>>> pathLink = new HashMap<String,ArrayList<HashMap<String,Integer>>>();
		 
		 for(int i=0;i<temp.length;i++)
		 {
			 pathLink.put(temp[i], new ArrayList<HashMap<String, Integer>>());
		 }
		 
		 for(int i=0;i<temp1.length;i++)
		 {
			 tempVar = temp1[i].replaceAll(")", "").replaceAll(")", "").split(",");
			 varListMap = pathLink.get(tempVar[0]);
			 if(varListMap == null)
			 {
				 varListMap = new ArrayList<HashMap<String,Integer>>();
				 varMap = new HashMap<String, Integer>();
				 varMap.put(tempVar[0], Integer.parseInt(tempVar[2]));
				 varListMap.add((HashMap<String, Integer>) varMap);
			 }
			 else{
				 varListMap.get(0).put(tempVar[0], Integer.parseInt(tempVar[2]));
			 }
		 }
		 
		 for(int i=0;i<temp2.length;i++)
		 {
			 tempVar= temp1[i].replaceAll(")", "").replaceAll(")", "").split(",");
			 source[i] = tempVar[0];
			 destination[i] = tempVar[1];
			 stratergy[i] = tempVar[2];
			 startTime[i] = Integer.parseInt(tempVar[3]);
			 endTime[i] = Integer.parseInt(tempVar[4]); 
		 }
		 
			return input3;
		    //Write code here
	    }
	 
	 public static ArrayList<String> shortestWay(String inter,String source,String destination,int totalTime,ArrayList<String> path,Map<String, ArrayList<HashMap<String, Integer>>> pathLink){
		
		 ArrayList<HashMap<String, Integer>> varListMap = pathLink.get(inter);
		 ArrayList<String> interPath = new ArrayList<String>();
		 for(HashMap<String, Integer> nodes:varListMap)
		 {
			 for(String point:nodes.keySet())
			 {
				 if(!path.contains(point))
				 {
					 interPath = (ArrayList<String>) path.clone();
					 //shortestWay(point,source,destination,totalTime)
				 }
			 }
			 
		 }
		 return path;	 
	 }
	 
	 public static ArrayList<String> fastestWay(String source,String destination,int totalTime){
		 ArrayList<String> path = new ArrayList<String>();
		 
		return path;	 
	 }
	 

}
