package javarep;

import java.util.*;
import java.io.*;

public class codefo {
	
	public static void helper(int n)
	{
		if(n==1)
		{
			System.out.print(n+" ");
			return;
		}
		System.out.print(n+" "); 
		helper(n-1);
		//pw.print(n+" "); gives us 1 to n
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tst = 1;
		while (tst-- > 0) {
			int n =sc.nextInt();
			helper(n);
			//System.out.println();
			}
		sc.close();
	}

}
