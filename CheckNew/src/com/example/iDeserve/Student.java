package com.example.iDeserve;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Cloneable,Serializable{  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int rollno;  
String name;  

Student(int rollno,String name){  
this.rollno=rollno;  
this.name=name;  
}  

public Object clone()throws CloneNotSupportedException{  
return super.clone();  
}  

public static void main(String args[]) throws IOException, ClassNotFoundException{  
try{  
	Student s1=new Student(101,"amit");  

	Student s2=(Student)s1.clone();  
	
	  FileOutputStream fout=new FileOutputStream("f.txt");  
	  ObjectOutputStream out=new ObjectOutputStream(fout);
	  
	  
	  out.writeObject(s1);  
	  out.flush();  
	  System.out.println(s1.rollno+" "+s1.name+" hashCode "+s1.hashCode());  
	  System.out.println(s2.rollno+" "+s2.name+" hashCode "+s2.hashCode());
	  
	  ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
	  Student s=(Student)in.readObject();  
	  System.out.println(s.rollno+" "+s.name);  

}catch(CloneNotSupportedException c){}  

}  
}  