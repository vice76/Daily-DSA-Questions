package datastructure;

import java.util.*;
import java.io.*;


public class tree {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data,Node left,Node right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	public static class pair {
		Node node;
		int s;

		public pair(Node node, int s) {
			this.node=node;
			this.s=s;
		}
	}
	public static void display(Node root)
	{
		if(root==null)
			return;
		String str=" ";
		str+=root.left == null? "." :root.left.data +" ";
		str+="<-"+root.data+"->";
		str+=root.right == null? "." :root.right.data +" ";
		System.out.println(str);
		display(root.left);
		display(root.right);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter root");
		int d=sc.nextInt();
		Deque<Node> st = new ArrayDeque<>();
		Node root=new Node(d,null,null);
		st.push(root);
		while(st.size()>0)
		{
			Node front =st.peekLast();
			st.pollLast();
			System.out.println("enter the left child"+front.data);
			int lc=sc.nextInt();
			if(lc!=-1)
			{
				Node left=new Node(lc,null,null);
				front.left=left;
				st.push(left);
			}
			System.out.println("enter the right child"+front.data);
			int rc=sc.nextInt();
			if(rc!=-1)
			{
				Node right=new Node(rc,null,null);
				front.right=right;
				st.push(right);
			}
		}
		display(root);
	}

}
