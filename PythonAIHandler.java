import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonAIHandler {

    private final String scriptPath;

    public PythonAIHandler(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    //permet de lancer le script python et de récuperer l'output sous forme de texte
    public int getBestMove(String boardState) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "C:\\Users\\loris\\PROJET-VSCODE\\Projet_Morpion_IA\\Tic-Tac-Toe-IA\\minimax.py", boardState); 
            //modifier l'emplacement au dessus pour mettre le chemin vers votre script python minimax

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    
            String line;
            int bestMove = -1;
    
            if ((line = reader.readLine()) != null) {
                bestMove = Integer.parseInt(line);
            }
    
            process.waitFor();
            return bestMove;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
