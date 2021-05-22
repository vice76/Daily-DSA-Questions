package javarep;

import java.util.*;
import java.io.*;

public class codefo {

	public static boolean helper(int a[], int i,int l) {
		if (i == l-1 || l==0) {
			return true;
		}
		if(a[i] < a[i+1])
			return helper(a, ++i ,l);
		return false;
		// pw.print(n+" "); gives us 1 to n
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tst = 1;
		while (tst-- > 0) {
			int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
			boolean k=helper(a,0,n);
			System.out.println(k);
		}
		sc.close();
	}

}
