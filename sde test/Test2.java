import java.util.*;

class Test2 {
     static int find(int n, String S) {
          int mod = 1003;
          int[][][] dp = new int[n][n][2];

          for (int i = 0; i < n; i += 2) {
               if (S.charAt(i) == 'T')
                    dp[i][i][1] = 1;
               else
                    dp[i][i][0] = 1;
          }

          for (int gap = 2; gap < n; gap += 2) {
               for (int i = 0; i < n - gap; i += 2) {
                    int j = i + gap;
                    for (int k = i + 1; k < j; k += 2) {
                         char op = S.charAt(k);
                         int leTr = dp[i][k - 1][1];
                         int LeFa = dp[i][k - 1][0];
                         int riTr = dp[k + 1][j][1];
                         int riFa = dp[k + 1][j][0];

                         if (op == '&') {
                              dp[i][j][1] = (dp[i][j][1] + (leTr * riTr) % mod) % mod;
                              dp[i][j][0] = (dp[i][j][0] + (leTr * riFa) % mod + (LeFa * riTr) % mod
                                        + (LeFa * riFa) % mod) % mod;
                         } else if (op == '|') {
                              dp[i][j][1] = (dp[i][j][1] + (leTr * riTr) % mod + (leTr * riFa) % mod
                                        + (LeFa * riTr) % mod) % mod;
                              dp[i][j][0] = (dp[i][j][0] + (LeFa * riFa) % mod) % mod;
                         } else if (op == '^') {
                              dp[i][j][1] = (dp[i][j][1] + (leTr * riFa) % mod + (LeFa * riTr) % mod)
                                        % mod;
                              dp[i][j][0] = (dp[i][j][0] + (leTr * riTr) % mod + (LeFa * riFa) % mod)
                                        % mod;
                         }
                    }
               }
          }

          return dp[0][n - 1][1];
     }

     public static void main(String[] args) {
          try (Scanner sc = new Scanner(System.in)) {
               int n = sc.nextInt();

               sc.nextLine();
               String S = sc.nextLine();

               int res = Test2.find(n, S);

               System.out.println(res);

          }
     }
}
