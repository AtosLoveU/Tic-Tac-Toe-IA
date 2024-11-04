import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Controller_TicTacToe {
    
	@FXML
    private Button button1, button2, button3,button4, button5, button6, button7, button8, button9;
    @FXML
    private Button restart;
    @FXML
    private TextField joueurActuel;
    @FXML
    private TextField joueurGagnant;
    private Stage victoryStage;
    
    
    
    private Model_Jeu Model_Jeu = new Model_Jeu();
    Model_Grille Model_Grille = new Model_Grille();
    Model_Cells cellsClicked = new Model_Cells(0,0,Model_Cells.CellState.EMPTY);
    
    
    
    private void openVictoryWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View_Win.fxml"));
        Parent Node1 = fxmlLoader.load();
    
        Controller_Win Controller_Win = fxmlLoader.getController();
        Controller_Win.setMainController(this);
        String message;
        if (Model_Grille.winCondition()) {
            message = "Victoire du joueur : " + (Model_Jeu.getJoueur() == 1 ? "X" : "O");
        } else if (Model_Grille.DrawCondition()) {
            message = "C'est égalité !";
        } else {
            message = "";
        }
    
        Controller_Win.setJoueurGagnantText(message);
    
        victoryStage = new Stage();
        victoryStage.setScene(new Scene(Node1));
        victoryStage.initModality(Modality.APPLICATION_MODAL); 
        victoryStage.setResizable(false);
        victoryStage.showAndWait(); 
    }
    

    
    @FXML
    private void handleButtonClick(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();        
        switch (clickedButton.getId()) {
		case "button1":
			cellsClicked.setx(0);
			cellsClicked.sety(0);
			break;
        case "button2":
        	cellsClicked.setx(0);
			cellsClicked.sety(1);
            break;
        case "button3":
        	cellsClicked.setx(0);
			cellsClicked.sety(2);
            break;
        case "button4":
        	cellsClicked.setx(1);
			cellsClicked.sety(0);
            break;
        case "button5":
			cellsClicked.setx(1);
			cellsClicked.sety(1);
            break;
        case "button6":
			cellsClicked.setx(1);
			cellsClicked.sety(2);
            break;
        case "button7":
        	cellsClicked.setx(2);
			cellsClicked.sety(0);
            break;
        case "button8":
			cellsClicked.setx(2);
			cellsClicked.sety(1);
            break;
        case "button9":
			cellsClicked.setx(2);
			cellsClicked.sety(2);
            break;
		default:
			break;
    }

        if (
        	!clickedButton.getText().isEmpty()) {
            return;
            }
    	if(	
            Model_Jeu.getJoueur() == 0) {
            clickedButton.setText("X");
            clickedButton.setStyle("-fx-font-size: 50px;");
            Model_Grille.getTableau()[cellsClicked.getx()][cellsClicked.gety()].setEtat(Model_Cells.CellState.X);
            joueurActuel.setText("Tour du Joueur : O");
            }
        else{
        	clickedButton.setText("O");
            clickedButton.setStyle("-fx-font-size: 50px;");
            Model_Grille.getTableau()[cellsClicked.getx()][cellsClicked.gety()].setEtat(Model_Cells.CellState.O);
            joueurActuel.setText("Tour du Joueur : X");
        };

        if(clickedButton.getId() != "restart" || clickedButton.getId() != "restartWin"){
            Model_Jeu.Tour();
        }
        
        if(Model_Grille.DrawCondition() || Model_Grille.winCondition()) {
        	openVictoryWindow();
        }
    }
    
        @FXML
        public void handleRestart(ActionEvent event) {
            button1.setText("");
            button2.setText("");
            button3.setText("");
            button4.setText("");
            button5.setText("");
            button6.setText("");
            button7.setText("");
            button8.setText("");
            button9.setText("");    
            Model_Jeu = new Model_Jeu();
            Model_Grille = new Model_Grille();
            joueurActuel.setText("Tour du Joueur : X");
        }

 
        
}
