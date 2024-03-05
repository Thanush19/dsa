import java.math.BigInteger;

public class Solution {
    public int superPow(int a, int[] b) {
        BigInteger base = BigInteger.valueOf(a);
        BigInteger exponent = convertArrayToBigInteger(b);
        BigInteger modulus = BigInteger.valueOf(1337);

        BigInteger result = base.modPow(exponent, modulus);

        return result.intValue();
    }

    private BigInteger convertArrayToBigInteger(int[] arr) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < arr.length; i++) {
            result = result.multiply(BigInteger.TEN).add(BigInteger.valueOf(arr[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 2;
        int[] b = {1, 0};
        System.out.println(solution.superPow(a, b)); // Output should be 1024
    }
}