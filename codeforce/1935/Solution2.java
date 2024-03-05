import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        if (sc.hasNextInt()) {
            t = sc.nextInt();
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
            }
            int j = 0;
            Set<Integer> s = new HashSet<>();
            Set<Integer> ss = new HashSet<>();
            while (m.get(j) != null && m.get(j) >= 2) {
                s.add(j);
                ss.add(j);
                j++;
            }
            if (m.get(j) != null && m.get(j) > 0) {
                System.out.println(-1);
            } else {
                int r = 0;
                for (int i = 0; i < n; i++) {
                    if (s.contains(a[i])) {
                        s.remove(a[i]);
                    }
                    if (s.isEmpty()) {
                        r = i + 1;
                        break;
                    }
                }
                for (int i = r; i < n; i++) {
                    if (ss.contains(a[i])) {
                        ss.remove(a[i]);
                    }
                }
                if (ss.isEmpty()) {
                    System.out.println(2);
                    System.out.println(1 + " " + r);
                    System.out.println((r + 1) + " " + n);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
