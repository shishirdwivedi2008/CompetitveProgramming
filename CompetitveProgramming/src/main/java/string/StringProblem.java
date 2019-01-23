package string;

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
	
	
	public static void main(String[] args) {
		StringProblem string=new StringProblem();
		String s1="AGGTAB";
		String s2="GXTXAYB";
		System.out.println(string.lcs(s1.toCharArray(), s2.toCharArray(), s1.toCharArray().length,s2.toCharArray().length));
	}
}
