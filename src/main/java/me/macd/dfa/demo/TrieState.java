package me.macd.dfa.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 表示DFA/字典树中的状态节点
 */
public class TrieState {
    // 是否是终止状态
    boolean isEnd;
    // 可走的边，key为边的条件，value为下一个状态
    Map<String, TrieState> edges;

    public TrieState() {
        this.isEnd = false;
        edges = new HashMap<>();
    }

    public void addEdge(String key, TrieState nextTrieState) {
        this.edges.put(key, nextTrieState);
    }

    public void addEdge(char key, TrieState nextTrieState) {
        addEdge(String.valueOf(key), nextTrieState);
    }

    /**
     * 根据 key 找到下一个状态
     *
     * @param key
     * @return
     */
    public TrieState getTrieState(String key) {
        return this.edges.get(key);
    }

    /**
     * 根据 key 找到下一个状态
     *
     * @param key
     * @return
     */
    public TrieState getTrieState(char key) {
        return getTrieState(String.valueOf(key));
    }

    /**
     * 是否是结束状态
     *
     * @return
     */
    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * 是否是终止（叶子）节点
     *
     * @return
     */
    public boolean isTerminal() {
        return this.edges.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"").append("isEnd\":").append(isEnd)
                .append(",");
        for (Map.Entry<String, TrieState> entry : edges.entrySet()) {
            sb.append("\"").append(entry.getKey()).append("\":").append(entry.getValue()).append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
