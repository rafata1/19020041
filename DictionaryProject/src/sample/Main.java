package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    private static DictionaryManagement myDictionaryManagement;
    public static ArrayList<Word> allWords;

    private static void loadData() {

        myDictionaryManagement = new DictionaryManagement();

        try {
            FileInputStream fileIn = new FileInputStream("objectData/allWords.bin");
            ObjectInputStream input = new ObjectInputStream(fileIn);
            allWords = (ArrayList<Word>) input.readObject();
            input.close();
            fileIn.close();
            System.out.println("Loaded DM");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class Not Found");
            c.printStackTrace();
            return;
        }
        // update to treeTree
        for(int i=0; i < allWords.size(); i++) {
            myDictionaryManagement.getDictionary().insert(allWords.get(i));
        }

    }

    public static void saveData() {

        allWords = myDictionaryManagement.getDictionary().getAllWords();
        try {
            FileOutputStream fileOut = new FileOutputStream("objectData/allWords.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allWords);
            out.close();
            fileOut.close();
            System.out.println("Save DM!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Word findWord(String keyWord) {
        return myDictionaryManagement.getDictionary().findWord(keyWord);
    }

    public static String suggestWord(String keyWord) {
        return myDictionaryManagement.getDictionary().suggestWord(keyWord);
    }

    public static void deleteWord(String wordToDelete) {
        myDictionaryManagement.getDictionary().deleteWord(wordToDelete);
        //need to update ListView
    }

    public static void addWord(Word wordToAdd) {
        myDictionaryManagement.getDictionary().insert(wordToAdd);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            saveData();
        });
    }


    public static void main(String[] args) {
        loadData();
        launch(args);
    }
}
