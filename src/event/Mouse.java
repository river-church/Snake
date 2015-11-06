package event;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener{
    private boolean[] buttons = new boolean[120];
    public boolean leftButton, rightButton;
    public int x, y;

    public void update(){
        leftButton = buttons[MouseEvent.BUTTON1];
        rightButton = buttons[MouseEvent.BUTTON2];

    }

    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }


    public void mouseClicked(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }


    public void mousePressed(MouseEvent e) {

        buttons[e.getButton()] = true;
        this.x = e.getX();
        this.y = e.getY();
    }


    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;

    }
}
