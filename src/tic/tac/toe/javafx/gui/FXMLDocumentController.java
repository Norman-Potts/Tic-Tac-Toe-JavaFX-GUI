
package tic.tac.toe.javafx.gui;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *  Define callbacks for GUI events, this is your primary connection with the 
 *  presentation layer.
 * 
 * @author Norman 
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private GridPane myGrid;        
    /// Using an ArrayList of buttons to make it easier to change all the buttons.
    ArrayList<Button> buttons = new ArrayList<Button>();        
    /**
     * Note to self. Java FX ids will get assigned to the variable if you put
     * '@FXML' first... 
     * 
     */
    
    @FXML
    private Button btn_topleft;  
    @FXML
    private Button btn_topcenter; 
    @FXML
    private Button btn_topright;
    @FXML
    private Button btn_middleleft;
    @FXML
    private Button btn_middlecenter;
    @FXML
    private Button btn_middleright;
    @FXML
    private Button btn_bottomleft;
    @FXML
    private Button btn_bottomcenter;
    @FXML
    private Button btn_bottomright;

    /// Switch for when game is won.
    boolean gameover = false;
    
    /// Create game engine.
    Engine game = new Engine();
    

    /** FXML Method NewGame
     *  This method is binded to the 'New Game' button.
     *  This method will start a new game. Duhh.
     * @param event 
     */
    @FXML
    private void NewGame(ActionEvent event)
    {        
        game.reset();    
        setupbuttons();/// set up the buttons again.     
        gameover = false;        
    }/// End of method NewGame.
    
    
    
    /** Method initialize
     *     Initializes the controller class. adds buttons to buttons arraylist.
     *     calls method setupbuttons.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {               
        buttons.add(btn_topleft);
        buttons.add(btn_topcenter);
        buttons.add(btn_topright);
        buttons.add(btn_middleleft);
        buttons.add(btn_middlecenter);
        buttons.add(btn_middleright);
        buttons.add(btn_bottomleft);
        buttons.add(btn_bottomcenter);
        buttons.add(btn_bottomright);        
        setupbuttons();   
    }/// End of method initialize

 
    
    
    /** Method setupbuttons
     *  
     *      Give functionality to buttons. Sets text of buttons, sets color 
     *      of buttons.
     * 
     */
    private void setupbuttons()
    {                         
        for(int i=0; i < 9; i++)
        {
            Button item = buttons.get(i);
            item.setText(""); 
            item.setId(""+i+"");        
            item.setStyle("-fx-background-color: transparent; ");
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) 
                {                                                                                                    
                    if (event.getClickCount() == 1) 
                    {
                        String currentText = item.getText();    
                        
                        /// if the current text in the button isnt already X or O and the game is not over.
                        // Then do what needs to be done when a button gets clicked.
                        if(!currentText.equals("X") && !currentText.equals("O") && gameover == false )
                        {                           
                            item.setText("X");
                            String id = item.getId();
                            /// Player selected a button.                                                
                            int r = game.PlayerSelected(id);  
                            if(r == -1)
                            {   
                                System.out.println(" End of game ");
                            }
                            else
                            {                            
                                Button ComputerChoice = buttons.get(r);                           
                                ComputerChoice.setText("O");                            
                            }
                           int answer =  game.hasGameBeenWon();
                            
                           if(answer != 0)
                           {
                               gameover = true;
                               switch (answer) {
                                    case 1:
                                       buttons.get(0).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(1).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(2).setStyle("-fx-background-color: #ff6666; ");
                                        
                                    break;
                                    case 2:
                                       buttons.get(3).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(4).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(5).setStyle("-fx-background-color: #ff6666; ");
                                       
                                    break;
                                    case 3:
                                       buttons.get(6).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(7).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(8).setStyle("-fx-background-color: #ff6666; ");
                                       
                                    break;
                                    case 4:
                                       buttons.get(0).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(3).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(6).setStyle("-fx-background-color: #ff6666; ");
                                       
                                    break;
                                    case 5:
                                        buttons.get(1).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(4).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(7).setStyle("-fx-background-color: #ff6666; ");
                                       
                                    break;
                                    case 6:
                                       buttons.get(2).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(5).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(8).setStyle("-fx-background-color: #ff6666; ");
                                    break;
                                    case 7:
                                       buttons.get(0).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(4).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(8).setStyle("-fx-background-color: #ff6666; ");
                                    break;
                                    case 8:
                                       buttons.get(2).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(4).setStyle("-fx-background-color: #ff6666; ");
                                       buttons.get(6).setStyle("-fx-background-color: #ff6666; ");
                                    break;                                    
                               }/// End of switch answer.

                           }
                        }
                    }                  
                }            
            });                        
        }                                         
    }///End of method setupbuttons
    
    
}// End of class FXMLDocumentController
