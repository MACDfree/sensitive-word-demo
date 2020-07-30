package me.macd.dfa.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class SensitiveWordsCheckerTest {
    @Test
    public void check() {
        TrieState root = new TrieTreeBuilder().addWords("abc","abd","bcd","ab").build();
        SensitiveWordsChecker checker = new SensitiveWordsChecker(root);
        Set<String> illWords = checker.check("12adwe2331qweasdabcdasdcdbsdf2aqqwqxz");
        assertTrue(illWords.containsAll(Arrays.asList("abc", "bcd")));
    }
}