public class StreamCharacters {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    StringBuilder sb;
    
    public void StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word: words) {
            insert(word);
        }        
    }
    
    private void insert(String word) {
        TrieNode current = root;
        for(int i=word.length()-1;i>=0;i--) {
            int charAtIndex = word.charAt(i) - 'a';
            if(current.children[charAtIndex] == null) {
                current.children[charAtIndex] = new TrieNode();
            }
            current = current.children[charAtIndex];
        }
        current.isEnd = true;
    }
    
    private boolean search() {
        TrieNode current = root; 
        for(int i=sb.length()-1;i>=0;i--) {
            int charAtIndex = sb.charAt(i) - 'a';
            if(current.children[charAtIndex] == null) {
                return false;
            }
            current = current.children[charAtIndex];
            if (current.isEnd) return true;
        }
        return false;
    }
    
    //TC: O(K) As have built the trie node in the constructor itsef. The time complexity is only for search
    //SC: O(NK) Where N is number of words. and K is the average length of letter.
    public boolean query(char letter) {
        sb.append(letter);
        return search();
    }

}