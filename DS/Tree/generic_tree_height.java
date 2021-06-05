package datastructure;

import java.util.*;
import java.io.*;


public class tree {
	static class Node{
		int data;
		ArrayList<Node> childs =new ArrayList<>();
	}
	
	
	public static int height(Node node)
	{
		int s=-1; //yeh base condition hai changes agr voh height kis basis pr puchega
		for(Node child:node.childs)
		{
			int cnt=height(child);
			s=Math.max(s, cnt);
		}
		return s+1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Deque<Node> st = new ArrayDeque<>();
		System.out.println("enter root data");
		int d=sc.nextInt();
		Node root=new Node();
		root.data=d;
		
		st.push(root);
		while(st.isEmpty() != true)
		{
			System.out.println("enter number of children "+st.peekLast().data);
			int ch=sc.nextInt();
			Node front=st.peekLast();
			st.pollLast();
			for(int i=0;i<ch;i++)
			{
				System.out.println("enter" + i+ "th children "+front.data);
				int data_of_children=sc.nextInt();
				Node t=new Node();
				t.data = data_of_children;
				front.childs.add(t);
				st.push(t);
			}
		}
		int sum=0;
		//display(root);
		System.out.println(height(root));
	}

}
