package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddWordController {

    @FXML
    private TextField wordTargetTextField;
    @FXML
    private TextField wordPronunciationTextField;
    @FXML
    private TextArea wordExplainTextField;

    public void onSaveButtonClicked(ActionEvent event) {
        Word newWord = new Word();
        newWord.setWordTarget(wordTargetTextField.getText());
        newWord.setWordPronunciation(wordPronunciationTextField.getText());
        newWord.setWordExplain(wordExplainTextField.getText());
        Main.addWord(newWord);
        // show alert

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setContentText("Please restart the application to take the effect");
        alert.show();
    }

}
