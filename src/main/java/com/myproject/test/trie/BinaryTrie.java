package com.myproject.test.trie;

public class BinaryTrie {

    private BinaryTrieNode root;

    BinaryTrie() {
        this.root = new BinaryTrieNode();
    }

    public void insert(int num) {
        BinaryTrieNode temp = root;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (!temp.contains(bit)) {
                temp.add(bit, new BinaryTrieNode());
            }
            temp = temp.get(bit);
        }
    }

    public int getMaxXor(int num) {
        BinaryTrieNode temp = root;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (temp.contains(1 - bit)) {
                max = max | 1 << i;
                temp = temp.get(1 - bit);
            } else {
                temp = temp.get(bit);
            }
        }
        return max;
    }
}
