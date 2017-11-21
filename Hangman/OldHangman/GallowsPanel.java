package OldHangman;

import javax.swing.*;
import java.awt.*;


public class GallowsPanel extends JPanel {
    final int CENTER = 250;
    Color brown = new Color(156, 82, 92);
    Color tan = new Color(228, 223, 181);
    final int TOP_OF_HEAD = 70;
    private boolean paintLeftArm = false;

    public GallowsPanel() {

    }

    public void head (Graphics g){
        g.setColor(Color.black);
        g.drawOval(CENTER-25, TOP_OF_HEAD, 50, 50);
    }
    public void body (Graphics g){
        g.setColor(Color.black);
        g.drawLine(CENTER, TOP_OF_HEAD+50, CENTER, TOP_OF_HEAD+150);
    }
    public void arm1 (Graphics g){
        g.setColor(Color.black);
        g.drawLine(CENTER, TOP_OF_HEAD+55, CENTER+50, TOP_OF_HEAD+100);
    }
    public void arm2 (Graphics g){
        g.setColor(Color.black);
        g.drawLine(CENTER, TOP_OF_HEAD+55, CENTER-50, TOP_OF_HEAD+100);
    }
    public void leg1 (Graphics g){
        g.setColor(Color.black);
        g.drawLine(CENTER, TOP_OF_HEAD+150, CENTER+50, TOP_OF_HEAD+225);
    }
    public void leg2 (Graphics g){
        g.setColor(Color.black);
        g.drawLine(CENTER, TOP_OF_HEAD+150, CENTER-50, TOP_OF_HEAD+225);
    }
    public void eye1 (Graphics g){
        g.setColor(Color.black);
        g.drawLine(CENTER-15, TOP_OF_HEAD+17, CENTER-10, TOP_OF_HEAD+27);
        g.drawLine(CENTER-15, TOP_OF_HEAD+27, CENTER-10, TOP_OF_HEAD+17);
    }
    public void eye2 (Graphics g){
        g.setColor(Color.black);
        g.drawLine(CENTER+15, TOP_OF_HEAD+17, CENTER+10, TOP_OF_HEAD+27);
        g.drawLine(CENTER+15, TOP_OF_HEAD+27, CENTER+10, TOP_OF_HEAD+17);
    }
    public void frown(Graphics g){
        g.setColor(Color.black);
        g.drawArc(CENTER-25, TOP_OF_HEAD + 37, 50, 30, 65, 50);
    }
    public void testMan(Graphics g){
        head(g);
        frown(g);
        arm1(g);
        arm2(g);
        body(g);
        eye1(g);
        eye2(g);
        leg1(g);
        leg2(g);
    }
    public void paintComponent(Graphics g) {
        // ALWAYS have this line!
        super.paintComponent(g);
        setBackground(Color.white);

        g.setColor(brown);
        g.fillRect(CENTER-10, 20, 150, 20);
        g.fillRect(CENTER+120, 40, 20, 300);
        g.fillRect(0, 340, 500, 20);

        g.setColor(tan);
        g.fillRect(CENTER-2, 40, 5, 30);
        g.setColor(brown);
        for(int x = 0; x < 6; x++){
            g.drawLine(CENTER-2, 40+(5*x), CENTER+2, 45+(5*x));
        }

        //testing purposes only
        //testMan(g);
        if(paintLeftArm) {
            g.setColor(Color.black);
            g.drawLine(CENTER, TOP_OF_HEAD+55, CENTER+50, TOP_OF_HEAD+100);
        }

    }

    public void repaintGame(int tries) {
        if(tries >= 10) {
            paintLeftArm = true;
        }
        repaint();
    }
}