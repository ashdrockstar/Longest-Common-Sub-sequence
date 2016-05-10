
/* Objective: 
 * 1>.To observe empirically complexities of different implementations of algorithms 
 * for the same problem: finding longest common subsequence in two sequences. 
 * 2>.To find out how accurate are the theoretical estimates of complexity 
 * when compared to practical execution times.
 * 
 * Version: 2.0
 * Author: Aishwary Pramanik (ap9599@g.rit.edu)
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


// A Class to Execute the respective algorithms
public class ExecuteAlgo {

	// Main method to start the execution
	public static void main(String[] args) throws InterruptedException, IOException {
		// Finding LCS using Dynamic programming version of the algorithm
		DynamicLCS dynamicLCS=new DynamicLCS();

		// Finding LCS using Dynamic programming version of the algorithm
		NaiveLCS naiveLCS=new NaiveLCS();

		// Finding LCS using Dynamic programming version of the algorithm
		RecursionMemo recLCS=new RecursionMemo();

		// Finding LCS using Linear Space Quadratic Time version of the algorithm
		lsqtLCS lsqtlcs=new lsqtLCS();

		// To randomly generate binary numbers or alphabets
		Random choice=new Random();
		// To store input1
		StringBuffer S1 = new StringBuffer();
		// To store input2
		StringBuffer S2 = new StringBuffer();
		// To store LCS
		StringBuffer sub = new StringBuffer();
		// Counter to keep track of length
		int ctr=1;
		// Variables to keep track of cputime
		long cpuTime=0;
		long startTime;
		long endTime;
		FileWriter fileWriter;
		FileWriter textFileWriter;
		int ch;
		Scanner scanner=new Scanner(System.in);

		System.out.println("--------------Menu:--------------");
		System.out.println("1>. Dynamic Implementation");
		System.out.println("2>. Naive Implementation");
		System.out.println("3>. Recursion with Memoization Implementation");
		System.out.println("4>. Linear Space Quadratic Time Implementation");
		System.out.print("Enter Your Choice: ");
		ch=scanner.nextInt();
		switch(ch)
		{
		case 1:
			fileWriter=new FileWriter(new File("DynamicLCSLog.csv"));
			textFileWriter=new FileWriter(new File("DynamicLCSOutput.doc"));
			break;
		case 2:
			fileWriter=new FileWriter(new File("NaiveLCSLog.csv"));
			textFileWriter=new FileWriter(new File("NaiveLCSOutput.doc"));
			break;
		case 3:
			fileWriter=new FileWriter(new File("RecMemoLCSLog.csv"));
			textFileWriter=new FileWriter(new File("RecMemoLCSOutput.doc"));
			break;
		default:
			fileWriter=new FileWriter(new File("lSqTLCSLog.csv"));
			textFileWriter=new FileWriter(new File("lSqTLCSOutput.doc"));
		}
		fileWriter.write("CPU Time(ms),Length of String1,Length of String2,LCS Length\n");
		//System.out.println("|CPU Time(ms)|\t|Length of String1|\t|Length of String2|\t|LCS Length|");

		//Loop which ends when execution time exceeds 10 seconds
		while(cpuTime<=10000)
		{	
			S1.delete(0, S1.length());
			S2.delete(0, S2.length());
			// To generate Random Binary Strings
			if(choice.nextInt(2)==0)
			{
				for(int i=0;i<ctr;i++)
				{
					S1.append(choice.nextInt(2));
					S2.append(choice.nextInt(2));
				}
			}
			// To generate Random Alphabetical Strings
			else
			{
				for(int i = 0; i < ctr; i++)
				{
					S1 = S1.append((char)('A' + choice.nextInt(26)));
				}
				for(int i = 0; i < ctr; i++)
				{
					S2 = S2.append((char)('A' + choice.nextInt(26)));
				}
			}
			// To note the Start Time
			startTime=System.currentTimeMillis();

			// To start implementation of Algorithm chosen by the user
			switch(ch)
			{
			case 1:
				sub=dynamicLCS.findLCS(S1,S2);
				break;
			case 2:
				sub=naiveLCS.findLCS(new StringBuffer(S1),new StringBuffer(S2));
				break;
			case 3:
				sub=recLCS.findLCS(new StringBuffer(S1),new StringBuffer(S2));
				break;
			default:
				sub=lsqtlcs.findLCS(new StringBuffer(S1),new StringBuffer(S2));
			}

			// To note the End Time 
			endTime=System.currentTimeMillis();

			// The time taken for the execution
			cpuTime=endTime-startTime;

			System.out.println("|"+cpuTime+"|\t\t|"+ctr+"|\t\t|"+ctr+"|\t\t|"+sub.length()+"|");

			// Generate the execution log in respective file
			fileWriter.write(cpuTime+","+ctr+","+ctr+","+sub.length()+"\n");
			ctr++;
		}


		// Generate the output in respective file
		textFileWriter.write("----------------TERMINATION-------------");
		textFileWriter.write("\nS1 Length:"+S1.length());
		textFileWriter.write("S1:\n"+S1);
		textFileWriter.write("\nS2 Length:"+S2.length());
		textFileWriter.write("S2:\n"+S2);
		textFileWriter.write("\nLCS Length:"+sub.length());
		textFileWriter.write("LCS:\n"+sub);
		textFileWriter.write("----------------------------------------");


		System.out.println("----------------TERMINATION-------------");
		System.out.println("\nS1 Length:"+S1.length());
		System.out.println("S1:\n"+S1);
		System.out.println("\nS2 Length:"+S2.length());
		System.out.println("S2:\n"+S2);
		System.out.println("\nLCS Length:"+sub.length());
		System.out.println("LCS:\n"+sub);
		System.out.println("----------------------------------------");


		// Closing the Features being used
		textFileWriter.close();
		fileWriter.close();
		scanner.close();
	}
}
