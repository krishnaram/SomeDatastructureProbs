package com.example.tg;

import java.util.Scanner;

public class SnakeAndLadder {

	/**
	 * @author rpanni
	 *
	 */
	/*
	 * 
	0 10 20 25
	20 30 40 50
	12 13 14 15
	18 19 20 25

	20 25 0 10 
	20 30 40 50
	12 13 14 15
	18 19 20 25

	0 25 0 10 
	20 30 40 50
	12 13 14 15
	18 19 20 25

	0 0 25 16
	5 7 18 10
	1 6 20 15
	0 5 7 8

	one ladder is used
	10 25 0 0
	0 1 24 24
	10 20 30 40
	60 70 80 90

	25 25 0 0
	0 1 24 24
	10 20 30 40
	60 70 80 90

	2 ladder

	45 50 0 4
	0 5 30 40
	41 30 45 45
	90 80 80 90

	2 ladder

	45 50 0 4
	0 5 30 40
	30 41 45 45
	90 80 80 90
	Ans:27

	45 50 0 4
	30 41 45 45
	90 80 80 90
	0 5 30 40
	Ans:27

	45 50 0 4
	30 41 45 45
	0 5 30 40
	90 80 80 90
	Ans:27

	45 50 0 4
	1000 2000 1 0
	30 41 45 45
	0 5 30 40
	Ans:27

	45 50 0 4
	45 50 0 4
	30 41 45 45
	0 5 30 40
	Ans:10

	45 50 0 4
	45 50 0 4
	30 41 45 45
	0 5 30 40
	Ans:10

	0 4 0 4
	45 50 0 4
	30 41 45 45
	0 5 30 40
	Ans:0

	45 50 0 4
	45 50 45 50
	30 41 45 45
	0 5 30 40
	ans:27

	0 0 10000 100000
	0 0 0 2
	0 3 0 5
	0 6 0 8
	Ans:110000

	0 0 10000 100000
	0 0 0 100000
	0 3 0 5
	0 6 0 8
	Ans:10010

	10000 0 0 100000
	0 100000 10000 0
	0 3 0 5
	0 6 0 8
	Ans:10010


	3 ladder

	45 50 0 4
	0 5 20 40
	20 41 35 45
	35 45 45 50
	Ans:32

	45 50 0 4
	20 41 35 45
	35 45 45 50
	0 5 20 40
	Ans:32

	45 50 0 4
	20 41 35 45
	0 5 20 40
	35 45 45 50
	Ans:32

	45 50 0 4
	20 41 35 45
	35 45 45 50
	0 5 20 40
	Ans:32

	45 50 0 4
	20 41 35 45
	0 5 20 40
	35 45 45 50
	Ans:32

	0 15000 0 2
	3 99999 0 14999
	4 5002 200 5002
	1 0 4 10000
	ans:5097

	0 10000 0 2
	3 99999 0 14999
	4 5002 200 5002
	1 0 4 10000
	ans:17

	0 10000 2 0
	3 99999 0 14999
	4 5002 200 5002
	1 0 4 10000
	ans:15

	0 10000 0 2
	3 99999 0 14999
	400 5002 200 5002
	1 0 400 10000
	ans:413

	0 10000 0 2
	3 99999 0 14999
	400 10002 200 10002
	1 0 400 10000

0 100 1000 1000
2000 4000 100 2000
30 40 100 102
50 60 100 110
ans:1890

0 0 0 22
0 0 0 8
0 9 0 15
0 10 1 22
ans:21

0 0 0 22
0 0 0 15
0 9 0 15
0 10 1 22
ans:17

0 0 0 22
0 0 0 22
0 9 0 15
0 10 1 22
ans: 10

0 0 0 22
0 2 0 12
0 9 0 15
0 10 4 22
ans:22

0 0 0 0
0 2 0 12
0 9 0 15
0 10 4 22
ans:0

0 0 0 100000
0 2 0 12
0 9 0 15
0 10 4 22
ans:100000

0 0 0 100000
0 2 0 12
0 9 0 15
0 10 0 220
ans:99800

0 0 0 100000
0 2 0 12
0 9 0 15
0 10 0 2000
ans:98020

0 0 0 100000
0 2 0 12000
0 9 0 15
0 10 0 2000
	 */

