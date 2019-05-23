package com.example.SDE;

import java.util.Stack;

public class BracesVar {
	
	public static void main(String[] arg)
	{
		String braces = "{a{a{a{ajhkjas}a}a}a}a";
		int openBrace = 0;
		int closeBrace = 0;
		
		//String[] openBraceAr = braces.split("{");
		//String[] closeBraceAr = braces.split("}");
		
		char[] braceChar = braces.toCharArray(); 
		for(int i = 0;i<braceChar.length;i++)
		{
			if(braceChar[i] == '{')
			{
				openBrace++;
			}
			else if(braceChar[i] == '}')
			{
				closeBrace++;
			}
		}
		System.out.println(openBrace);
		System.out.println(closeBrace);
		
		Stack<String> stackBrace = new Stack<String>();
		for(int i = 0;i<braceChar.length;i++)
		{
			if(braceChar[i] == '{')
			{
				stackBrace.push(Character.toString(braceChar[i]));
			}
			else if(braceChar[i] == '}' && stackBrace.size() >=1)
			{
				stackBrace.pop();
			}
			else if(braceChar[i] == '}' && stackBrace.size() == 0)
			{
				System.out.println("UnEqual braces");
				break;
			}
		}
		
	}

}
