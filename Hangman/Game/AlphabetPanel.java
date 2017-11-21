package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AlphabetPanel extends JPanel {
    private static final long serialVersionUID = 9058050245506552038L;
    private JButton[] alphabetButtons;
    private int[][] index = new int[][]{{0, 1, 2, 3, 4, 5}, {6, 7, 8, 9, 10, 11}, {12, 13, 14, 15, 16, 17}, {18, 19, 20, 21, 22, 23}, {24, 25, 26, 27, 28, 29}};
    private String[] letter = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String outputLetter;
    private boolean isPressed = false;
    private Dimension panel = new Dimension(400, 500);
    private JButton resetButton;
    private boolean resetIsPressed = false;

    AlphabetPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.alphabetButtons = new JButton[26];
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.fill = 2;

        for(int i = 0; i < 5; ++i) {
            c.gridy = i;

            for(int j = 0; j < 6; ++j) {
                if (this.index[i][j] < 26) {
                    this.alphabetButtons[this.index[i][j]] = new JButton(this.letter[this.index[i][j]]);
                    c.gridx = j;
                    this.add(this.alphabetButtons[this.index[i][j]], c);
                    this.alphabetButtons[this.index[i][j]].addActionListener(new letterListener(this.letter[this.index[i][j]]));
                }
            }
        }

        c.gridy = 4;
        c.gridx = 2;
        c.gridwidth = 4;
        this.resetButton = new JButton("Reset");
        this.resetButton.addActionListener(new resetListener());
        this.add(this.resetButton, c);
        this.setPreferredSize(this.panel);
        this.setBackground(Color.white);
        this.setVisible(true);
    }

    public void grayOut(String character) {
        this.alphabetButtons[this.getIndex(character)].setEnabled(false);
    }

    public void grayOut(int index) {
        this.alphabetButtons[index].setEnabled(false);
    }

    public void unGrayOut(String character) {
        this.alphabetButtons[this.getIndex(character)].setEnabled(true);
    }

    public void unGrayOut(int index) {
        this.alphabetButtons[index].setEnabled(true);
    }

    public void unGrayOutAll() {
        for(int i = 0; i < 26; ++i) {
            if (!this.getEnabled(i)) {
                this.unGrayOut(i);
            }
        }

    }

    public boolean getEnabled(int index) {
        return this.alphabetButtons[index].isEnabled();
    }

    public boolean getEnabled(String character) {
        return this.alphabetButtons[this.getIndex(character)].isEnabled();
    }

    private int getIndex(String inputLetter) {
        int index = 26;

        for(int i = 0; i < 26; ++i) {
            if (this.letter[i].equalsIgnoreCase(inputLetter)) {
                index = i;
            }
        }

        return index;
    }

    public String getOutputLetter() {
        this.isPressed = false;
        return this.outputLetter;
    }

    public boolean isPressed() {
        return this.isPressed;
    }

    public boolean isResetPressed() {
        return this.resetIsPressed;
    }

    public void resetReset() {
        this.resetIsPressed = false;
    }

    private class letterListener implements ActionListener {
        String letter;

        public letterListener(String value) {
            this.letter = value;
        }

        public void actionPerformed(ActionEvent event) {
            AlphabetPanel.this.outputLetter = this.letter.substring(0, 1);
            AlphabetPanel.this.isPressed = true;
        }
    }

    private class resetListener implements ActionListener {
        private resetListener() {
        }

        public void actionPerformed(ActionEvent event) {
            AlphabetPanel.this.resetIsPressed = true;
        }
    }
}

