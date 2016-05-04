import java.util.Hashtable;

public class RecursionMemo {

	Hashtable<StringBuffer,StringBuffer> storeLCS=new Hashtable<StringBuffer,StringBuffer>();

	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		StringBuffer sub1=new StringBuffer();
		StringBuffer sub2=new StringBuffer();
		StringBuffer sub=new StringBuffer();

		if(A.length()==0 || B.length()==0)
			return new StringBuffer("");
		if(storeLCS.containsKey(A.toString()+":"+B.toString()))
		{
			return storeLCS.get(A.toString()+":"+B.toString());
		}

		if(A.charAt(A.length()-1)==B.charAt(B.length()-1))
		{
			sub=findLCS(new StringBuffer(A.substring(0, A.length()-1)),new StringBuffer(B.substring(0, B.length()-1))).append(A.charAt(A.length()-1));

			if(!storeLCS.containsKey(A.toString()+":"+B.toString()))
				storeLCS.put(new StringBuffer(A.toString()+":"+B.toString()), sub);

			return sub;
		}
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
