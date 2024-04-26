package com.myproject.test.trie;

    public class TrieNode {

        private TrieNode [] links = new TrieNode[26];
        boolean flag = false;


        boolean containsKey(Character ch){
            return links[ch- 'a'] != null;
        }

        public TrieNode get(Character ch){
            if(links[ch- 'a'] != null){
                return links[ch- 'a'] ;
            }
            return null;
        }

        void put(Character ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }
