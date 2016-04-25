
public class NaiveLCS {
	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		int i,j,k;
		i=0;
		j=0;
		StringBuffer sub=new StringBuffer();
		while(j<B.length())
		{
			k=i;
			while(k<A.length())
			{
				if(A.charAt(k)==B.charAt(j))
				{
					
					sub.append(A.charAt(k));
					i++;
					break;
				}
				k++;
			}
			j++;
		}
		return sub;
	}
}