	public static void main(String[] str) throws Exception{
		Scanner sc = new Scanner(System.in);
		int[] sourceDestination = new int[4];
		int[][] ladder = new int[3][4];
		String[] srcDest = sc.nextLine().trim().split(" ");
		sourceDestination[0] = Integer.parseInt(srcDest[0])>=0 && Integer.parseInt(srcDest[0])<=1000000000? Integer.parseInt(srcDest[0]) : 1/0;
		sourceDestination[1] = Integer.parseInt(srcDest[1])>=0 && Integer.parseInt(srcDest[1])<=1000000000?Integer.parseInt(srcDest[1]):1/0;
		sourceDestination[2] = Integer.parseInt(srcDest[2])>=0 && Integer.parseInt(srcDest[2])<=1000000000?Integer.parseInt(srcDest[2]):1/0;
		sourceDestination[3] = Integer.parseInt(srcDest[3])>=0 && Integer.parseInt(srcDest[3])<=1000000000?Integer.parseInt(srcDest[3]):1/0;
		int temp;
		// Always sort on rows for source and destination
		if(sourceDestination[0]>sourceDestination[2]){
			temp = sourceDestination[0];
			sourceDestination[0] = sourceDestination[2];
			sourceDestination[2] = temp;

			temp = sourceDestination[1];
			sourceDestination[1] = sourceDestination[3];
			sourceDestination[3] = temp;
		}
		
		int distanceLadderPoint1;
		int distanceLadderPoint2;
		String[] cordinates;
		for(int i=0;i<3;i++){
			cordinates = sc.nextLine().trim().split(" ");
			ladder[i][0] = Integer.parseInt(cordinates[0])>=0 && Integer.parseInt(cordinates[0])<=1000000000?Integer.parseInt(cordinates[0]):1/0;
			ladder[i][1] = Integer.parseInt(cordinates[1])>=0 && Integer.parseInt(cordinates[1])<=1000000000?Integer.parseInt(cordinates[1]):1/0;
			ladder[i][2] = Integer.parseInt(cordinates[2])>=0 && Integer.parseInt(cordinates[2])<=1000000000?Integer.parseInt(cordinates[2]):1/0;
			ladder[i][3] = Integer.parseInt(cordinates[3])>=0 && Integer.parseInt(cordinates[3])<=1000000000?Integer.parseInt(cordinates[3]):1/0;
			
			//Always sort ladder on rows
			if(ladder[i][0]>ladder[i][2]){
				temp = ladder[i][0];
				ladder[i][0] = ladder[i][2];
				ladder[i][2] = temp;

				temp = ladder[i][1];
				ladder[i][1] = ladder[i][3];
				ladder[i][3] = temp;
			}
		}
		
		//Sort ladder on rows
		for(int i=0;i<2;i++){
			//Always sort ladder on rows
			if(ladder[i][0]>ladder[i+1][0]){
				temp = ladder[i][0];
				ladder[i][0] = ladder[i+1][0];
				ladder[i+1][0] = temp;
				
				temp = ladder[i][1];
				ladder[i][1] = ladder[i+1][1];
				ladder[i+1][1] = temp;
				
				temp = ladder[i][2];
				ladder[i][2] = ladder[i+1][2];
				ladder[i+1][2] = temp;

				temp = ladder[i][3];
				ladder[i][3] = ladder[i+1][3];
				ladder[i+1][3] = temp;
			}
		}
		
		int distanceWtOutLadder = 0;
		int distanceWtLadder = 0;
		int minDistance;
		
		distanceWtOutLadder = Math.abs(sourceDestination[2]-sourceDestination[0]);
		distanceWtOutLadder = distanceWtOutLadder + Math.abs(sourceDestination[3]-sourceDestination[1]);
		
		//Only check ladder if the value greater than 10
		minDistance = distanceWtOutLadder;
		int[] interDistance = new int[2];
		int[][] interPoints = new int[2][2];
		if(distanceWtOutLadder>10){
			for(int i=0;i<3;i++){
				distanceLadderPoint1 = findDistanceBetweenPoints(sourceDestination[0],sourceDestination[1],ladder[i][0],ladder[i][1]);
				distanceLadderPoint2 = findDistanceBetweenPoints(sourceDestination[0],sourceDestination[1],ladder[i][2],ladder[i][3]);
				//One ladder
				if(distanceLadderPoint1 > distanceLadderPoint2){
					distanceWtLadder = findDistanceBetweenPoints(sourceDestination[2],sourceDestination[3],ladder[i][0],ladder[i][1]);
					distanceWtLadder = distanceLadderPoint2+ distanceWtLadder+10;
					if(minDistance>distanceWtLadder){
						minDistance = distanceWtLadder;
					}
					interDistance[0] = distanceLadderPoint2+10;
					interPoints[0][0] = ladder[i][0];
					interPoints[0][1] = ladder[i][1];
				}
				else{
					distanceWtLadder = findDistanceBetweenPoints(sourceDestination[2],sourceDestination[3],ladder[i][2],ladder[i][3]);
					distanceWtLadder = distanceLadderPoint1+ distanceWtLadder+10;
					if(minDistance>distanceWtLadder){
						minDistance = distanceWtLadder;
					}
					interDistance[0] = distanceLadderPoint1+10;
					interPoints[0][0] = ladder[i][2];
					interPoints[0][1] = ladder[i][3];
				}
				if(minDistance>interDistance[0]){
					for(int j=0;j<3;j++){
						if(i!=j){
							distanceLadderPoint1 = findDistanceBetweenPoints(interPoints[0][0],interPoints[0][1],ladder[j][0],ladder[j][1]);
							distanceLadderPoint2 = findDistanceBetweenPoints(interPoints[0][0],interPoints[0][1],ladder[j][2],ladder[j][3]);
							//Two ladder
							if(distanceLadderPoint1 > distanceLadderPoint2){
								distanceWtLadder = findDistanceBetweenPoints(sourceDestination[2],sourceDestination[3],ladder[j][0],ladder[j][1]);
								distanceWtLadder = interDistance[0]+distanceLadderPoint2+ distanceWtLadder+10;
								if(minDistance>distanceWtLadder){
									minDistance = distanceWtLadder;
								}
								interDistance[1] = interDistance[0]+distanceLadderPoint2+10;
								interPoints[1][0] = ladder[j][0];
								interPoints[1][1] = ladder[j][1];
							}
							else{
								distanceWtLadder = findDistanceBetweenPoints(sourceDestination[2],sourceDestination[3],ladder[j][2],ladder[j][3]);
								distanceWtLadder = interDistance[0]+distanceLadderPoint1+ distanceWtLadder+10;
								if(minDistance>distanceWtLadder){
									minDistance = distanceWtLadder;
								}
								interDistance[1] = interDistance[0]+distanceLadderPoint1+10;
								interPoints[1][0] = ladder[j][2];
								interPoints[1][1] = ladder[j][3];
							}
							if(minDistance>interDistance[1]){
								for(int k=0;k<3;k++){
									if(i!=k && j!=k){
										distanceLadderPoint1 = findDistanceBetweenPoints(interPoints[1][0],interPoints[1][1],ladder[k][0],ladder[k][1]);
										distanceLadderPoint2 = findDistanceBetweenPoints(interPoints[1][0],interPoints[1][1],ladder[k][2],ladder[k][3]);
										//Three ladderk p
										if(distanceLadderPoint1 > distanceLadderPoint2){
											distanceWtLadder = findDistanceBetweenPoints(sourceDestination[2],sourceDestination[3],ladder[k][0],ladder[k][1]);
											distanceWtLadder = interDistance[1]+distanceLadderPoint2+ distanceWtLadder+10;
											if(minDistance>distanceWtLadder){
												minDistance = distanceWtLadder;
											}
										}
										else{
											distanceWtLadder = findDistanceBetweenPoints(sourceDestination[2],sourceDestination[3],ladder[k][2],ladder[k][3]);
											distanceWtLadder = interDistance[1]+distanceLadderPoint1+ distanceWtLadder+10;
											if(minDistance>distanceWtLadder){
												minDistance = distanceWtLadder;
											}
										}
									}
								}
							}
							else{
								continue;
							}
						}
						
					}
				}
				else{
					continue;
				}
			}
		}
		System.out.println(minDistance);
	}
	
	public static int findDistanceBetweenPoints(int i,int j,int k,int l){
		int distance = 0;
		distance = Math.abs(i-k);
		distance = distance + Math.abs(j-l);
		return distance;
	}


}
