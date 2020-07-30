package me.macd.dfa.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TrieTreeBuilder {
    private final List<String> words;

    public TrieTreeBuilder() {
        this.words = new ArrayList<>();
    }

    public TrieTreeBuilder addWords(Collection<String> words) {
        this.words.addAll(words);
        return this;
    }

    public TrieTreeBuilder addWords(String... words) {
        return this.addWords(Arrays.asList(words));
    }

    public TrieState build() {
        if (words.size() == 0) {
            return null;
        }

        TrieState root = new TrieState();
        for (String word : words) {
            if (word == null || "".equals(word)) {
                continue;
            }
            TrieState current = root;
            for (char c : word.toCharArray()) {
                TrieState next = current.getTrieState(c);
                if (next == null) {
                    next = new TrieState();
                    current.addEdge(c, next);
                }
                current = next;
            }
            current.setEnd(true);
        }

        return root;
    }
}
