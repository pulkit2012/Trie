package NumberOfDistinctSubstrings;

public class Trie {
    static class Node{
        Node links[];


        public Node() {
            links = new Node[26];

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

    }


    static int countDistinctSubstrings(String word){
        Node root = new Node();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            Node node = root;
            for (int i1 = i; i1 < word.length(); i1++) {
                if(!node.containsKey(word.charAt(i1))){
                    node.put(word.charAt(i1),new Node());
                    count++;
                }
                node = node.getNode(word.charAt(i1));
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("sds"));
        System.out.println(countDistinctSubstrings("ccfdf"));
    }
}
