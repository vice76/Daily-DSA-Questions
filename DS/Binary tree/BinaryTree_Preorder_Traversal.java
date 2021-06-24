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
		Deque<Node> st = new ArrayDeque<>();
		st.push(root);
		while(st.size()>0)
		{
			Node front =st.peekLast();
			st.pollLast();
			System.out.print(front.data+":");
			if(front.left!=null)
			{
				System.out.print(front.left.data);
				st.push(front.left);
			}
			if(front.right!=null)
			{
				System.out.print(front.right.data);
				st.push(front.right);
			}
			System.out.println();
		}
	}
	public static void preorder(Node root)
	{
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter root");
		int d=sc.nextInt();
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 8 9 -1 -1 -1 -1 -1 -1
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
		preorder(root);
	}

}
