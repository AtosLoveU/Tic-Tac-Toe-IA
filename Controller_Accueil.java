import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller_Accueil {

    int isIA;

    @FXML
    private void openHumain() {
        isIA = 0;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View_TicTacToe.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("TicTacToe vs HUMAIN");
            stage.setScene(new Scene(root));
            
            stage.show();  // Montre la fenêtre
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void openIA() {
        isIA = 1;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View_TicTacToe.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("TicTacToe vs IA");
            stage.setScene(new Scene(root));
            
            stage.show();  // Montre la fenêtre
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getIA(){
        return isIA;
    }
}
