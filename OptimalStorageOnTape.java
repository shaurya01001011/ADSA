package DSA;
 import java.util.Arrays;
 import java.util.Scanner;
 public class OptimalStorageOnTape {
    public static void main(String[] args)
 {
    Scanner sc = new Scanner(System.in);
    // Input number of programs
    System.out.print("Enter number of programs: ");
    int n = sc.nextInt();
    int[] length = new int[n];
    // Input program lengths
    System.out.println("Enter lengths of programs:");
    for (int i = 0; i < n; i++)
    {
        length[i] = sc.nextInt();
    }
    // Sort program lengths (shortest job first)
    Arrays.sort(length);
    int[] retrievalTime = new int[n];
    int totalRT = 0;
    // Calculate retrieval mes
    for (int i = 0; i < n; i++)
    {
        retrievalTime[i] = 0;
        for (int j = 0; j <= i; j++)
        {
            retrievalTime[i] += length[j];
        }
        totalRT += retrievalTime[i];
    }
    // Calculate Mean Retrieval Time (MRT)
    double MRT = (double) totalRT / n;
    // Print results
    System.out.println("\nOpmal Order of Programs: " + Arrays.toString(length));
    System.out.println("Retrieval Times: " + Arrays.toString(retrievalTime));
    System.out.println("Total Retrieval Time = " + totalRT);
    System.out.println("Mean Retrieval Time (MRT) = " + MRT);
    sc.close();
 }
 }