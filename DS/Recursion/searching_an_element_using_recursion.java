package javarep;

import java.util.*;
import java.io.*;

public class codefo {

	public static int helper(int a[], int i, int l, int x) {
		if (i == l - 1 || l == 0) {
			return -1;
		}
		if (a[i] != x)
			return helper(a, ++i, l, x);
		return i;
		// pw.print(n+" "); gives us 1 to n
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tst = 1;
		while (tst-- > 0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int k = helper(a, 0, n, x);
			System.out.println(k==-1 ? k:k+1);
		}
		sc.close();
	}

}
