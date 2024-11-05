import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    private int isIA;
    
    
    private Model_Jeu Model_Jeu = new Model_Jeu();
    Model_Grille Model_Grille = new Model_Grille();
    Model_Cells cellsClicked = new Model_Cells(0,0,Model_Cells.CellState.EMPTY);
    private PythonAIHandler pythonAIHandler = new PythonAIHandler("C:\\Users\\loris\\PROJET-VSCODE\\Projet_Morpion_IA\\Tic-Tac-Toe-IA\\minimax.py");

    public void setIsIA(int isIA) {
        this.isIA = isIA;
    }
    
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

        victoryStage.setOnCloseRequest(event -> {
            Stage primaryStage = (Stage) joueurActuel.getScene().getWindow();
            primaryStage.close();
        });

        victoryStage.showAndWait(); 
    }
    

    // au moment du clique d'un joueur
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
            clickedButton.setStyle("-fx-font-size: 50px; -fx-font-family: 'DejaVu Sans';");
            Model_Grille.getTableau()[cellsClicked.getx()][cellsClicked.gety()].setEtat(Model_Cells.CellState.X);
            joueurActuel.setText("Tour du Joueur : O");
            }
        else{
        	clickedButton.setText("O");
            clickedButton.setStyle("-fx-font-size: 50px; -fx-font-family: 'DejaVu Sans';");

            Model_Grille.getTableau()[cellsClicked.getx()][cellsClicked.gety()].setEtat(Model_Cells.CellState.O);
            joueurActuel.setText("Tour du Joueur : X");
        };

        if(clickedButton.getId() != "restart" || clickedButton.getId() != "restartWin"){
            Model_Jeu.Tour();
        }

        //Partie où l'ia joue
        if(isIA == 1) {
            if (Model_Jeu.getJoueur() == 1) {
                String boardState = getBoardState();
                int bestMove = pythonAIHandler.getBestMove(boardState);
                if (bestMove != -1) {
                    playAIMove(bestMove);
                }
            }
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

    
	public String getBoardState() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Model_Cells.CellState state = Model_Grille.getTableau()[i][j].getEtat();
                if (state == Model_Cells.CellState.X) {
                    board.append("X");
                } else if (state == Model_Cells.CellState.O) {
                    board.append("O");
                } else {
                    board.append("-");
                }
            }
        }
        return board.toString(); 
    }


    private void playAIMove(int move) {
        if (move == -1) {
            return;
        }
        
        Button[] buttons = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
        Button selectedButton = buttons[move];
        if (selectedButton.getText().isEmpty()) {
            selectedButton.setText("O");
            selectedButton.setStyle("-fx-font-size: 50px; -fx-font-family: 'DejaVu Sans';");
            Model_Grille.getTableau()[(move) / 3][(move) % 3].setEtat(Model_Cells.CellState.O);
            joueurActuel.setText("Tour du Joueur : X");
            Model_Jeu.Tour();
        }
    }
    
    
}
