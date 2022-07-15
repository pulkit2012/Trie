package MaximumExorOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Trie {
    static class Node{
        Node[] links;
        public Node(){
            links = new Node[2];
        }
        boolean containsKey(int bit){
            return links[bit] != null;
        }
        Node getNode(int bit){
            return links[bit];
        }
        void put(int bit, Node node){
            links[bit] = node;
        }
    }
    static Node root;
    public Trie(){
        root = new Node();
    }
    static void insert(int num){
        Node node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.getNode(bit);
        }
    }
    static int getMax(int num){
        Node node = root;
        int max = 0;
        for (int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)){
                max = max | (1 << i);
                node = node.getNode(1 - bit);
            }
            else {
                node = node.getNode(bit);
            }
        }
        return max;
    }
    static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        Trie trie = new Trie();
        for(int i = 0;i<n;i++) {
            insert(arr1.get(i));
        }
        int maxi = 0;
        for(int i = 0;i<m;i++) {
            maxi = Math.max(maxi, getMax(arr2.get(i)));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int n = 2,m = 3;
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(6,8));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(7,8, 2));
        System.out.println(maxXOR(n,m,arr1,arr2));
    }
}
// There is one more same question in which an array is given and we have to find the maximum exor
//but here we have given sum queries of type (x , y)
//so we have to find xor of elements with x which are smaller than y;
//here we do same as we did in this question , just we make sure that in our trie for every query only those elements exist which are smaller than y
//------(Solution):- We can achieve this by sorting queries according to y, and also sort the array
//now our first query has least value of y and we also have sorted array, so insert in trie only those elements which are smaller than y
//and then move to the second query