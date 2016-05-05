import java.util.Arrays;

public class lsqtLCS {


	public StringBuffer findLCS(StringBuffer A,StringBuffer B)
	{
		StringBuffer sub1=new StringBuffer();
		StringBuffer sub2=new StringBuffer();
		sub1=findLCSHelper(A,B);
		sub2=findLCSHelper(B,A);
		if(sub1.length()>=sub2.length())
			return sub1;
		else
			return sub2;
	}

	StringBuffer findLCSHelper(StringBuffer A,StringBuffer B){


		StringBuffer sub=new StringBuffer();
		int row1[],row2[];
		int i,j;
		int m,n;
		int fl=0;
		int loc=0;
		m=A.length()+1;
		n=B.length()+1;
		row1=new int[n];
		row2=new int[n];

		Arrays.fill(row1, 0);
		i=1;
		j=1;

		while(i<m)
		{
			fl=0;
			//			for(int k=0;k<n;k++)
			//				System.out.print(row1[k]+" ");
			//			System.out.println();
			j=1;
			while(j<n)
			{

				row2[0]=0;
				if(A.charAt(i-1)==B.charAt(j-1))
				{

					row2[j]=row1[j-1]+1;
					if(j>loc && fl==0)
					{
						loc=j;
						//						System.out.println(i+","+j);
						sub.append(A.charAt(i-1));
						fl=1;
					}

				}
				else
				{

					row2[j]=Math.max(row1[j], row2[j-1]);
				}



				j++;
			}
			System.arraycopy(row2, 0, row1, 0, n);
			Arrays.fill(row2, 0);
			i++;
		}
		//		for(int k=0;k<n;k++)
		//			System.out.print(row1[k]+" ");
		//		System.out.println();
		return sub;
	}

}
