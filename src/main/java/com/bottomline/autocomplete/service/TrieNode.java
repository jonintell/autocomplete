package com.bottomline.autocomplete.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private List<String> allWords;
    private boolean isEndOfWord;
    private String word;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        word = null;
        allWords = new ArrayList<>();
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public String getWord() {
        return word;
    }


    public void addWord(String word) {
        allWords.add(word);
    }

    public void setWord(String word) {
        this.word = word;
    }


    // Helper method to find all words in the subtree rooted at 'node'
    private void findAllWords(TrieNode node, List<String> results, int k) {
        if (results.size() == k) {
            return; // We've found 'k' words, stop the search
        }
        if (node.isEndOfWord()) {
            results.add(node.getWord());
        }
        for (TrieNode child : node.getChildren().values()) {
            findAllWords(child, results, k);
        }
    }

    public List<String> getAlLWords() {
        return allWords;
    }
}

