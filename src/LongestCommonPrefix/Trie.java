package LongestCommonPrefix;

public class Trie {
    static class Node{
        Node links[];
        boolean flag;
        public Node(){
            links = new Node[26];
            flag = false;
        }
        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }
        void put(char ch, Node node){
            links[ch - 'a']  = node;
        }
        Node getNode(char ch){
            return links[ch - 'a'];
        }
        void setFlag(){
            flag = true;
        }
        boolean hasChild(int i){
            return links[i] != null;
        }
        boolean isEnd(){
            return flag;
        }
        Node getNodeFromIndex(int i){
            return links[i];
        }
    }
    static Node root;
    static int index;
    public Trie(){
        root = new Node();
    }
    static void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.getNode(word.charAt(i));
        }
        node.setFlag();
    }
    static int countChildren(Node node){
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(node.hasChild(i)){
                count++;
                index = i;
            }
        }
        return count;
    }
    static String longestCommonPrefix(){
        String str = "";
        index = 0;
        Node node = root;
        while (countChildren(node) == 1 && !node.isEnd()){
            node = node.getNodeFromIndex(index);
            str += (char)('a' + index);
        }
        return str;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        String[] arr2 = {"hello","world"};
        for(String c : arr2){
            insert(c);
        }
        System.out.println(longestCommonPrefix());
    }
}
