package homework.tries;

import data_structures.trees.trie.Node;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;

    class TrieNode{
        Map<Character, TrieNode> node;
        boolean isWord;

        TrieNode(){
            this.node = new HashMap<>();
            isWord = false;
        }

        public Map<Character, TrieNode> getNode() {
            return node;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;

        /*
           for each character in the word check if that character exists
           in hashmap, if not then add the character as a key in the map
           and a new node as its value. Do this until all characters are
           traversed.
        */
        for (char ch : word.toCharArray()) {
            current.getNode().putIfAbsent(ch, new TrieNode());
            current = current.getNode().get(ch);
        }
        current.setWord(true);
    }

    public boolean isCompleteWord(String word){
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (current.getNode().containsKey(ch)) {
                current = current.getNode().get(ch);
            } else {
                return false;
            }
        }
        return current.isWord;
    }


    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("mug");
        trie.insert("mugger");
        System.out.println(trie.isCompleteWord("mug"));
        System.out.println(trie.isCompleteWord("muggered"));
    }
}