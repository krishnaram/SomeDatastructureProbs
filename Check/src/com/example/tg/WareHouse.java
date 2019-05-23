package com.example.tg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WareHouse {

	public static void main(String[] args)
	{
		//No 2 employee can have same designation
		//Output
		//designatio#jobids
		//W1#107#106
		//W2#108#105#102
		//W3#104#103#109
		//W4#110#101
		//W1#101#106#107#110, W2#102#105#108, W3#103#104#109, W4#101#106#107#110
		//EXP:Here W2 and w3 work on their designated jobs as there are no skill clash.
		//There is skills clash between W1 and W4.
		//W1 will take job 107 which takes 15hours to completew4 will take job 110 5hr to complete and then took job 101 and complete it in 10hours
		//both consumed 15hrs to complete the job
		//Now, the work with job id 106 is remaining and w1 will take the job as it has edge of designation over the other employee w4
		//Designation#skills
		//S1-work 40-(may be priority) 10-hours needed 101- job id
		String[] input1 = {"W1#S1","W2#S2","W3#S3","W4#S1"};
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
		
		
		List<String> output = new ArrayList<String>();
		
		String[] temp;
		for(String s:input1)
		{
			temp = s.split("#");
			designationSkillPerson.put(temp[0],temp[1]);
			workInProgress.put(temp[0], 0L);
			output.add(temp[0]);
		}
		
		List<Job> jobList = new ArrayList<Job>();
		Job job = null;
		for(String s:input2)
		{
			
			temp = s.split("#");
			job = new Job(Long.parseLong(temp[1]), temp[3], temp[0], Long.parseLong(temp[2]));
			jobList.add(job);
		}
		
		Collections.sort(jobList, new Job());
		
		
		List<String> tempList = new ArrayList<String>();
		
		Long time = 0L;
		Long tempTime = 0L;
		String desgnationToRewared = new String();
		
		//Loop on Jobs
		for(Job s: jobList)
		{
			time = 0L;
			tempTime = 0L;
			tempList = skillRepeat(designationSkillPerson,s.getSkill());
			
			//Designation which job to be rewarded
			desgnationToRewared = getLeastOneHighDegn(tempList,workInProgress);
			
			//Only when the designations are more for a skill
			if(tempList.size()>=2)
			{
				
				//It will deduct the time which is assigned before to same skill for other designation
				for(String wDsg: tempList)
				{
					
						time = workInProgress.get(wDsg);
						tempTime = time - s.getHour();
						if(!wDsg.equals(desgnationToRewared) && tempTime > 0L)
						{
							workInProgress.put(wDsg, tempTime);
						}
						else if(!wDsg.equals(desgnationToRewared) && tempTime <= 0L)
						{
							workInProgress.put(wDsg, 0L);
						}
						else{
							workInProgress.put(desgnationToRewared, s.getHour());
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
					String tempJobId = s.getJobId();
					output.set(j, d+"#"+tempJobId);
				}
				j++;
			}
			
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

class Job implements Comparator<Job>{
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
		/*	for(String dsg:tempList)
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

