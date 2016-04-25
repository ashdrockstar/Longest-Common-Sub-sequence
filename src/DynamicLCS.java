/* Objective: 
 * 1>.To observe empirically complexities of different implementations of algorithms 
 * for the same problem: finding longest common subsequence in two sequences. 
 * 2>.To find out how accurate are the theoretical estimates of complexity 
 * when compared to practical execution times.
 * 
 * Version: 1.0
 * Author: Aishwary Pramanik (ap9599@g.rit.edu)
 */
public class DynamicLCS {

	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		int lenA,lenB;
		lenA=A.length();
		lenB=B.length();

		StringBuffer substring = new StringBuffer();

		substring.delete(0, substring.length());
		int i,j;

		int[][] Matrix=new int[lenA+1][lenB+1];
		for(i=0;i<=lenA;i++)
			Matrix[i][0]=0;
		for(j=0;j<=lenB;j++)
			Matrix[0][j]=0;
		for(i=1;i<=lenA;i++)
		{
			for(j=1;j<=lenB;j++)
			{
				if(A.charAt(i-1)==B.charAt(j-1))
					Matrix[i][j]=Matrix[i-1][j-1]+1;
				else
					Matrix[i][j]=Math.max(Matrix[i-1][j], Matrix[i][j-1]);
			}
		}
		i=lenA;
		j=lenB;
		while(i>=1 && j>=1)
		{
			if(A.charAt(i-1)==B.charAt(j-1))
			{
				substring=substring.reverse();
				substring.append(A.charAt(i-1));
				substring=substring.reverse();
				i=i-1;
				j=j-1;
			}
			else
			{
				if(Matrix[i-1][j]>=Matrix[i][j-1])
					i=i-1;
				else
					j=j-1;
			}
		}
		return substring;
	}
}
