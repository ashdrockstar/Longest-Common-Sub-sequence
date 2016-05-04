/* Objective: 
 * 1>.To observe empirically complexities of different implementations of algorithms 
 * for the same problem: finding longest common subsequence in two sequences. 
 * 2>.To find out how accurate are the theoretical estimates of complexity 
 * when compared to practical execution times.
 * 
 * Version: 1.0
 * Author: Aishwary Pramanik (ap9599@g.rit.edu)
 */


// To generate Random numbers
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


// A Class to Execute the respective algorithms
public class ExecuteAlgo {

	// Main method to start the execution
	public static void main(String[] args) throws InterruptedException, IOException {
//		// Finding LCS using Dynamic programming version of the algorithm
//		DynamicLCS dynamicLCS=new DynamicLCS();
//
//		// Finding LCS using Dynamic programming version of the algorithm
//		NaiveLCS naiveLCS=new NaiveLCS();

		// Finding LCS using Dynamic programming version of the algorithm
		RecursionMemo recLCS=new RecursionMemo();

//		// To randomly generate binary numbers or alphabets
//		Random choice=new Random();
//		// To store input1
//		StringBuffer S1 = new StringBuffer();
//		// To store input2
//		StringBuffer S2 = new StringBuffer();
		// To store LCS
		StringBuffer sub = new StringBuffer();
//		// Counter to keep track of length
//		int ctr=1;
//		// Variables to keep track of cputime
//		long cpuTime=0;
//		long startTime;
//		long endTime;
//
//		//FileWriter fileWriter=new FileWriter(new File("DynamicLCSLog.csv"));
//		//FileWriter fileWriter=new FileWriter(new File("NaiveLCSLog.csv"));
//		//FileWriter fileWriter=new FileWriter(new File("RecMemoLCSLog.csv"));
//		//		fileWriter.write("CPU Time(ms),Input Length,LCS Length\n");
//		//		System.out.println("|CPU Time(ms)|\t|Input Length|\t|LCS Length|");
//		// Loop which ends when execution time exceeds 10 seconds
//		//		while(cpuTime<=10000)
//		//		{
//		S1.delete(0, S1.length());
//		S2.delete(0, S2.length());
//		if(choice.nextInt(2)==0)
//		{
//			for(int i=0;i<ctr;i++)
//			{
//				S1.append(choice.nextInt(2));
//				S2.append(choice.nextInt(2));
//			}
//		}
//		else
//		{
//			for(int i = 0; i < ctr; i++)
//			{
//				S1 = S1.append((char)('A' + choice.nextInt(26)));
//			}
//			for(int i = 0; i < ctr; i++)
//			{
//				S2 = S2.append((char)('A' + choice.nextInt(26)));
//			}
//		}
		// startTime=System.currentTimeMillis();
		// sub=dynamicLCS.findLCS(S1,S2);
//				sub=naiveLCS.findLCS(new StringBuffer("BABCCBAB"),new StringBuffer("BBACBA"));
		
		sub=recLCS.findLCS(new StringBuffer("BABAC"),new StringBuffer("ABBC"));
		
		//			endTime=System.currentTimeMillis();
		//			cpuTime=endTime-startTime;
		//			System.out.println("|"+cpuTime+"|\t\t|"+ctr+"|\t\t|"+sub.length()+"|");
		//			fileWriter.write(cpuTime+","+ctr+","+sub.length()+"\n");
		//			ctr++;
		//		}
		System.out.println("----------------TERMINATION-------------");
//		System.out.println("\nS1 Length:"+S1.length());
//		System.out.println("S1:\n"+S1);
//		System.out.println("\nS2 Length:"+S2.length());
//		System.out.println("S2:\n"+S2);
		System.out.println("\nLCS Length:"+sub.length());
		System.out.println("LCS:\n"+sub);
		System.out.println("----------------------------------------");
	}
}
