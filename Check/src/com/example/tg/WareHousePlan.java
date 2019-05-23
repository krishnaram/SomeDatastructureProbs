package com.example.tg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WareHousePlan  {

	public static void main(String[] args)
	{
		//No 2 employee can have same designation
		//Output
		//designatio#jobids
		//W1#107#106
		//W2#108#105#102
		//W3#104#103#109
		//W4#110#101
		//
		//EXP:Here W2 and w3 work on their designated jobs as there are no skill clash.
		//There is skills clash between W1 and W4.
		//W1 will take job 107 which takes 15hours to completew4 will take job 110 5hr to complete and then took job 101 and complete it in 10hours
		//both consumed 15hrs to complete the job
		//Now, the work with job id 106 is remaining and w1 will take the job as it has edge of designation over the other employee w4
		//Input 1(No 2 employee have same designation, so w1 wont repeat again)
		//W1- Designation S1- skill
		//W1#S1
		//Input 2
		//S1-work 40-priority 10-hours needed 101- job id
		//S1#40#10#101
		//On priority basis task will get assigned to designation
		/*
		 * String[] input1 = {"W1#S1","W2#S2","W3#S3","W4#S1"};
		String[] input2 = {  "S1#40#10#101"
							,"S2#10#5#102"
							,"S3#90#15#103"
							,"S3#91#20#104"
							,"S2#20#5#105"
							,"S1#20#10#106"
							,"S1#90#15#107"
							,"S2#30#20#108"
							,"S3#40#5#109"
							,"S1#50#5#110"};
		 */
		String[] input1 = {"W1#S1","W2#S2","W3#S1","W4#S1","W5#S1"};
		String[] input2 = {  "S1#9#10#100"
							,"S2#8#9#101"
							,"S1#10#7#102"
							,"S1#10#11#103"
							,"S1#10#12#104"
							,"S1#10#13#105"
							,"S1#10#20#106"
							,"S1#10#20#107"
							,"S1#10#10#108"
							,"S1#10#5#109"};
		String[] output = warehouseScalability(input1,input2);
		for(int i=0;i<output.length;i++)
		{
			System.out.println(output[i]);
		}
		
	}
	
	public static String[] warehouseScalability(String[] input1,String[] input2)
    {
		
		Map<String,Long> workInProgress = new LinkedHashMap<String,Long>();
		Map<String,String> designationSkillPerson = new LinkedHashMap<String,String>();
		List<String> skill = new ArrayList<String>();
		List<String> jobId = new ArrayList<String>();
		List<Long> workHour = new ArrayList<Long>();
		List<Long> priority = new ArrayList<Long>();
		
		List<String> output = new ArrayList<String>();
		
		String[] temp;
		for(String s:input1)
		{
			temp = s.split("#");
			designationSkillPerson.put(temp[0],temp[1]);
			workInProgress.put(temp[0], 0L);
			output.add(temp[0]);
		}
		
		for(String s:input2)
		{
			
			temp = s.split("#");
			skill.add(temp[0]);
			priority.add(Long.parseLong(temp[1]));
			workHour.add(Long.parseLong(temp[2]));
			jobId.add(temp[3]);
		}
		
		   int n = priority.size();  
	        Long tem = 0L;
	        String temString = new String();
	      //swap elements on priority 
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(priority.get(j-1) < priority.get(j)){  
	                                
	                        	  	tem = priority.get(j);  
	                                priority.set(j,priority.get(j-1));  
	                                priority.set(j-1,tem);
	                                
	                                tem = workHour.get(j);  
	                                workHour.set(j,workHour.get(j-1));  
	                                workHour.set(j-1,tem);
	                                
	                                temString = jobId.get(j);  
	                                jobId.set(j,jobId.get(j-1));  
	                                jobId.set(j-1,temString);
	                                
	                                temString = skill.get(j);  
	                                skill.set(j,skill.get(j-1));  
	                                skill.set(j-1,temString);
	                         }  
	                          
	                 }  
	         }  
			//Swap elements on work hours desc and with priority
	         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(priority.get(j-1) == priority.get(j)){  
                                
                        	  if(workHour.get(j-1)>workHour.get(j))
                        	  {
                        		  tem = priority.get(j);  
                                  priority.set(j,priority.get(j-1));  
                                  priority.set(j-1,tem);
                                  
                                  tem = workHour.get(j);  
                                  workHour.set(j,workHour.get(j-1));  
                                  workHour.set(j-1,tem);
                                  
                                  temString = jobId.get(j);  
                                  jobId.set(j,jobId.get(j-1));  
                                  jobId.set(j-1,temString);
                                  
                                  temString = skill.get(j);  
                                  skill.set(j,skill.get(j-1));  
                                  skill.set(j-1,temString);
                        	  }
                        	  	
                         }  
                          
                 }  
         }  
	         
		List<String> tempList = new ArrayList<String>();
		
		Long time = 0L;
		Long tempTime = 0L;
		String desgnationToRewared = new String();
		boolean alreayAssigned = false;
		
		//Loop on Jobs
		int i = 0;
		for(String s: skill)
		{
			alreayAssigned = false;
			time = 0L;
			tempTime = 0L;
			tempList = skillRepeat(designationSkillPerson,s);
			
			//Designation which job to be rewarded
			desgnationToRewared = getLeastOneHighDegn(tempList,workInProgress);
			
			//Only when the designations are more for a skill
			if(tempList.size()>=2)
			{
				//If there is any designation not assigned job means it is having 0 as time
				for(String wDsg: tempList)
				{
					if(workInProgress.get(wDsg) == 0)
					{
						workInProgress.put(desgnationToRewared, workHour.get(i));
						alreayAssigned = true;
						break;
					}
				}
				//It will deduct the time which is assigned before to same skill for other designation
				if(alreayAssigned == false)
				{
					for(String wDsg: tempList)
					{
						
							time = workInProgress.get(wDsg);
							tempTime = time - workHour.get(i);
							if(!wDsg.equals(desgnationToRewared) && tempTime > 0L)
							{
								workInProgress.put(wDsg, tempTime);
							}
							else if(!wDsg.equals(desgnationToRewared) && tempTime <= 0L)
							{
								workInProgress.put(wDsg, 0L);
							}
							else{
								workInProgress.put(desgnationToRewared, workHour.get(i));
							}
						
						
					}
				}
				
			}
			else{
				workInProgress.put(desgnationToRewared, 0L);
				
			}
			int j = 0; 
			for(String d:output)
			{
				if(d.contains(desgnationToRewared))
				{
					String tempJobId = jobId.get(i);
					output.set(j, d+"#"+tempJobId);
				}
				j++;
			}
			i++;
		}
		//Output converted to array
		String[] outputArray = new String[output.size()];
		for(int k= 0;k<output.size();k++)
		{
			outputArray[k] = output.get(k);
		}
	    
		return outputArray;
    }
	
	static List<String> skillRepeat(Map<String,String> designationSkillPerson, String skill) 
    {
        List<String> designations = new ArrayList<String>();
         for (String desgn:designationSkillPerson.keySet()) 
        {
        	 if (designationSkillPerson.get(desgn).equals(skill))
        	 {
        		designations.add(desgn);
        	 }

        }
         
        return designations;
    }
	
	static String getLeastOneHighDegn(List<String> desgnList,Map<String,Long> workInProgress ) 
    {
        String designation = desgnList.get(0);
        Long least = workInProgress.get(desgnList.get(0));
        for (String desgn:desgnList) 
        {
        	 if(least > workInProgress.get(desgn))
        	 {
        		 designation =  desgn;
        		 least = workInProgress.get(desgn);
        	 }
        }
        for (String desgn:desgnList) 
        {
        	workInProgress.put(desgn, workInProgress.get(desgn)-least);
        }
        return designation;
    }
}

