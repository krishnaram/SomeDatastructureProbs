package com.example.iDeserve;


import java.util.*;
        import java.io.*;

class CalixRound2 {

    public static String KUniqueCharacters(String str) {
        String subString = "";
        String runningSubString = "";
        char[] stringChars = str.toCharArray();
        if(stringChars.length>2){
            int uniqueCharLen = Integer.parseInt(stringChars[0]+"");
           // System.out.println(uniqueCharLen);
            Map<Character,Integer> uniqueChars = new HashMap<Character,Integer>();
            int uniqueCount = 0;
            int[] posArray = new int[256];
            for(int i=1;i<stringChars.length;i++){
                //System.out.println(runningSubString);
                uniqueCount = 0;
                uniqueChars.put(stringChars[i],i);
                runningSubString = ""+ stringChars[i];
                uniqueCount++;
                posArray[stringChars[i]] = i;

                for(int j=i+1;j<stringChars.length;j++){
                        //System.out.println(posArray[stringChars[j]]);
                        if(posArray[stringChars[j]]>0 ){
                            uniqueChars.put(stringChars[j],j); // put latest position
                            runningSubString = runningSubString + ""+stringChars[j];

                        }
                        else{
                            if(uniqueCount<uniqueCharLen){
                                posArray[stringChars[j]] = j;
                                uniqueChars.put(stringChars[j],j);
                                runningSubString = runningSubString + ""+stringChars[j];
                            }
                            uniqueCount++;
                        }


                    if(uniqueCount >uniqueCharLen || j+1==stringChars.length){
                        //System.out.println("=================================");
                        //System.out.println("uniqueCount:"+uniqueCount+ "uniqueCharLen:"+uniqueCharLen);

                        //System.out.println("=================================");
                        if(runningSubString.length()>=subString.length()){
                            subString = runningSubString;
                        }

                        clearPosArray(uniqueChars,posArray);
                        break;
                    }
                }

            }
        }

        System.out.println("=================================");
        // code goes here
        return subString;
    }
    public static  void clearPosArray(Map<Character,Integer> uniqueChars,int[] posArray){
        for(char uniqueChar: uniqueChars.keySet()){ // finding near by pos and making posArray back to normal
            posArray[uniqueChar] = 0;
        }
  /*int pos =0;
  int nearPos =0;
  for(int i=charArray.length-1;i>=0;i--){
    uniqueChars.get(charArray[i]);
    pos ++;
    //if()
  }
  return nearPos;*/
    }


    public static void main (String[] args) {
       // String substring =KUniqueCharacters("3aabacbebebe");
        //System.out.println(substring);//aabacbebebe
        // keep this function call here
        System.out.println("Sample test passing: " + (KUniqueCharacters("3aabacbebebe").equals("cbebebe")) + "\r\n");
        System.out.println("Sample test passing: " + (KUniqueCharacters("2aabbacbaa").equals("aabba")) + "\r\n");

    }

}


/*uniqueCharPos[] //  Latest Position
uniqueChar[] // All unique chars
uniqueChar =0 ;
posArray int[256]
lenght 2
HashMap<Character,Integer> uniqueChars
for(String i){
	if(uniQueCharLen<lenght){
		if(posArray[char]<0){
		uniQueCharLen++;
		}
		else{
			uniqueChars
			subString = substring + char;
		}
	}
	if(uniQueCharLen == lenght){
		uniqueChar
	}

}

(hashMap,pos,char)

uniqueChars
a,5
b,4
c,6 -> 1
posArray = 0  */
