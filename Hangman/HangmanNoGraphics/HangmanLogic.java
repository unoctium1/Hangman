package HangmanNoGraphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.*;


public class HangmanLogic {

    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> guessedLetters = new ArrayList<String>();
    boolean gameOver = false;

    public HangmanLogic(){
        Scanner fileLoc = new Scanner(System.in);
        System.out.println("Please enter a file location for the text file containing the wordlist. Or, push 1 to use the default wordlist");
        lineBreak();
        String filePath = fileLoc.next();
        if(filePath.contentEquals("1")){
            filePath =  this.getClass().getResource("hangman.txt").getPath();
            System.out.println(filePath);
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String text = null;
                while((text = reader.readLine()) != null){
                    wordList.add(text);
                }
            } catch(FileNotFoundException e) {
                System.out.println("File not found");

            } catch(IOException ioe) {
                System.out.println("General Error");
            }
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String text = null;
                while((text = reader.readLine()) != null){
                    wordList.add(text);
                }
            } catch(FileNotFoundException e) {
                System.out.println("File not found");

            } catch(IOException ioe) {
                System.out.println("General Error");
            }
        }

    }

    public String getRandWord(){
        Random generator = new Random();
        return wordList.get(generator.nextInt(wordList.size()));
    }

    private int countMatches(String s, char searchChar) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == searchChar) {
                count++;
            }
        }
        return count;
    }

    public void startGame(){
        try{
            int tries = 10;
            String originalWord = getRandWord();
            String word = originalWord.toLowerCase();
            char[] lettersInWord = word.toCharArray();
            lineBreak();
            System.out.println("The word has " + word.length() + " letters.");
            Scanner input = new Scanner(System.in);
            while(!gameOver){
                lineBreak();
                System.out.print("Type a letter: ");
                String letter = input.next();
                if(guessedLetters.contains(letter)) { //Checks if letter is already on list.
                    System.out.println("You've already tried this!");
                } else {
                    guessedLetters.add(letter);
                    System.out.println("Letters already used: " + guessedLetters);
                    if(!word.contains(letter)){
                        //wrong answer
                        tries--;
                        System.out.println("Incorrect! You have " + tries + " tries left.");
                    }
                    if(word.contains(letter)){
                        int letterCount = countMatches(word, letter.charAt(0));
                        System.out.println("Correct! The word contains this letter " + letterCount + " times");
                        lineBreak();
                        String revealedWord = " ";
                        for(int e = 0; e < word.length(); e++){
                            revealedWord = revealedWord.concat("_");
                        }
                        StringBuilder revWord = new StringBuilder(revealedWord);
                        for(int e = 0; e < word.length(); e++){
                            String letterPlacement = String.valueOf(word.charAt(e));
                            if(guessedLetters.contains(letterPlacement)){
                                System.out.print(word.charAt(e) + " ");
                                revWord.setCharAt(e+1, word.charAt(e));
                            } else {
                                System.out.print("_ ");
                            }
                        }
                        revealedWord = revWord.toString();
                        lineBreak();
                        if(revealedWord.contains("_")){
                        } else {
                            lineBreak();
                            System.out.println("Congratulations, You Win! Would you like to try Again?");
                            playAgain();
                        }
                    }
                    if(tries == 0){
                        //game over
                        gameOver = true;
                    }
                }
            }
            while(gameOver){
                lineBreak();
                System.out.println("You lose! The word was " + word + ". Try Again?");
                playAgain();

            }
        } catch (IllegalArgumentException iae){
            System.out.println("General Error");
        }
    }

    public void lineBreak(){
        System.out.println("");
    }

    public void playAgain(){
        lineBreak();
        Scanner startOver = new Scanner(System.in);
        int i = 1;
        System.out.println("Type 1 to play again or 2 to quit");
        while(i == 1){
            int playAgain = startOver.nextInt();
            if(playAgain == 1){
                //play again
                guessedLetters.clear();
                startGame();
                i = 2;
            } if(playAgain == 2){
                //quit
                System.exit(0);
            } else {
                System.out.println("Please choose either 1 or 2");

                i = 1;
            }
        }
    }
    public static void main(String[] args){
        HangmanLogic game = new HangmanLogic();
        game.startGame();
    }
}


