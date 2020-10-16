package sample;

import sun.text.normalizer.Trie;

class TrieNode {

    private boolean isWord;
    private Word value;

    private TrieNode [] child = new TrieNode[30];

    public TrieNode() {
        isWord = false;
        value = null;
        for(int i = 0; i < 30; i++){
            child[i] = null;
        }
    }

    public TrieNode(Word value, boolean isWord) {
        this.value = value;
        this.isWord = isWord;
        for(int i = 0; i < 30; i++){
            child[i] = null;
        }
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Word getValue() {
        return value;
    }

    public void setValue(Word value) {
        this.value = value;
    }

    private int ordOfCharacter(char characterToChild) {
        int childOrd = 0;
        if('a' <= characterToChild && characterToChild <='z') {
            childOrd = characterToChild - 'a';
        }
        else {
            childOrd = 27;
        }
        return  childOrd;
    }

    public void setChild(TrieNode childNode, char characterToChild) {
        int childOrd = ordOfCharacter(characterToChild);
        child[childOrd] = childNode;
    }

    public TrieNode getChild(char characterToChild) {
        return child[ordOfCharacter(characterToChild)];
    }

}

public class TrieTree {
    TrieNode root;

    public  TrieTree() {
        root = new TrieNode();
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public TrieNode getRoot() {
        return root;
    }

    static int cnt = 0;

    public void addWord(Word word) {

        TrieNode cur = root;
        String s = word.getWordTarget();
        for(int i = 0; i < s.length(); i++) {
            if(cur.getChild(s.charAt(i)) == null) {
                cur.setChild(new TrieNode(), s.charAt(i));
            }
            cur = cur.getChild(s.charAt(i));
        }
        if(cur.getValue() == null) {
            cur.setWord(true);
            cur.setValue(word);
        } else {
            cur.getValue().setWordExplain(cur.getValue().getWordExplain()  + word.getWordExplain());
        }

    }

    public Word findWord(String keyWord) {
        TrieNode cur = root;
        for(int i = 0; i < keyWord.length(); i++) {
            if(cur.getChild(keyWord.charAt(i)) == null) {
                return null;
            }
            cur = cur.getChild(keyWord.charAt(i));
        }
        return cur.getValue();
    }

}
