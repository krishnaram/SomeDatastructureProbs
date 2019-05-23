package com.example.iDeserve;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Finishings;

public class Point {
	int x;
	int y;

	public Point(int x,int y)
	{
		this.x =x;
		this.y =y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(-1, -1);
		Point p2 = new Point(-1, 6);
		Point p3 = new Point(6, 6);
		Point p4 = new Point(6, -1);
		List<Point> points = new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		System.out.println("Is given points form a square "+p1.findSquare(p1, p2, p3, p4));
	}
	
	//My own logic
	public boolean findSquare(Point p1,Point p2,Point p3,Point p4)
	{
		int d1 = distance(p1, p2,p3,p4);
		int d2 = distance(p2, p1,p3,p4);
		int d3 = distance(p3, p1,p2,p4);
		int d4 = distance(p4, p1,p2,p3);
		
		if(d1==d2 && d1==d3 && d1==d4)
		{
			return true;
		}
		return false;
	}
	
	public int distance(Point p1,Point p2,Point p3,Point p4)
	{
		return (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)
				+(p1.x-p3.x)*(p1.x-p3.x)+(p1.y-p3.y)*(p1.y-p3.y)
				+(p1.x-p4.x)*(p1.x-p4.x)+(p1.y-p4.y)*(p1.y-p4.y);
	}

}
