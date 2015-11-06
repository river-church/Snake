package UI;

import base.Game;
import event.Keyboard;
import event.Mouse;

import java.awt.*;

/**
 * Created by bc013806 on 10/28/2015.
 */
public class UICursor {
    private Keyboard key;
    public int x, y, size, alpha = 20, timerhold = 0;
    public boolean click = false;

    public static final int CURSOR_SPEED = 7;

    public UICursor(Keyboard key){
        this.key = key;
        this.x = Game.width * Game.scale / 2;
        this.y = Game.height * Game.scale / 2;
        this.size = 100;

    }

    public void tick(){
        key.update();

        if(key.left)  x-= CURSOR_SPEED;
        if(key.right) x+= CURSOR_SPEED;
        if(key.up)    y-= CURSOR_SPEED;
        if(key.down)  y+= CURSOR_SPEED;

        if(key.space){
            if(size > 75) size-=5;
            if(alpha < 50)alpha+=5;

            if(timerhold % 120 == 0)timerhold = 0;
            timerhold++;
        }else{
            if(size < 100)size+=5;
            if(alpha > 20)alpha-=5;
            timerhold = 0;
        }

        click = key.space;

    }

    public void render(Graphics g){
        g.setColor(new Color(155,155,155, alpha));
        g.fillOval(x - size/2, y - size/2, size, size);//outer circle
        g.setColor(new Color(2,116,244,50));
        g.fillOval(x - size * 3/8, y - size * 3/8, size * 3/4 , size * 3/4);//inner circle
        g.setColor(new Color(121,184,255, 50));


    }
}
