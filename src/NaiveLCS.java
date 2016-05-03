
public class NaiveLCS {
	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		int i,j,k;
		StringBuffer sub1=new StringBuffer();
		StringBuffer sub2=new StringBuffer();
		i=0;
		j=0;
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

		i=0;
		j=0;
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
		
		if(sub1.length()>sub2.length())
			return sub1;
		else
			return sub2;
	}
}
