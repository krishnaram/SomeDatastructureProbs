package com.example.leetcodemedium;

import java.util.*;

public class RobotCollison {

    public static void main(String[] str){
       /* System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10},"RRRRR")
                .equals(Arrays.asList(new int[]{2,17,9,15,10}))));
        System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{3,5,2,6}, new int[]{10,10,15,12},"RLRL")
                .equals(Arrays.asList(new int[]{14}))));
        System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{1,2,5,6}, new int[]{10,10,11,11},"RLRL")
                .equals(Arrays.asList(new int[]{}))));
        System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{2}, new int[]{2},"L")
                .equals(Arrays.asList(new int[]{2}))));*/
       // System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{37,35}, new int[]{16,19},"RL")
       //         .equals(Arrays.asList(new int[]{2}))));
        //System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{11,44,16}, new int[]{1,20,17},"RLR")
         //       .equals(Arrays.asList(new int[]{2}))));
        //System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{4,37,23}, new int[]{50,15,49},"RLR")
         //       .equals(Arrays.asList(new int[]{2}))));
        //System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{42,12,4}, new int[]{48,6,43},"LRL")
         //       .equals(Arrays.asList(new int[]{47,43}))));
        System.out.println("Check survived Robots Healths:"+(survivedRobotsHealths(new int[]{272,499,238}, new int[]{7251,4858,3022},"LRR")
                .equals(Arrays.asList(new int[]{7250,4858}))));

    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int temp;
        char charTemp;
        int[] actualPositions = new int[positions.length];
        for(int i=0;i<positions.length;i++){
            actualPositions[i] = i;
        }
        int[] originalHealths = Arrays.copyOf(healths, healths.length);

        char[] directionArr = directions.toCharArray();
        Stack<int[]> rightStack = new Stack<int[]>();
        Stack<int[]> leftStack = new Stack<int[]>();
        boolean isSameDirection = false;
        if(directions.matches("[L]{"+directions.length()+"}")){
            isSameDirection = true;
        }
        else if(directions.matches("[R]{"+directions.length()+"}")){
            isSameDirection = true;
        }
        List<Integer> returnList = new ArrayList<Integer>();
        if(isSameDirection){
            for(int i=0;i<healths.length;i++){
                returnList.add(healths[i]);
            }
            return returnList;
        }
        for(int i=0;i<positions.length;i++){
            for(int j=i+1;j<positions.length;j++){
                if(positions[i] >positions[j]){
                    temp = actualPositions[j];
                    actualPositions[j] = actualPositions[i];
                    actualPositions[i] = temp;

                    temp = positions[j];
                    positions[j] = positions[i];
                    positions[i] = temp;

                    temp = healths[j];
                    healths[j] = healths[i];
                    healths[i] = temp;

                    charTemp = directionArr[j];
                    directionArr[j]= directionArr[i];
                    directionArr[i]= charTemp;
                }
            }
        }
        directions = "";
        for(char ch: directionArr){
            directions = directions+ ch;
        }

        if(directions.matches("^[L]+[R]+$")){
            isSameDirection = true;
        }
        if(isSameDirection){
            for(int i=0;i<originalHealths.length;i++){
                returnList.add(originalHealths[i]);
            }
            return returnList;
        }
        List<int[]> interList = new ArrayList<int[]>();
        for(int i=0;i<positions.length;i++){
            if(directionArr[i] == 'L'){
                if(rightStack.size()>=1){
                    int[] healthRight = rightStack.peek();
                    if(healthRight[0] == healths[i] ){
                        rightStack.pop();
                    }
                    else if(healthRight[0] < healths[i]){
                        rightStack.pop();
                        leftStack.add(new int[]{healths[i]-1, actualPositions[i]});
                    }
                    else{
                        healthRight = rightStack.pop();
                        healthRight[0] = healthRight[0]-1;
                        rightStack.push(healthRight);
                    }
                }
                else{
                    interList.add(new int[]{healths[i],actualPositions[i]});
                }
            }
            else if(directionArr[i] == 'R'){
                /*if(leftStack.size()>=1){
                    int[] healthLeft = leftStack.peek();
                    if(healthLeft[0] == healths[i] ){
                        leftStack.pop();
                    }
                    else if(healthLeft[0] < healths[i]){
                        leftStack.pop();
                        rightStack.add(new int[]{healths[i]-1, actualPositions[i]});
                    }
                    else{
                        healthLeft = leftStack.pop();
                        healthLeft[0]--;
                        leftStack.push(healthLeft);
                    }
                }
                else {*/
                    rightStack.add(new int[]{healths[i], actualPositions[i]});
                //}
            }
        }
        while(rightStack.size()>=1 && leftStack.size()>=1){
            if(rightStack.peek()[0]> leftStack.peek()[0]){
                int[] healthRight = rightStack.pop();
                healthRight[0]--;
                leftStack.pop();
                rightStack.add(healthRight);
            }
            else if(leftStack.peek()[0]> rightStack.peek()[0]){
                int[] healthLeft = leftStack.pop();
                healthLeft[0]--;
                rightStack.pop();
                leftStack.add(healthLeft);
            }
            else if(leftStack.peek() == rightStack.peek()){
                rightStack.pop();
                leftStack.pop();
            }
        }

        if(leftStack.size()>=1){
            while(leftStack.size()>=1){
                interList.add(leftStack.pop());
            }
        }
        if(rightStack.size()>=1){
            while(rightStack.size()>=1){
                interList.add(rightStack.pop());
            }
        }
        int[] healthStackI;
        int[] healthStackJ;
        for(int i=0;i<interList.size();i++){
            for(int j=i+1;j<interList.size();j++){
                if(interList.get(i)[1] >interList.get(j)[1]){
                    healthStackJ = interList.get(j);
                    healthStackI = interList.get(i);
                    interList.remove(j);
                    interList.remove(i);
                    interList.add(i,healthStackJ);
                    interList.add(j,healthStackI);

                }
            }
        }
        for(int i=0;i<interList.size();i++){
            returnList.add(interList.get(i)[0]);
        }
        return returnList;
    }
}
