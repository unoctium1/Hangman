package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Hangman {
    static GallowsPanel gallows;
    static AlphabetPanel alphabet;
    static WordPanel word;
    static JFrame frame;
    static JLabel scores;
    static JPasswordField textField;
    static JPanel eastPanel;
    static int tries = 0;
    static String testWord;
    static boolean playAgain = true;
    static int gameCounter = 1;
    static int wins = 0;
    static int losses = 0;
    static ArrayList<String> wordList;
    static ArrayList<String> completedWords;

    public Hangman() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 500);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(3);
        wordList = new ArrayList();
        completedWords = new ArrayList();
        InputStream is = this.getClass().getResourceAsStream("WordLists/Hangman.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String text = null;

        try {
            while((text = br.readLine()) != null) {
                wordList.add(text);
            }

            br.close();
            isr.close();
            is.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        testWord = "";
        textField = new JPasswordField(1);
        textField.setOpaque(true);
        textField.setEchoChar('\u0000');
        gallows = new GallowsPanel();
        gallows.setSkinTone(generateSkinTone());
        alphabet = new AlphabetPanel();
        word = new WordPanel(testWord);
        scores = new JLabel("Game #" + gameCounter + ": Win Ratio: (" + wins + "/" + losses + ")");
        scores.setHorizontalAlignment(0);
        scores.setBackground(Color.WHITE);
        scores.setOpaque(true);
        eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(word, "South");
        eastPanel.add(alphabet, "Center");
        eastPanel.add(textField, "North");
        frame.add(gallows, "Center");
        frame.add(eastPanel, "East");
        frame.add(scores, "North");
        frame.setVisible(true);
    }

    public static void play() {
        int status;
        while((status = check()) == 0) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException var3) {
                ;
            }

            if (alphabet.isPressed() || textField.getPassword().length != 0) {
                String letter;
                if (alphabet.isPressed()) {
                    letter = alphabet.getOutputLetter().substring(0, 1);
                } else if (textField.getPassword().length != 0) {
                    letter = String.valueOf(textField.getPassword()[0]);
                    textField.setText("");
                } else {
                    letter = null;
                }

                if (alphabet.getEnabled(letter)) {
                    int letterCount = word.testLetter(letter);
                    alphabet.grayOut(letter);
                    if (letterCount == 0) {
                        incorrectGuess();
                    }
                }
            }

            if (alphabet.isResetPressed()) {
                ++gameCounter;
                resetGame();
            }
        }

        playAgain = endGame(status);
    }

    private static int check() {
        int var10000 = tries;
        gallows.getClass();
        if (var10000 == 16) {
            return 2;
        } else {
            return word.isWordCompleted() ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        new Hangman();

        while(playAgain) {
            resetGame();
            play();
        }

        frame.setVisible(false);
        frame.dispose();
    }

    private static void incorrectGuess() {
        ++tries;
        gallows.setTries(tries);
    }

    private static void resetGame() {
        testWord = generateWord();
        if (wordList.contains(completedWords.get(completedWords.size() - 1))) {
            System.out.println("Failed to remove");
        }

        word.setWord(testWord);
        alphabet.resetReset();
        alphabet.unGrayOutAll();
        tries = 0;
        gallows.setTries(tries);
        gallows.setSkinTone(generateSkinTone());
        scores.setText("Game #" + gameCounter + ": Win Ratio: (" + wins + "/" + losses + ")");
    }

    private static boolean endGame(int status) {
        int playAgain = 0;
        String result = "";
        if (status == 1) {
            result = "Congratulations, You Win!";
            ++wins;
        } else if (status == 2) {
            result = "You lose! The word was \"" + word.getWord() + ".\"";
            ++losses;
        }

        playAgain = JOptionPane.showConfirmDialog(frame, result + "\n" + "Play Again?", "Game #" + gameCounter + " Win Ratio: (" + wins + "/" + losses + ")", 0);
        if (playAgain == 0) {
            ++gameCounter;
            return true;
        } else {
            return playAgain != 1 && playAgain != -1 ? false : false;
        }
    }

    private static Color generateSkinTone() {
        Color skin1 = new Color(255, 223, 196);
        Color skin2 = new Color(240, 213, 190);
        Color skin3 = new Color(238, 206, 179);
        Color skin4 = new Color(225, 184, 153);
        Color skin5 = new Color(229, 194, 152);
        Color skin6 = new Color(255, 220, 178);
        Color skin7 = new Color(229, 184, 143);
        Color skin8 = new Color(229, 160, 115);
        Color skin9 = new Color(231, 158, 109);
        Color skin10 = new Color(219, 144, 101);
        Color skin11 = new Color(206, 150, 124);
        Color skin12 = new Color(198, 120, 86);
        Color skin13 = new Color(186, 108, 73);
        Color skin14 = new Color(165, 114, 87);
        Color skin15 = new Color(240, 200, 201);
        Color skin16 = new Color(221, 168, 160);
        Color skin17 = new Color(185, 124, 109);
        Color skin18 = new Color(168, 117, 108);
        Color skin19 = new Color(173, 100, 82);
        Color skin20 = new Color(92, 56, 54);
        Color skin21 = new Color(203, 132, 66);
        Color skin22 = new Color(189, 114, 60);
        Color skin23 = new Color(112, 65, 57);
        Color skin24 = new Color(163, 134, 106);
        int num = (int)(Math.random() * 23.0D);
        switch(num) {
            case 0:
                return skin1;
            case 1:
                return skin2;
            case 2:
                return skin3;
            case 3:
                return skin4;
            case 4:
                return skin5;
            case 5:
                return skin6;
            case 6:
                return skin7;
            case 7:
                return skin8;
            case 8:
                return skin9;
            case 9:
                return skin10;
            case 10:
                return skin11;
            case 11:
                return skin12;
            case 12:
                return skin13;
            case 13:
                return skin14;
            case 14:
                return skin15;
            case 15:
                return skin16;
            case 16:
                return skin17;
            case 17:
                return skin18;
            case 18:
                return skin19;
            case 19:
                return skin20;
            case 20:
                return skin21;
            case 21:
                return skin22;
            case 22:
                return skin23;
            case 23:
                return skin24;
            default:
                return null;
        }
    }

    private static String generateWord() {
        Random generator = new Random();
        String generatedWord;
        if (wordList.size() > 0) {
            int i = generator.nextInt(wordList.size());
            generatedWord = (String)wordList.get(i);
            wordList.remove(i);
            completedWords.add(generatedWord);
        } else {
            wordList = (ArrayList)completedWords.clone();
            completedWords.clear();
            generatedWord = generateWord();
        }

        return generatedWord;
    }
}
