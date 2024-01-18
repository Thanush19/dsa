class Test2 {
    static int countWays(int N, String S) {
        int mod = 1003;
        int[][][] dp = new int[N][N][2];

        for (int i = 0; i < N; i += 2) {
            if (S.charAt(i) == 'T')
                dp[i][i][1] = 1;
            else
                dp[i][i][0] = 1;
        }

        for (int gap = 2; gap < N; gap += 2) {
            for (int i = 0; i < N - gap; i += 2) {
                int j = i + gap;
                for (int k = i + 1; k < j; k += 2) {
                    char operator = S.charAt(k);
                    int leftTrue = dp[i][k - 1][1];
                    int leftFalse = dp[i][k - 1][0];
                    int rightTrue = dp[k + 1][j][1];
                    int rightFalse = dp[k + 1][j][0];

                    if (operator == '&') {
                        dp[i][j][1] = (dp[i][j][1] + (leftTrue * rightTrue) % mod) % mod;
                        dp[i][j][0] = (dp[i][j][0] + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod
                                + (leftFalse * rightFalse) % mod) % mod;
                    } else if (operator == '|') {
                        dp[i][j][1] = (dp[i][j][1] + (leftTrue * rightTrue) % mod + (leftTrue * rightFalse) % mod
                                + (leftFalse * rightTrue) % mod) % mod;
                        dp[i][j][0] = (dp[i][j][0] + (leftFalse * rightFalse) % mod) % mod;
                    } else if (operator == '^') {
                        dp[i][j][1] = (dp[i][j][1] + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod)
                                % mod;
                        dp[i][j][0] = (dp[i][j][0] + (leftTrue * rightTrue) % mod + (leftFalse * rightFalse) % mod)
                                % mod;
                    }
                }
            }
        }

        return dp[0][N - 1][1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.nextLine();
        String S = sc.nextLine();

        int res = Test2.countWays(N, S);

        System.out.println(res);
    }
}