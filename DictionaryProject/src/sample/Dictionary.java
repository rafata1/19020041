package sample;

import java.util.ArrayList;
import java.util.Map;

public class Dictionary {

    //properties mang listword l danh sach cac tu
    // size la so luong tu
    private TrieTree myTrieTree;
    private ArrayList<String> keyWordList;
    //constructor
    public Dictionary()
    {
        keyWordList = new ArrayList<String>();
        myTrieTree = new TrieTree();
    }

    //them tu vao tu dien

    public void insert(Word newWord)
    {
        if(myTrieTree.findWord(newWord.getWordTarget()) == null) {
            keyWordList.add(newWord.getWordTarget());
        }
        myTrieTree.addWord(newWord);
    }


    //tim kiem tu
    public Word findWord(String keyWord) {
        Word resultWord = myTrieTree.findWord(keyWord);
        return resultWord;
    }

    public String suggestWord(String keyWord) {
        return myTrieTree.suggestWord(keyWord);
    }

    // cai nay la danh sach cac tu khoa
    public ArrayList<String> getKeyWordList() {
        return keyWordList;
    }

}
