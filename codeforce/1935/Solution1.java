import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            int len = ch.length;
            StringBuilder ans = new StringBuilder();
            int l = 0;
            int r = len - 1;
            if (ch[l] == ch[r]) {
                while (l <= r) {
                    if (ch[l] == ch[r]) {
                        l++;
                        r--;
                    } else {
                        break;
                    }
                }
            }
            if (l >= r) {
                System.out.println(s);
            } else if (ch[l] > ch[r]) {
                StringBuilder rev = new StringBuilder();
                rev.append(ch);
                rev.reverse();
                ans.append(rev);
                ans.append(s);
                System.out.println(ans.toString());
            } else if (ch[l] < ch[r]) {
                System.out.println(s);
            }
        }
    }
}
