package javarep;

import java.util.*;
import java.io.*;

public class codefo {
	
	public static int eculidean_gcd(int a,int b, int x,int y)
	{
		if(a==0)
		{
			x=0;
			y=1;
			return b;
		}
		int x1=1,y1=1;
		int ans=eculidean_gcd(b%a,a,x1,y1);
		x=y1-((b/a)*x1);
		y=x1;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//System.out.println();
		int t=sc.nextInt();
		int tst=1;
		while(t-->0)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int x=1,y=1;
			int ans=eculidean_gcd(a,b,x,y);
			System.out.println(ans+" "+x+" "+y);
			if(c%ans==0)
				System.out.println("yes, integral solutions exit "+((c/ans*x)+" "+((c/ans)*y)) );
			else
				System.out.println("soltuions do not exist");
			
		}
		sc.close();
	}
	
}
