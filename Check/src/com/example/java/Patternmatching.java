package com.example.java;

import java.util.regex.Pattern;

public class Patternmatching {


    public static void main(String[] str){
        String sample = "dundi";

        System.out.println(Pattern.matches("[a-z]+",sample));

        sample = "def";

        System.out.println(sample.matches("[^abc]+"));

        sample = "def";

        System.out.println(sample.matches("[abc]+"));

        sample ="jhkjsanfdkanskjd673649jsfn";
        Pattern pattern =  Pattern.compile("[a-zA-Z0-9]*");
        System.out.println(pattern.matcher(sample).matches());

        sample ="jhkjsanfdkanskjd673649jsfndundu";
        pattern =  Pattern.compile("[a-zA-Z0-9]*dundu\\b");
        System.out.println(pattern.matcher(sample).matches());

        sample ="jdundu";
        pattern =  Pattern.compile("[a-z]{1}dundu\\b"); // //b is word boundary
        System.out.println(pattern.matcher(sample).matches());

        sample ="jDUNDU";
        pattern =  Pattern.compile("[a-z]{1}(dundu|DUNDU)\\b"); // //b is word boundary
        System.out.println(pattern.matcher(sample).matches());


        System.out.println("Check min operation of folder ops:"+(minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}) ==2));
        System.out.println("Check min operation of folder ops:"+(minOperations(new String[]{"./","ho3/","tl8/"}) ==2));
        System.out.println("Check min operation of folder ops:"+(minOperations(new String[]{"a7/","mi4/","o2/"
                ,"./","../","q9/","./","../"
                ,"je2/","../","../","../","g3/","f4/","./","lg5/","wx4/","../"
                ,"f9/","../","./","vo3/","../"}) ==3));
        //To check exception
        sample ="DUNDU";
        System.out.println(sample.matches("DUNDU\\b"));
        pattern =  Pattern.compile("[a-z]{1}{dundu|DUNDU}\\b"); // //b is word boundary
        System.out.println(pattern.matcher(sample).matches());

    //sample.sub

    }


    public static int minOperations(String[] logs) {
        String folderChange = "";
        int index = 0;
        for(String i:logs){
            if(i.matches("[.]{2}/")){
                if((folderChange.split("^[a-z0-9A-Z]*[//]").length>1)){
                    folderChange = folderChange.split("[a-z0-9A-Z]*[//]$")[0];
                }
                else{
                    folderChange = "";
                }

            }
            else if(i.matches("[a-z0-9A-Z]*[/]$")){
                folderChange = folderChange+i;
            }
        }

        if(folderChange.length()>1){
            return folderChange.split("/").length;
        }
        return 0;
    }
}
