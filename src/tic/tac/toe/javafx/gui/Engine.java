package tic.tac.toe.javafx.gui;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.Random;

/** Class Engine
 *  This class will handle as much game logic as possible.
 *
 * @author mew
 */
public class Engine 
{    
    private static int[] squares = {0,0,0,0,0,0,0,0,0};        
    /** Method reset
     *  Changes all the elements to zero in the global variable squares array.
     */
    public void reset()
    {
        int s=0;
        do
        {
            squares[s] = 0;
            s++;
        }while(s <= 8);
       
    }/// End of method reset.

    
    
    
    /** Method PlayerSelected
     *  Gets called when a player has clicked on a button. Handles decision 
     *  about what should happen next. Returns the computer's choice. 
     *  Variable computersChoice is initialized to -1 because if it doesn't get
     *  set than program will know that there are no more buttons available.
     *  Variable computersChoice will equal the element value of the chosen 
     *  button to be changed to "O".
     * 
     * @param playersChoice
     * @return 
     */
    public int PlayerSelected(String playersChoice) 
    {                            
        // First, set players choice in square array.
        int x = Integer.parseInt(playersChoice);   
        squares[x] = 1;                                
        /// Build arraylist of untouched squares.
        ArrayList<Integer> untouched = new ArrayList<Integer>();
        int s=0;
        do
        {
            int square = squares[s];
            if(square == 0)
            { untouched.add(s); }            
            s++;
        }while(s <= 8); /// untouched squares arraylist has been built.                       
        
        // Initialize computersChoice
        int computersChoice = -1;
        /// If there are more than zero untouched buttons 
        // Than make a random selection.
        if(untouched.size() > 0 )
        {
            Random random = new Random();
            int v = random.nextInt(untouched.size()-1);
            computersChoice = untouched.get(v);    
            squares[computersChoice] = 2; 
        }                                                          
        return computersChoice;
    }// End of method PlayerSelected 
    

    
    
    
    /** Method hasGameBeenWon
     *  Determines if the game has been won.
     *  returns answer, which is an integer. It represents the possible outcomes
     *  of this method. When it returns as zero the game has not been won. 
     *  When answer is 1 to 8 it is one of the possible wins. When the method gets
     *  returned the program knows which type of win it is based off the number 
     *  returned.
     *  
     * @return answer
     */
    public int hasGameBeenWon() 
    {
        int answer = 0; 
        //Ways the game can be won...        
        // 1       top row                0 1 2
        // 2       middle row             3 4 5
        // 3       bottom row             6 7 8            
        // 4       left column            0 3 6
        // 5       center column          1 4 7
        // 6       right column           2 5 8     
        // 7       Cross one              0 4 8
        // 8       Cross two              2 4 6                         
        //Answer,  Type of win,          Elements that have to be the samed.      
        int zero, one, two, three, four, five, six, seven, eight;
        zero = squares[0];
        one = squares[1];
        two = squares[2];
        three = squares[3];
        four = squares[4];
        five = squares[5];
        six = squares[6];
        seven = squares[7];
        eight = squares[8];        
        if(zero == one && zero == two && zero != 0)
        {
            //top row
            answer= 1;
        }       
        if(three == four && three == five && three != 0)
        {
            //middle row
            answer = 2;
        }        
        if(six == seven && six == eight && six != 0)
        {
            //bottom row
            answer=3;
        }
        if(zero == three && zero == six && zero != 0)
        {
            //left column
            answer=4;
        }       
        if(one == four && one == seven && one != 0)
        {
            //center column 
            answer=5;
        }        
        if(two == five && five == eight && two != 0)
        {
            //right column
            answer=6;
        }
        if(zero == four && zero == eight && zero != 0)
        {
            //Cross one 
            answer=7;
        }        
        if(two == four && four == six && two != 0)
        {
           //Cross two
            answer=8;
        }       
        return answer;
    }/// End of method hasGameBeenWon
     
        
}// End of class Engine
