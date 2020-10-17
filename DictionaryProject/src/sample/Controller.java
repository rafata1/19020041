package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //processing elements

    @FXML
    private TextField searchTextField;
    @FXML
    private TextArea definitionTextField;
    @FXML
    private ListView<String> wordListView;

    public void renderWord( Word word, boolean needToScroll) {
        if(word != null) {
            definitionTextField.setText(word.getWordTarget()+ "       " + word.getWordPronunciation() + '\n' + word.getWordExplain());
            if(needToScroll) {
                wordListView.scrollTo(word.getWordTarget());
                wordListView.getSelectionModel().select(word.getWordTarget());
            }
        } else
        {
            definitionTextField.setText("Word not found");
        }
    }

    public void onFindButtonClicked(ActionEvent event)
    {
        String keyWord = searchTextField.getText();
        keyWord = keyWord.toLowerCase();
        Word result = Main.findWord(keyWord);
        renderWord(result, true);
    }

    public void onListViewClicked(MouseEvent event) {
        String keyWord = wordListView.getSelectionModel().getSelectedItem();
        Word result = Main.findWord(keyWord);
        renderWord(result, false);
    }

    public void onSearchTextFieldKeyReleased (KeyEvent event) {
        String keyWord = searchTextField.getText();
        String autoCompletedWord = Main.suggestWord(keyWord);
        wordListView.scrollTo(autoCompletedWord);
        wordListView.getSelectionModel().select(autoCompletedWord);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> keyWords = FXCollections.observableArrayList(Main.getKeyWordList());
        wordListView.setItems(keyWords);
    }
}
