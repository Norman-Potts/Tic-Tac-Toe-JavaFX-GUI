 
package tic.tac.toe.javafx.gui;


import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/** Class TicTacToeJavaFXGUI
 *
 * @author Norman
 */
public class TicTacToeJavaFXGUI extends Application {    
      
    /** Method main
     *      Calls launch method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }/// End of method main.
    
    
    
    /** Overridden Method start
     *      Starts up graphical user interface. 
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) throws IOException {        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);                
        primaryStage.setTitle("Tic Tac Toe Game");
        primaryStage.setScene(scene);
        primaryStage.show();                
    }/// End of method start.

}/// End of class TicTacToeGame.


