package me.macd.dfa.demo;

import static org.junit.Assert.*;

public class TrieTreeBuilderTest {

    @org.junit.Test
    public void build() {
        TrieState root = new TrieTreeBuilder().addWords("abc","abd","bcd","ab").build();
        assertEquals(root.toString(), "{\"isEnd\":false,\"a\":{\"isEnd\":false,\"b\":{\"isEnd\":true,\"c\":{\"isEnd\":true},\"d\":{\"isEnd\":true}}},\"b\":{\"isEnd\":false,\"c\":{\"isEnd\":false,\"d\":{\"isEnd\":true}}}}");
    }
}