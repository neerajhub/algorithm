package com.myproject.test.trie;

public class Trie {
    private static TrieNode root;
    Trie(){
         root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
       // int count = trie.allPossibleSubstring("abc");
        String []arr= {"n", "ni", "nin", "ninj", "ninja", "ninga"};
        System.out.println(trie.completeString(6,arr));
    }

    public  void insert(String word) {
        if(word == null) return;
        int length = word.length();
        TrieNode temp = root;
        for(int i = 0; i < length; i++){
            if(!temp.containsKey(word.charAt(i))){
                temp.put(word.charAt(i), new TrieNode());
            }
            temp = temp.get(word.charAt(i));
        }
        temp.setEnd();
    }

    public  boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.containsKey(c)){
                node = node.get(c);
            }else {
                return false;
            }
        }
        return node.isEnd();
    }
    public  boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.containsKey(c)){
                node = node.get(c);
            }else {
                return false;
            }
        }
        return true;
    }

    public  int allPossibleSubstring(String word){
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            TrieNode node= root;
            for(int j = i; j < word.length(); j++){
                char c = word.charAt(i);
                if(!node.containsKey(c)){
                    node.put(c, new TrieNode());
                    count++;
                }
                node = node.get(c);
            }
        }
        return count + 1;
    }

    public  String completeString(int n, String[] a) {
        for(String str : a){
            insert(str);
        }
        int count = 0;
        String s = new String();
        for(String str : a){
            if(checkPrefixesExist(str)){
                if(s.length() < str.length()) s = str;
            }
        }
        return s;
    }

    public  boolean checkPrefixesExist(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                TrieNode child = node.get(c);
                if (!child.isEnd()) {
                    return false;
                }
                node = child;
            } else {
                return false;
            }
        }
        return true;
    }

}
