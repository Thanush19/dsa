class Solution {
    public int removeStones(int[][] stones) {
        //we are given wwhere stones are present, but no the dimentions of grid
        //finding where the last stone is on the grid on row - gives us row dimension
        //finding where the last stone is on the grid on col - gives us col dimension
        int max_row = 0;
        int max_col = 0;
    
        for(int[] i : stones){
            max_row = Math.max(max_row,i[0]);
            max_col = Math.max(max_col,i[1]);
        }
         
        UnionFind uf = new UnionFind(max_row + max_col + 1);
        HashSet<Integer> stoneNodes = new HashSet<>();

        for(int[] it : stones){
            int node_row = it[0];
            int node_col = it[1] + max_row + 1;
            uf.unionBySize(node_row,node_col); //merging node row and node column
            stoneNodes.add(node_row);
            stoneNodes.add(node_col);
        }

        int count = 0;
        for(int it : stoneNodes){
            if(uf.find(it) == it){
                 count++;
            }
        }
        return stones.length - count;
    }
}
class UnionFind {
        public int[] parent;
        public int[] rank;
        public int[] size;

        public UnionFind(int n) {
            n++;
            parent = new int[n];
            rank = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int p) {
        	if(p == parent[p]) {
                return p;
            }
            return parent[p] = find(parent[p]); //path compression
        }
        
        public void unionByRank(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            if(rank[rootQ] > rank[rootP]) { //q larger, make Q parent
                parent[rootP] = rootQ;
            }
            else if(rank[rootQ] < rank[rootP]){ //p larger, make p parent
                parent[rootQ] = rootP;
            }
            else{
                  parent[rootQ] = rootP; //both are same, then make anyone parent and increase it's rank
                  rank[rootP]++;
             
            }
        }

        public void unionBySize(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            if(size[rootQ] > size[rootP]) { //q larger, make Q parent
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            else{ //p larger, make p parent
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }
}