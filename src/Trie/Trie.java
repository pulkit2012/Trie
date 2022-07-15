package Trie;

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
            links[ch - 'a'] = node;
        }
        Node get(char ch){
            return links[ch - 'a'];
        }
        void setEnd(){
            flag = true;
        }
        boolean isEnd(){
            return flag;
        }
    }

    static Node root;
    Trie(){
        root = new Node();
    }
    static void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    static boolean search(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    static boolean startsWith(String prefix){
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 5;
        int type[] = {1,1,2,3,2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            if(type[i] == 1){
                insert(value[i]);
            }
            else if(type[i] == 2){
                System.out.println(search(value[i]));
            }
            else{
                System.out.println(startsWith(value[i]));
            }
        }
    }
}
