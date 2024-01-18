import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = scanner.nextInt();
        }

        int l = scanner.nextInt();
        int[] C = new int[l];
        for (int i = 0; i < l; i++) {
            C[i] = scanner.nextInt();
        }

        int[][][] dp = new int[n + 1][m + 1][l + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= l; k++) {
                    if (A[i - 1] == B[j - 1] && A[i - 1] == C[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        // Output the result
        System.out.println(dp[n][m][l]);

        scanner.close();
    }
}
