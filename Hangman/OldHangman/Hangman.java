package OldHangman;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Hangman {

    public Hangman() {

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);

        final GallowsPanel GallowsPanel = new GallowsPanel();
        frame.add(GallowsPanel, BorderLayout.CENTER);

        JButton closeProg = new JButton("Exit");
        closeProg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(closeProg, BorderLayout.NORTH);

        //frame.add(HangmanLogic., BorderLayout.SOUTH);
        //String word = HangmanLogic.startGame(revealedWord);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Hangman();
    }
}