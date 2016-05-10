/* Objective: 
 * 1>.To observe empirically complexities of different implementations of algorithms 
 * for the same problem: finding longest common subsequence in two sequences. 
 * 2>.To find out how accurate are the theoretical estimates of complexity 
 * when compared to practical execution times.
 * 
 * Version: 2.0
 * Author: Aishwary Pramanik (ap9599@g.rit.edu)
 */
import java.util.Hashtable;

public class RecursionMemo {

	// To store the state defined values
	Hashtable<StringBuffer,StringBuffer> storeLCS=new Hashtable<StringBuffer,StringBuffer>();

	// Function to find LCS
	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		// To store Substring
		StringBuffer sub1=new StringBuffer();
		StringBuffer sub2=new StringBuffer();
		StringBuffer sub=new StringBuffer();

		// Consider the base case
		if(A.length()==0 || B.length()==0)
			return new StringBuffer("");

		// Consider the base case
		if(storeLCS.containsKey(A.toString()+":"+B.toString()))
		{
			return storeLCS.get(A.toString()+":"+B.toString());
		}

		// Characters are equal
		if(A.charAt(A.length()-1)==B.charAt(B.length()-1))
		{
			sub=findLCS(new StringBuffer(A.substring(0, A.length()-1)),new StringBuffer(B.substring(0, B.length()-1))).append(A.charAt(A.length()-1));

			if(!storeLCS.containsKey(A.toString()+":"+B.toString()))
				storeLCS.put(new StringBuffer(A.toString()+":"+B.toString()), sub);

			return sub;
		}
		// Characters are not equal
		else
		{
			sub1=findLCS(new StringBuffer(A.substring(0, A.length()-1)),B);

			if(!storeLCS.containsKey(new StringBuffer(A.toString()+":"+B.toString())))
				storeLCS.put(new StringBuffer(A.toString()+":"+B.toString()), sub1);

			sub2=findLCS(A,new StringBuffer(B.substring(0, B.length()-1)));

			if(!storeLCS.containsKey(new StringBuffer(A.toString()+":"+B.toString())))
				storeLCS.put(new StringBuffer(A.toString()+":"+B.toString()), sub2);
			
			if(sub1.length()>=sub2.length())
				return sub1;
			else
				
				return sub2;

		}
	}

}
