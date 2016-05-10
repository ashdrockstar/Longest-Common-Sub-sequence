/* Objective: 
 * 1>.To observe empirically complexities of different implementations of algorithms 
 * for the same problem: finding longest common subsequence in two sequences. 
 * 2>.To find out how accurate are the theoretical estimates of complexity 
 * when compared to practical execution times.
 * 
 * Version: 2.0
 * Author: Aishwary Pramanik (ap9599@g.rit.edu)
 */

public class NaiveLCS {
	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		// Variable to iterate through the StringBuffers
		int i,j,k;

		// To store the LCS keeping A static and B dynamic
		StringBuffer sub1=new StringBuffer();
		// To store the LCS keeping B static and A dynamic
		StringBuffer sub2=new StringBuffer();

		// Initialization
		i=0;
		j=0;
		// Loop to compare A with B and store LCS in sub1
		while(i<A.length())
		{
			k=j;
			while(k<B.length())
			{
				if(A.charAt(i)==B.charAt(k))
				{
					sub1.append(A.charAt(i));
					j=k+1;
					break;
				}
				k++;
			}
			i++;
		}
		// Initialization
		i=0;
		j=0;
		// Loop to compare B with A and store LCS in sub2
		while(i<B.length())
		{
			k=j;
			while(k<A.length())
			{
				if(B.charAt(i)==A.charAt(k))
				{
					sub2.append(B.charAt(i));
					j=k+1;
					break;
				}
				k++;
			}
			i++;
		}

		// Return the LCS
		if(sub1.length()>sub2.length())
			return sub1;
		if(sub1.length()==sub2.length())
			return sub1.append(" "+sub2.toString());
		else
			return sub2;
	}
}
