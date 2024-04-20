import java.util.*;

class Solution {
    class Pair {
        int r;
        int c;
        Pair(int i, int j) {
            r = i;
            c = j;
        }
    }
    
    public int[][] findFarmland(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        List<List<Integer>> lst = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && !vis[i][j]) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                    List<Integer> group = new ArrayList<>();
                    int r1 = i, c1 = j, r2 = i, c2 = j; // Initialize boundaries for the current group
                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        int r = p.r;
                        int c = p.c;
                        // Update boundaries
                        r1 = Math.min(r1, r);
                        c1 = Math.min(c1, c);
                        r2 = Math.max(r2, r);
                        c2 = Math.max(c2, c);
                        
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dx[k];
                            int nc = c + dy[k];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && a[nr][nc] == 1) {
                                vis[nr][nc] = true;
                                q.offer(new Pair(nr, nc));
                            }
                        }
                    }
                    group.add(r1);
                    group.add(c1);
                    group.add(r2);
                    group.add(c2);
                    lst.add(group);
                }
            }
        }
        
        int len = lst.size();
        int[][] ans = new int[len][4];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                ans[i][j] = lst.get(i).get(j);
            }
        }
        return ans;
    }
}
