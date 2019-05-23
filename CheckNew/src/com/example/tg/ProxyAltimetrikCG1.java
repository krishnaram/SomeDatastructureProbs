package com.example.tg;

import java.util.*;
public class ProxyAltimetrikCG1
{
	public static void main(String []args)
	{
		 while(true) {
		Scanner sc=new Scanner(System.in);
		int n;
		n=sc.nextInt();
		ArrayList leaf_nodes=new ArrayList();
		for(int i=0;i<n;i++)
		{
			leaf_nodes.add(i);
		}
		ArrayList[] tree=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			int data;
			data=sc.nextInt();
			if(data!=-1)
			{
				if(leaf_nodes.contains(data))
				{
					tree[data]=new ArrayList();
					tree[data].add(i);
					int in=leaf_nodes.indexOf(data);
					leaf_nodes.remove(in);
				}
				else
				{
					tree[data].add(i);
				}
			}
		}
		int to_be_removed;
		to_be_removed=sc.nextInt();
		if(leaf_nodes.contains(to_be_removed))
		{
			System.out.println(leaf_nodes.size()-1);
		}
		else
		{
			result(tree,leaf_nodes,to_be_removed);
			System.out.println(leaf_nodes.size());
		}	
	}
	}
	
	public static void result(ArrayList []tree,ArrayList leaf_nodes,int to_be_removed)
	{
		for(int i=0;i<tree[to_be_removed].size();i++)
		{
			int data=Integer.parseInt(tree[to_be_removed].get(i).toString());
			if(leaf_nodes.contains(data))
			{
				int in=leaf_nodes.indexOf(data);
				leaf_nodes.remove(in);
			}
			else
			{
				
				result(tree,leaf_nodes,data);
			}
		}
	}
	
}
