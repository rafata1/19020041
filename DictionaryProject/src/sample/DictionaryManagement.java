package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {

    private Dictionary myDictionary;

    public DictionaryManagement() {
        myDictionary = new Dictionary();
    }

    public DictionaryManagement(Dictionary myDictionary) {
        this.myDictionary = myDictionary;
    }

    //getter setter
    public void setDictionary(Dictionary newDictionary) {
        this.myDictionary = newDictionary;
    }

    public Dictionary getDictionary() {
        return myDictionary;
    }

    //load data word from file

    public void insertFromFile(String filePath) {


        File loadedFile = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(loadedFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        boolean tmpIsRead = false;
        String tmp = new String();
        while (scanner.hasNextLine()) {

            if(!tmpIsRead) tmp = scanner.nextLine();

            if(tmp.length()>0 && tmp.charAt(0) == '@') {
                Word loadedWord = new Word();
                if (tmp.contains("/")) {

                    loadedWord.setWordPronunciation(tmp.substring(tmp.indexOf('/'), tmp.lastIndexOf('/') + 1));
                    loadedWord.setWordTarget(tmp.substring(tmp.indexOf('@') + 1, tmp.indexOf('/') - 1));

                } else {
                    loadedWord.setWordTarget(tmp.substring(1, tmp.length()));
                }
                while(true) {
                    if(!scanner.hasNextLine()) break;
                    tmp = scanner.nextLine();

                    if(tmp.length() == 0 ) {
                        tmpIsRead = false;
                        break;
                    }

                    if(tmp.charAt(0) == '@') {
                        tmpIsRead = true;;
                        break;
                    }

                    if (tmp.charAt(0) == '*') {
                        loadedWord.setWordExplain(loadedWord.getWordExplain() + '\n' + tmp);
                    }

                    if (tmp.charAt(0) == '-') {
                        loadedWord.setWordExplain(loadedWord.getWordExplain() + '\n' + tmp);
                    }

                    if (tmp.charAt(0) == '=') {
                        tmp = tmp.replaceFirst("=", "Example: ");
                        tmp = tmp.replace('+', ':');
                        loadedWord.setWordExplain(loadedWord.getWordExplain() + '\n' + tmp);
                    }

                }
                if (loadedWord.getWordTarget().length() > 0) {
                    myDictionary.insert(loadedWord);
                }

            }


        }
    }

}
