package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;
    private boolean quit = false;

    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }

    public boolean endGame(){
        return this.quit;
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     * Player code guess
     * Player code check/validation
     * @return the value entered by the user
     */
    public String getGuess(){

        /**
         * player code guess
         * player code check/validation
         */

        System.out.print("Input 4 digit code:\n");
        String userGuess = inputScanner.nextLine().trim();
        boolean foreignValueBool = false;


        while(foreignValueBool == false){

            foreignValueBool = true;

            if(userGuess.equalsIgnoreCase("exit") 
            || userGuess.equalsIgnoreCase("quit")){
                quit = true;
                
            } else if(userGuess.length() == 4){
                for (int i = 0; i < userGuess.length(); i++) {
                    if(!Character.isDigit(userGuess.charAt(i)) 
                    || userGuess.charAt(i) == '0' 
                    || userGuess.charAt(i) == '9'){
                        foreignValueBool = false;
                        break;
                    }
                }
            } else
                foreignValueBool = false;
                
            
            if(foreignValueBool == true){
                break;
            }
            
            System.out.print("Please enter exactly 4 digits (each from 1 to 8).\n");
            System.out.print("Input 4 digit code:\n");
            userGuess = this.inputScanner.nextLine().trim();
        }

        return userGuess;
    }

    // private void next() {
    //     // TODO
    // }
}
