
import java.util.*;
import java.io.*;


public class tree {
	static class Node{
		int data;
		ArrayList<Node> childs =new ArrayList<>();
	}
	
	public static void display(Node node)
	{
		if(node==null)
			return; //edge case
			
		String s=node.data+" -> ";
		for(Node child:node.childs) {
			s+=child.data + ",";
		}
		System.out.println(s);
		
		for(Node child: node.childs)
		{
			display(child);
		}
	}
	public static void main(String[] args) {
		int a[] = { 10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1 };
		Stack<Node> st=new Stack<>();
		
		Node root=null;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==-1)
				st.pop();
			else
			{
				Node t=new Node();
				t.data =a[i];
				if(st.isEmpty())
					root=t;
				else
				{
					st.peek().childs.add(t);
				}
				st.push(t);
			}
		}
		
		display(root);
	}

}
