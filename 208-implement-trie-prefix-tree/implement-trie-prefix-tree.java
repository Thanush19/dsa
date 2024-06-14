class MyTrie {
    List<int[]> tr;
    List<Boolean> isWord;
    int root, id;
    
    private int[] newchild() {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        return arr;
    }
    
    public MyTrie() {
        tr = new ArrayList<>();
        isWord = new ArrayList<>();
        isWord.add(false);
        tr.add(newchild());
        root = 0;
        id = 1;
    }
    
    private int newnode() {
        int newnode = id;
        id++;
        isWord.add(false);
        tr.add(newchild());
        return newnode;
    }
    
    public void add(String s) {
        int u = root;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(tr.get(u)[c] == -1) {
                tr.get(u)[c] = newnode();
            }
            u = tr.get(u)[c];
        }
        isWord.set(u, true);
    }
    
    public int find(String s) {
        int u = root;
        for(int i = 0; i < s.length() && u != -1; i++) {
            int c = s.charAt(i) - 'a';
            u = tr.get(u)[c];
        }
        return u;
    }
}

class Trie {
    MyTrie tr;
    public Trie() {
        tr = new MyTrie();
    }
    
    public void insert(String word) {
        tr.add(word);
    }
    
    public boolean search(String word) {
        int node = tr.find(word);
        return node != -1 && tr.isWord.get(node);
    }
    
    public boolean startsWith(String prefix) {
        int node = tr.find(prefix);
        return node != -1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */