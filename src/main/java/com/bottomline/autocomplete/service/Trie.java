package com.bottomline.autocomplete.service;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * insert word keeping recorder in eahc node of all bellow words
     * @param word
     */
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, c -> new TrieNode());
            current.addWord(word); // Add word to allWords to retrieve list directly (Storage expensive but fast)
        }
        current.setEndOfWord(true);
    }

    /**
     *
     * @param prefix
     * @return
     */
    public List<String> autocomplete(String prefix) {
        List<String> results = new LinkedList<>();
        TrieNode current = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return results;
            }
            current = node;
        }
        return current.getAlLWords();
    }

}
