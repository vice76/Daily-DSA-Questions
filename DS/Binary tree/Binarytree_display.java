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
		int a[]= {50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
		Stack<pair> st=new Stack<>();
		Node root=new Node(a[0],null,null);
		pair rt=new pair(root,1);
		st.push(rt);
		int index=0;
		while(st.size()>0)
		{
			pair t=st.peek();
			if(t.s==1)
			{
				index++;
				if(a[index]!=-1)
				{
					t.node.left=new Node(a[index],null,null);
					pair lp=new pair(t.node.left,1);
					st.push(lp);
				}else
				{
					t.node.left=null;
				}
				t.s++;
			}
			else if(t.s==2)
			{
				index++;
				if(a[index]!=-1)
				{
					t.node.right=new Node(a[index],null,null);
					pair rp=new pair(t.node.right,1);
					st.push(rp);
				}else
				{
					t.node.right=null;
				}
				
				t.s++;
			}else
				st.pop();
		}
		display(root);
	}

}
