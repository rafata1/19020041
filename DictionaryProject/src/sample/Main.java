package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {

    private static DictionaryManagement myDictionaryManagement;
    private static ArrayList<String> keyWordList;
    private static void loadData() {

        myDictionaryManagement = new DictionaryManagement();
        myDictionaryManagement.insertFromFile("data/vocabulary.txt");
        keyWordList = myDictionaryManagement.getDictionary().getKeyWordList();
    }

    public static ArrayList<String> getKeyWordList() {
        return keyWordList;
    }

    public static Word findWord(String keyWord) {
        return myDictionaryManagement.getDictionary().findWord(keyWord);
    }

    public static String suggestWord(String keyWord) {
        return myDictionaryManagement.getDictionary().suggestWord(keyWord);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.show();
    }


    public static void main(String[] args)  {
        loadData();
        launch(args);
    }
}
