// Theodore Ingberman
// 1/5/2023
// CS 145
// Lab #1
// This program will do the following: play a guessing game.
import java.util.*;

public class TIguessingGame { //start of TIguessingGame class
   
    public static void main(String[] args) { //start of main method 
    Scanner input = new Scanner(System.in);
        int gameCount = 1;
        int bestGame = 100;
        instructions();
             
        int numTries = playGame();
        int sum = numTries;
        System.out.println("Do you want to play again?");
        String playAgain = input.next();
            bestGame = Math.min(bestGame, numTries);
                while(playAgain.startsWith("y") || 
                playAgain.startsWith("Y")){ // start of while loop
                    numTries = playGame();
                    System.out.println("Do you want to play again?");
                    sum += numTries;
                    gameCount++;
                    playAgain = input.next();
                    bestGame = Math.min(bestGame, numTries);
                } // end of while loop
            report(gameCount, sum, bestGame);
    
    }//end of main method
   
    public static void instructions() {  // start of instructions method 
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and\n100");
        System.out.println("and will allow you to guess until\nyou get it.");
        System.out.println("For each guess, I will tell you whether the");
        System.out.println("right answer is higher or lowerthan your guess.");
        
    } // end of instructions method 
   
    public static int playGame() { // start of playGame method 
        Scanner input = new Scanner(System.in);
        //define variabvles
        int range = 100;  
        int numTries = 0;
        Random rand = new Random();
        int randomNumber = rand.nextInt(range) + 1;
        /*int randomNumber uses the rand object to get a random int between 0 and 100*/
        System.out.println("I'm thinking of a number between 1 and 100");
        int guess = input.nextInt();

            while(guess != randomNumber) { //start of while loop
                System.out.println("your guess is " + guess);
                    if(guess > randomNumber) {
                    System.out.println("It's lower.");
                    numTries++;
                    guess = input.nextInt();
                    } else { //its less than
                    System.out.println("It's higher.");
                    numTries++;
                    guess = input.nextInt();
                    }     
            } // end of while loop         

            if(numTries == 0) { //start of if else
                    numTries++;
                    System.out.println(
                    "congratulateions you got it in " + numTries + " try!"); 
            } else {
                    numTries++;
                    System.out.println(
                    "congratulations you got it in " + numTries + " tries! "); 
            } // end of if else            
            
    return numTries;
    } // end of playAgain method 
   
    public static void report(int gameCount, int sum, int bestGame) { /* start of report method */
   
        double avgGuesses = Math.round(sum/gameCount);
      
        System.out.printf("%nOverall results:%n");
        System.out.println("total games: " + gameCount);
        System.out.println("total guesses: " + sum);
        System.out.printf("Average guesses per game: %.1f%n" , avgGuesses);
        System.out.println("best game: " + bestGame);
    } // end of report method 
   
} //end of TIguessingGame class