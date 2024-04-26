package com.myproject.test.trie;

public class BinaryTrieNode {

    BinaryTrieNode[] links;

    BinaryTrieNode(){
        links = new BinaryTrieNode[2];
    }

    public boolean contains(int b){
        return links[b] != null;
    }

    public BinaryTrieNode get(int b){
        return links[b];
    }

    public void add(int b, BinaryTrieNode node) {
        links[b] = node;
    }
}
