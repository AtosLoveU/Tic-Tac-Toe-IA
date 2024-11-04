import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_Win {
    private Controller_TicTacToe main;
    
    @FXML
    private Button restartWin;
    @FXML
    private TextField joueurGagnant;



    public void setMainController(Controller_TicTacToe Controller_TicTacToe) {
        this.main = Controller_TicTacToe;
    }
    
    @FXML
    private void handleRestartWin(ActionEvent event) {
        if (main != null) {
            main.handleRestart(null);
        }

        Stage stage = (Stage) restartWin.getScene().getWindow();
        stage.close();
    }

    
    public void setJoueurGagnantText(String text) {
        joueurGagnant.setText(text);
    }   
}
