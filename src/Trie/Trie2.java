package Trie;

public class Trie2 {
    static class Node{
        Node links[];
        int ew;
        int cntPrefix;
        public Node(){
            links = new Node[26];
            ew = 0;
            cntPrefix = 0;
        }
        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }
        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }
        void incrPrefix(){
            cntPrefix++;
        }
        void decrPrefix(){
            cntPrefix--;
        }
        void incrEw(){
            ew++;
        }
        void decrEw(){
            ew--;
        }
        Node getNode(char ch){
            return links[ch - 'a'];
        }
        int getEw(){
            return ew;
        }
        int getCntPrefix(){
            return cntPrefix;
        }
    }
    static Node root;
    public Trie2(){
        root = new Node();
    }
    static void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.getNode(word.charAt(i));
            node.incrPrefix();
        }
        node.incrEw();
    }
    static int countWordsEqualTo(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.getNode(word.charAt(i));
        }
        return node.getEw();
    }
    static int countWordsStartingWith(String prefix){
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))){
                return 0;
            }
            node = node.getNode(prefix.charAt(i));
        }
        return node.getCntPrefix();
    }
    static void erase(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                return;
            }
            node = node.getNode(word.charAt(i));
            node.decrPrefix();
        }
        node.decrEw();
    }

    public static void main(String[] args) {
        Trie2 T = new Trie2();
        insert("apple");
        insert("apple");
        insert("apps");
        insert("apps");
        String word1 = "apps";
        System.out.println("Count Words Equal to "+word1+" "+ countWordsEqualTo(word1));
        String word2 = "abc";
        System.out.println("Count Words Equal to "+word2+" "+ countWordsEqualTo(word2));
        String word3 = "ap";
        System.out.println("Count Words Starting With "+word3+" "+ countWordsStartingWith(word3));
        String word4 = "appl";
        System.out.println("Count Words Starting With "+word4+" "+ countWordsStartingWith(word4));
        erase(word1);
        System.out.println("Count Words equal to "+word1+" "+ countWordsEqualTo(word1));
    }
}
