import java.io.*;
import java.util.*;
class DP
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    int arr[] = new int[m];
                    for(int i = 0;i<m;i++)
                        arr[i] = sc.nextInt();
                    System.out.println(count(arr,m,n));
                }
        }

    public long count(int S[], int m, int sum) 
    { 
        long dp[][]=new long[m+1][sum+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0 ) 
                dp[i][j]=0;
                if(j ==0) 
                dp[i][j]=1;
            }
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(S[i-1] <= j)
                    dp[i][j]= dp[i][j-S[i-1]]+ dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[m][sum];
    } 
}