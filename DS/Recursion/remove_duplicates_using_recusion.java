package javarep;

import java.util.*;
import java.io.*;

public class codefo {

	public static void helper(char ch[] , int i,int l) {
		if (i == l-1 || ch[i] ==' ') {
			return;
		}
		else if(ch[i] != ch[i+1])
		helper(ch, ++i ,l);
		else
		{
			int j=0;
			for(j=i+1;j<l;j++)
				ch[j-1]=ch[j];
			ch[j-1]=' ';
			helper(ch, i ,l-1);
		}
		// pw.print(n+" "); gives us 1 to n
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tst = 1;
		while (tst-- > 0) {
			String s=sc.nextLine();
			char ch[]=s.toCharArray();
			helper(ch,0,s.length());
			System.out.println(ch);
		}
		sc.close();
	}

}
