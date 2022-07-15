package LongestWordWithAllPrefixes;

public class Trie {
    static class Node{
        Node links[];
        boolean flag;

        public Node() {
            links = new Node[26];
            flag = false;
        }
        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }
        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }
        Node getNode(char ch){
            return links[ch - 'a'];
        }
        void setEnd(){
            flag = true;
        }
        boolean getFlag(){
            return flag;
        }
    }
    static Node root;
    public Trie(){
        root = new Node();
    }
    static void Insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.getNode(word.charAt(i));
        }
        node.setEnd();
    }
    static boolean checkIfPrefixExist(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.getNode(word.charAt(i));
            if(!node.getFlag()){
                return false;
            }
        }
        return true;
    }
    static String completeString(int n, String[] arr){
        Trie trie = new Trie();
        for(String c : arr){
            Insert(c);
        }
        String largestString = "";
        for(String c : arr){
            if(checkIfPrefixExist(c)){
                if(largestString.length() < c.length()){
                    largestString = c;
                }
                else if(largestString.length() == c.length() && largestString.compareTo(c) > 0){
                    largestString = c;
                }
            }
        }
        return largestString.equals("") ? "NONE" : largestString;
    }

    public static void main(String[] args) {
        int n = 6;
        String[] arr = {"n" ,"ni" ,"nin" ,"ninj", "ninja", "ninga"};
        System.out.println(completeString(n,arr));
        String[] arr2 = {"ab","bc"};
        System.out.println(completeString(n,arr2));


    }
}
