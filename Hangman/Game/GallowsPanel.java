package Game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GallowsPanel extends JPanel {
    private static final long serialVersionUID = -762561582645093405L;
    final int CENTER = 250;
    Color brown = new Color(156, 82, 92);
    Color tan = new Color(228, 223, 181);
    final int TOP_OF_HEAD = 70;
    private int tries = 0;
    public final int TOTAL_TRIES = 16;
    private Color skinTone;

    public GallowsPanel() {
    }

    private void head(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(225, 70, 50, 50);
        g.setColor(this.skinTone);
        g.fillOval(225, 70, 50, 50);
    }

    private void body(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(250, 120, 250, 220);
    }

    private void arm1(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(250, 125, 300, 170);
    }

    private void arm2(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(250, 125, 200, 170);
    }

    private void leg1(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(250, 220, 300, 295);
    }

    private void leg2(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(250, 220, 200, 295);
    }

    private void foot1(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(310, 290, 300, 295);
    }

    private void foot2(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(190, 290, 200, 295);
    }

    private void hand1(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(300, 170, 5, 5);
        g.setColor(this.skinTone);
        g.fillOval(300, 170, 5, 5);
    }

    private void hand2(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(195, 170, 5, 5);
        g.setColor(this.skinTone);
        g.fillOval(195, 170, 5, 5);
    }

    private void eye1(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(235, 87, 240, 97);
        g.drawLine(235, 97, 240, 87);
    }

    private void eye2(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(265, 87, 260, 97);
        g.drawLine(265, 97, 260, 87);
    }

    private void frown(Graphics g) {
        g.setColor(Color.black);
        g.drawArc(225, 107, 50, 30, 65, 50);
    }

    private void mustache(Graphics g) {
        g.setColor(Color.red);
        g.drawArc(242, 102, 25, 30, 65, 50);
        g.drawArc(232, 102, 25, 30, 65, 50);
    }

    private void hat(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(215, 80, 285, 80);
        g.fillRect(228, 60, 44, 20);
    }

    private void monocle(Graphics g) {
        g.setColor(Color.yellow);
        g.drawOval(230, 85, 15, 15);
        g.drawArc(225, 95, 5, 10, 65, 50);
    }

    private void testMan(Graphics g) {
        this.head(g);
        this.frown(g);
        this.arm1(g);
        this.arm2(g);
        this.body(g);
        this.eye1(g);
        this.eye2(g);
        this.leg1(g);
        this.leg2(g);
        this.foot1(g);
        this.foot2(g);
        this.hand1(g);
        this.hand2(g);
        this.mustache(g);
        this.hat(g);
        this.monocle(g);
    }

    private void paintBackground(Graphics g) {
        g.setColor(this.brown);
        g.fillRect(240, 20, 150, 20);
        g.fillRect(370, 40, 20, 300);
        g.fillRect(0, 340, 500, 20);
        g.setColor(this.tan);
        g.fillRect(248, 40, 5, 30);
        g.setColor(this.brown);

        for(int x = 0; x < 6; ++x) {
            g.drawLine(248, 40 + 5 * x, 252, 45 + 5 * x);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        this.paintBackground(g);
        if (this.tries > 0) {
            this.head(g);
        }

        if (this.tries > 1) {
            this.body(g);
        }

        if (this.tries > 2) {
            this.arm1(g);
        }

        if (this.tries > 3) {
            this.arm2(g);
        }

        if (this.tries > 4) {
            this.leg1(g);
        }

        if (this.tries > 5) {
            this.leg2(g);
        }

        if (this.tries > 6) {
            this.foot1(g);
        }

        if (this.tries > 7) {
            this.foot2(g);
        }

        if (this.tries > 8) {
            this.hand1(g);
        }

        if (this.tries > 9) {
            this.hand2(g);
        }

        if (this.tries > 10) {
            this.eye1(g);
        }

        if (this.tries > 11) {
            this.eye2(g);
        }

        if (this.tries > 12) {
            this.frown(g);
        }

        if (this.tries > 13) {
            this.mustache(g);
        }

        if (this.tries > 14) {
            this.hat(g);
        }

        if (this.tries > 15) {
            this.monocle(g);
        }

    }

    public void setTries(int triesLeft) {
        this.tries = triesLeft;
        this.repaintGame();
    }

    public void setSkinTone(Color skin) {
        this.skinTone = skin;
    }

    public void repaintGame() {
        this.repaint();
    }
}

