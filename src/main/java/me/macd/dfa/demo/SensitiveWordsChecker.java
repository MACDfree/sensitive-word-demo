package me.macd.dfa.demo;

import java.util.LinkedHashSet;
import java.util.Set;

public class SensitiveWordsChecker {
    private final TrieState root;

    public SensitiveWordsChecker(TrieState root) {
        this.root = root;
    }

    public Set<String> check(String text) {
        if (text == null || "".equals(text)) {
            return null;
        }
        Set<String> illWords = new LinkedHashSet<>();
        for (int i = 0; i < text.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char c = text.charAt(i);
            TrieState start = root.getTrieState(c);
            if (start == null) {
                continue;
            }

            stringBuilder.append(c);
            int j = i;
            TrieState next = start;
            // 记录最近匹配成功的敏感词，主要是为了实现最大匹配
            String illWord = null;
            while (true) {
                j++;
                if (j == text.length()) {
                    break;
                }
                c = text.charAt(j);
                next = next.getTrieState(c);
                stringBuilder.append(c);
                if (next == null) {
                    break;
                }
                if (next.isEnd()) {
                    illWord = stringBuilder.toString();
                }
                if (next.isTerminal()) {
                    break;
                }
            }
            if (illWord != null && !"".equals(illWord)) {
                illWords.add(illWord);
            }
        }

        return illWords;
    }
}