class Jobb implements Comparable<Jobb>{

	@Override
	public int compareTo(Jobb o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
/*class Job implements Comparator<Job>{
	private Long priority;
	private String jobId;
	private String skill;
	private Long hour;

	public Job(Long priority,String jobId,String skill,Long hour)
	{
		this.skill = skill;
		this.priority = priority;
		this.hour = hour;
		this.jobId = jobId;
	}
	public Job(){
		
	}
	
	//Jobs sorted on descending order of priority
	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		int value = 0; 
		if(o1.priority > o2.priority)
			value = -1;
		else if (o1.priority < o2.priority) 
            value = 1; 
        else if (o1.priority == o2.priority) 
            value = 0; 
		return value;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Long getHour() {
		return hour;
	}

	public void setHour(Long hour) {
		this.hour = hour;
	}
	
	
}

//loop on designation and skills
			for(String dsg:tempList)
			{
				//If designation person have dat skill
				if(designationSkillPerson.get(dsg).equals(s.skill))
				{
					
					
					//if work in progress designation have 0 as work hours
					if(workInProgress.get(dsg) == 0L)
					{
						
						//If skill is repeated in other person designation
						if(tempList.size()>=2)
						{
							//It will deduct the time which is assigned before to same skill for other designation
							for(String wDsg: tempList)
							{
								
									time = workInProgress.get(wDsg);
									tempTime = time - s.hour;
									if(tempTime > 0L || wDsg.equals(dsg) )
									{
										workInProgress.put(dsg, s.hour);
										break;
									}
									else{
										workInProgress.put(wDsg, 0L);
									}
								
								
							}
						}
						else{
							workInProgress.put(dsg, 0L);
							
						}
						int j = 0; 
						for(String d:output)
						{
							if(d.contains(dsg))
							{
								String tempJobId = s.jobId;
								output.set(j, d+"#"+tempJobId);
							}
							j++;
						}
						break;
					}
					
				}
			}*/


