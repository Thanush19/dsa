class Node{
    Node[] children;
    // boolean eow;
    String word;
    public Node(){
        children = new Node[26];
        for(int i=0; i<26; i++){
            children[i] = null;
        }
        word = null;
    }
}
class Solution{
    public List<String> findWords(char[][] board, String[] words){
        Node root = createTree(words);
        int n = board.length;
        int m = board[0].length;

        // List<String> list = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dfs(board, i, j, root, set);
            }
        }
        return new ArrayList<>(set);
    }
    public void dfs(char[][] board, int i, int j, Node node, Set<String> set){
        int n = board.length;
        int m = board[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '#'){
            return;
        }

        char ch = board[i][j];
        int index = ch - 'a';

        node = node.children[index];

        if (node == null){
            return;
        }

        if(node.word != null){
            set.add(node.word);
            node.word = null; // mark as visited to reduce duplicacy
        }

        board[i][j] = '#'; // mark visited

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int k=0; k<4; k++){
            int nr = i + dx[k];
            int nc = j + dy[k];

            if(nr>=0 && nr<n && nc>=0 && nc<m){
                dfs(board, nr, nc, node, set);
            }
        }
        board[i][j] = ch;  //Again restore character

    }
    public Node createTree(String[] words){
        Node root = new Node();
        for(String word: words){
            Node curr = root;
            for(int i=0; i<word.length(); i++){
                int index = word.charAt(i) - 'a';

                if(curr.children[index] == null){
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }
            curr.word = word;
        }
        return root;
    }
}