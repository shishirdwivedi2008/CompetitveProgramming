package string;

import sun.awt.SunHints.LCDContrastKey;

public class StringProblem {

	/**
	 * Longest common subsequence.
	 * If last character of both the string is equal add one and do recusrisve call for m-1 and n-1.
	 * If last character is not equal find max(lcs(m,n-1),lcs(m-1,n))
	 * @param x
	 * @param y
	 * @param m
	 * @param n
	 * @return
	 */
	public int lcs( char [] x, char [] y, int m , int n) {
		if(m==0|| n==0)
			return 0;
		if(x[m-1]==y[n-1])
			return 1+lcs(x,y,m-1,n-1);
		return max(lcs(x,y,m,n-1),lcs(x,y,m-1,n));
	}
	
	public int max(int a, int b) {
		return (a>b)?a:b;
	}
	
	
	public int lcsUsingMemoization(char [] x, char [] y, int m, int n) {
		int [] [] l=new int [m+1][n+1];
		
		for( int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 ||j==0)
					l[i][j]=0;
				else if(x[i-1]==y[j-1]) {
					l[i][j]=l[i-1][j-1]+1;
				}
				else
					l[i][j]=max(l[i-1][j],l[i][j-1]);
			}
		}
		
		return l[m][n];
		
	}
	
	public static void main(String[] args) {
		StringProblem string=new StringProblem();
		char [] s1="AGGTAB".toCharArray();
		char [] s2="GXTXAYB".toCharArray();
		int m=s1.length;
		int n=s2.length;
		//System.out.println(string.lcs(s1.toCharArray(), s2.toCharArray(), s1.toCharArray().length,s2.toCharArray().length));
		System.out.println(string.lcsUsingMemoization(s1, s2, m, n));
	}
}
