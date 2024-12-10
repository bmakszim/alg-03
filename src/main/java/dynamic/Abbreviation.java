package dynamic;

import java.io.*;
import java.util.stream.*;

class Result {

    public static String abbreviation(String a, String b) {
        int n = a.length();
        int m = b.length();

        // DP array to store results
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: an empty string `a` can match an empty string `b`
        dp[0][0] = true;

        // Initialize the DP table
        for (int i = 1; i <= n; i++) {
            // If `a` can be reduced to match an empty `b`, lowercase letters can be deleted
            dp[i][0] = dp[i - 1][0] && Character.isLowerCase(a.charAt(i - 1));
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char aChar = a.charAt(i - 1);
                char bChar = b.charAt(j - 1);

                if (Character.toUpperCase(aChar) == bChar) {
                    // Option 1: Use this character by capitalizing or matching directly
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (Character.isLowerCase(aChar)) {
                    // Option 2: Skip this character
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }

        return dp[n][m] ? "YES" : "NO";
    }

}

public class Abbreviation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = Result.abbreviation(a, b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
