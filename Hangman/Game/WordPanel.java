package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordPanel extends JPanel {
    private static final long serialVersionUID = 3649450931961258937L;
    private String word;
    private int knownLetters;
    private ArrayList<String> guessedLetters;
    private JLabel displayLabel;
    private String display;
    private Dimension panel = new Dimension(300, 100);

    public WordPanel(String inputWord) {
        this.word = inputWord.toLowerCase();
        this.knownLetters = 0;
        this.guessedLetters = new ArrayList();
        this.display = this.generateDisplayWord();
        this.displayLabel = new JLabel(this.display);
        this.displayLabel.setFont(new Font(this.displayLabel.getFont().getName(), 1, 30));
        this.add(this.displayLabel);
        this.setPreferredSize(this.panel);
        this.setBackground(Color.white);
        this.setVisible(true);
    }

    public void resetWord() {
        this.knownLetters = 0;
        this.resetGuessedLetters();
        this.display = this.generateDisplayWord();
        this.updateLabel();
    }

    public void updateLabel() {
        this.displayLabel.setText(this.display);
    }

    public void resetGuessedLetters() {
        this.guessedLetters.clear();
    }

    public String generateDisplayWord() {
        String revealedWord = "";
        int e;
        if (this.knownLetters == 0) {
            for(e = 0; e < this.word.length(); ++e) {
                revealedWord = revealedWord.concat("_ ");
            }
        } else {
            for(e = 0; e < this.word.length(); ++e) {
                if (this.guessedLetters.contains(String.valueOf(this.word.charAt(e)))) {
                    revealedWord = revealedWord.concat(String.valueOf(this.word.charAt(e)) + " ");
                } else {
                    revealedWord = revealedWord.concat("_ ");
                }
            }
        }

        return revealedWord;
    }

    public void setWord(String inputWord) {
        this.word = inputWord.toLowerCase();
        this.knownLetters = 0;
        this.resetWord();
    }

    public String getWord() {
        return this.word;
    }

    public int getWordLength() {
        return this.word.length();
    }

    public int getKnownLetters() {
        return this.knownLetters;
    }

    public String getDisplay() {
        return this.display;
    }

    public boolean isWordCompleted() {
        return this.knownLetters == this.getWordLength();
    }

    public int testLetter(String test) {
        this.guessedLetters.add(test);
        if (this.word.contains(test)) {
            int matches = this.countMatches(this.word, test.charAt(0));
            this.knownLetters += matches;
            this.display = this.generateDisplayWord();
            this.updateLabel();
            return matches;
        } else {
            return 0;
        }
    }

    private int countMatches(String s, char searchChar) {
        int count = 0;

        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == searchChar) {
                ++count;
            }
        }

        return count;
    }
}
