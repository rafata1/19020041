package sample;

import java.util.ArrayList;
import java.util.Map;

public class Dictionary {

    //properties mang listword l danh sach cac tu
    // size la so luong tu
    private TrieTree myTrieTree;

    //constructor
    public Dictionary()
    {
        myTrieTree = new TrieTree();
    }

    //them tu vao tu dien

    public void insert(Word newWord)
    {
        myTrieTree.addWord(newWord);
    }

    // hien tat cac cac tu trong tu dien

    public void show()
    {
    }

    //tim kiem tu
    public Word findWord(String keyWord) {
        Word resultWord = myTrieTree.findWord(keyWord);
        return resultWord;
    }
}
