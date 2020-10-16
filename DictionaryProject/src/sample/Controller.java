package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    //processing elements

    @FXML
    private TextField searchTextField;
    private TextArea definitionTextField;
    private ListView wordListView;

    public void onFindButtonClicked(ActionEvent event)
    {
        String keyWord = searchTextField.getText();
        keyWord = keyWord.toLowerCase();
        Word result = Main.findWord(keyWord);
        if(result != null) {
            definitionTextField.setText(result.getWordTarget()+ "       " + result.getWordPronunciation() + '\n' + result.getWordExplain());
        } else
        {
            definitionTextField.setText("Word not found");
        }
    }

}
