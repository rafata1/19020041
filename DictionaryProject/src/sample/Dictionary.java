package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Dictionary {

    //properties mang listword l danh sach cac tu
    // size la so luong tu
    private TrieTree myTrieTree;

    //constructor
    public Dictionary() {
        myTrieTree = new TrieTree();
    }

    //them tu vao tu dien

    public void insert(Word newWord) {
        myTrieTree.addWord(newWord);
    }


    //tim kiem tu
    public Word findWord(String keyWord) {
        Word resultWord = myTrieTree.findWord(keyWord);
        return resultWord;
    }

    //delete word
    public void deleteWord(String wordToDelete) {
        myTrieTree.deleteWord(wordToDelete);
    }

    public String suggestWord(String keyWord) {
        return myTrieTree.suggestWord(keyWord);
    }

    // cai nay la danh sach cac tu khoa
    public ArrayList<Word> getAllWords() {
        return myTrieTree.getAllWords();
    }

}
