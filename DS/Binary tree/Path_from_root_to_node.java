package datastructure;

import java.util.*;
import java.io.*;

public class tree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class pair {
		Node node;
		int s;

		public pair(Node node, int s) {
			this.node = node;
			this.s = s;
		}
	}

	public static void display(Node root) {
		if (root == null)
			return;
		Deque<Node> st = new ArrayDeque<>();
		st.push(root);
		while (st.size() > 0) {
			Node front = st.peekLast();
			st.pollLast();
			System.out.print(front.data + ":");
			if (front.left != null) {
				System.out.print(front.left.data);
				st.push(front.left);
			}
			if (front.right != null) {
				System.out.print(front.right.data);
				st.push(front.right);
			}
			System.out.println();
		}
	}

	public static Node mirror(Node root) {
		if (root == null)
			return root;
		Node left = mirror(root.left);
		Node right = mirror(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	public static Node in_and_post(int[] in, int[] post, int posti, int ini, int poste, int ine) {
		if (ini > ine)
			return null;

		int rtData = post[poste];
		int inrt = -1;
		for (int i = ini; i <= ine; i++) {
			if (in[i] == rtData) {
				inrt = i;
				break;
			}
		}
		int lposts = posti , lins = ini, line = inrt - 1, lposte = line - lins + lposts, rposts = lposte + 1, rposte = poste-1,
				rins = inrt + 1, rine = ine;
		Node root = new Node(rtData, null, null);
		root.left = in_and_post(in, post, lposts, lins, lposte, line);
		root.right = in_and_post(in, post, rposts, rins, rposte, rine);
		return root;
	}
	
	public static Node BST_using_BS(int arr[],int s,int end)
	{
		if(end < s)
			return null;
		if(s > end )
			return null;
		int mid=(s+end)/2;
		Node root=new Node(arr[mid],null,null);
		root.left=BST_using_BS(arr,s,mid-1);
		root.right=BST_using_BS(arr,mid+1,end);
		return root;
	}
	static List<Integer> path;
	public static boolean find_path(Node root,int data)
	{
		if(root==null)
			return false;
		if(root.data == data)
			{
				path.add(root.data);
				return true;
			}
		boolean ll=find_path(root.left,data);
		if(ll)
		{
			path.add(root.data);
			return true;
		}
		boolean rl=find_path(root.right,data);
		if(rl)
		{
			path.add(root.data);
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter root");
		int n = sc.nextInt();
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 8 9 -1 -1 -1 -1 -1 -1
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int data=sc.nextInt();
		path=new ArrayList<Integer>();
		Node root = BST_using_BS(arr,0,n-1);
		boolean res=find_path(root,data);
		if(res==true)
			System.out.println(path);
		else 
			System.out.println("Not found");
		//display(root);
	}

}
