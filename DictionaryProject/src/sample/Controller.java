package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


// Java code to convert text to speech

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //processing elements

    @FXML
    private TextField searchTextField;
    @FXML
    private TextArea definitionTextField;
    @FXML
    private ListView<String> wordListView;

    private TextToSpeech textToSpeech;

    public void renderWord(Word word, boolean needToScroll) {
        if (word != null) {
            definitionTextField.setText(word.getWordTarget() + "       " + word.getWordPronunciation() + '\n' + word.getWordExplain());
            if (needToScroll) {
                wordListView.scrollTo(word.getWordTarget());
                wordListView.getSelectionModel().select(word.getWordTarget());
            }
        } else {
            definitionTextField.setText("Word not found");
        }
    }

    public void onFindButtonClicked(ActionEvent event) {
        String keyWord = searchTextField.getText();
        keyWord = keyWord.toLowerCase();
        Word result = Main.findWord(keyWord);
        renderWord(result, true);
    }

    public void onSpeakButtonClicked(ActionEvent event) {
        String wordToSay = wordListView.getSelectionModel().getSelectedItem();
        if (wordToSay == null || wordToSay.length() == 0) return;
        textToSpeech.say(wordToSay);

    }

    public void onEditButtonClicked(ActionEvent event) {
        definitionTextField.setEditable(true);
    }

    public void onSaveButtonClicked(ActionEvent event) {
        definitionTextField.setEditable(false);
        // update word
        String s = definitionTextField.getText();
        Word updateWord = new Word();
        updateWord.setWordTarget(s.substring(s.indexOf('@') + 1, s.indexOf('/') - 1).trim());
        updateWord.setWordPronunciation(s.substring(s.indexOf("/"), s.lastIndexOf("/") + 1));
        updateWord.setWordExplain(s.substring(s.lastIndexOf("/") + 2, s.length()));
        Main.deleteWord(updateWord.getWordTarget());
        Main.addWord(updateWord);
        renderWord(updateWord, false);

    }

    public void onDeleteButtonClicked(ActionEvent event) {
        String wordToDelete = wordListView.getSelectionModel().getSelectedItem();
        if (wordToDelete == null || wordToDelete.length() == 0) return;
        Main.deleteWord(wordToDelete);
    }

    public void onListViewClicked(MouseEvent event) {
        String keyWord = wordListView.getSelectionModel().getSelectedItem();
        Word result = Main.findWord(keyWord);
        renderWord(result, false);
    }

    public void onAddButtonClicked(ActionEvent event) throws IOException {
        Parent viewNextParent = FXMLLoader.load(getClass().getResource("addWordDialog.fxml"));
        Scene nextView = new Scene(viewNextParent);
        Stage window = new Stage();
        window.setTitle("Add word dialog");
        window.setScene(nextView);
        window.show();
    }

    public void onSearchTextFieldKeyReleased(KeyEvent event) {
        String keyWord = searchTextField.getText();
        String autoCompletedWord = Main.suggestWord(keyWord);
        wordListView.scrollTo(autoCompletedWord);
        wordListView.getSelectionModel().select(autoCompletedWord);
    }

    public void updateListview(ArrayList<Word> allWords) {
        ObservableList<String> keyWords = FXCollections.observableArrayList();
        for (int i = 0; i < Main.allWords.size(); i++) {
            keyWords.add(Main.allWords.get(i).getWordTarget());
        }
        wordListView.setItems(keyWords);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textToSpeech = new TextToSpeech("kevin16");
        updateListview(Main.allWords);
    }
}
