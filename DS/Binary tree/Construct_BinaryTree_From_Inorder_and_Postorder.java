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

	public static Node in_and_pre(int[] in, int[] pre, int prei, int ini, int pree, int ine) {
		if (ini > ine)
			return null;

		int rtData = pre[prei];
		int inrt = -1;
		for (int i = ini; i <= ine; i++) {
			if (in[i] == rtData) {
				inrt = i;
				break;
			}
		}
		int lpres = prei + 1, lins = ini, line = inrt - 1, lpree = line - lins + lpres, rpres = lpree + 1, rpree = pree,
				rins = inrt + 1, rine = ine;
		Node root = new Node(rtData, null, null);
		root.left = in_and_pre(in, pre, lpres, lins, lpree, line);
		root.right = in_and_pre(in, pre, rpres, rins, rpree, rine);
		return root;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter root");
		int n = sc.nextInt();
		// 1 2 3 4 5 6 7 -1 -1 -1 -1 8 9 -1 -1 -1 -1 -1 -1
		int pre[] = new int[n];
		int in[] = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			in[i] = sc.nextInt();
		Node root = in_and_pre(in, pre, 0, 0, n - 1, n - 1);
		display(root);
	}

}
