
public class lsqtLCS {
	static int matrix[][];
	static StringBuffer sub=new StringBuffer();
	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		matrix=new int[A.length()][B.length()];
		
		System.out.println(helper(A,B, A.length()-1, B.length()-1)+" "+sub);
		return sub;
	}
	
	public int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	public int helper(StringBuffer A, StringBuffer B,int i, int j)
	{
		if(i==0 || j==0)
			return 0;
		if(A.charAt(i)==B.charAt(j))
		{
			sub.append(A.charAt(i));
			matrix[i][j]=helper(A, B, i-1, j-1)+1;
		}
		else
			matrix[i][j]=max(helper(A, B, i, j-1),helper(A, B, i-1, j));
		return matrix[i][j];
	}
}
