package DSA;

import java.util.Scanner;

public class LCS
{
    /**
     * Method to find the length of LCS using Dynamic Programming
     */
    public static int lcs(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build LCS table in bottom-up manner 
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0) // Base Case: Length is 0 if either string is empty
                    dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) // Characters match
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else // Characters don't match
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // dp[m][n] contains the length of LCS
        return dp[m][n];
    }

    /**
     * Method to print the actual LCS string
     */
    public static String getLCSString(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp table (Updated to explicitly include base case logic)
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Backtrack to find the LCS string
        int index = dp[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        
        while (i > 0 && j > 0)
        {
            if (X.charAt(i - 1) == Y.charAt(j - 1))
            {
                // If characters match, it's part of the LCS
                lcs[index - 1] = X.charAt(i - 1);
                i--;
                j--;
                index--;
            } 
            // Check the path that gave the maximum length
            else if (dp[i - 1][j] > dp[i][j - 1])
            {
                // Move up (ignoring char from X)
                i--;
            } 
            else 
            {
                // Move left (ignoring char from Y). This handles the case
                // where dp[i-1][j] <= dp[i][j-1], prioritizing j-- when equal.
                j--;
            }
        }
        
        return new String(lcs);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string:");
        String str1 = sc.nextLine();
        System.out.println("Enter second string:");
        String str2 = sc.nextLine();
        
        int length = lcs(str1, str2);
        String lcsString = getLCSString(str1, str2);
        
        System.out.println("\nLength of Longest Common Subsequence: " + length);
        System.out.println("Longest Common Subsequence: " + lcsString);
        sc.close();
    }
}