package UI.uicomponent;

import UI.UICursor;
import UI.UIManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by area5 on 10/29/2015.
 */
public class UIButton extends UIComponent {
    public boolean pressed;
    private int alpha = 50;
    private String text;
    private BufferedImage icon = null;

    public UIButton(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = "";

    }

    public UIButton(int x, int y, int width, int height, String text){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;

    }

    public UIButton(int x, int y, int width, int height, String text, String iconPath){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(iconPath));
        } catch (IOException e) {
            System.out.println("screwed up the button icon load!");
            e.printStackTrace();
        }

    }

    public UIButton(String iconPath, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(iconPath));
        } catch (IOException e) {
            System.out.println("screwed up the button icon load!");
            e.printStackTrace();
        }

    }

    public void tick(UICursor cursor){
        if(cursor.x >= this.x && cursor.x <= this.x + this.width && cursor.y >= this.y && cursor.y <= this.y + this.height){
            if(this.pressed = cursor.click){
                if(alpha < 100)alpha+=5;
            }else{
                if(alpha > 75)alpha-=5;
            }


            if(alpha < 75)alpha+=5;
        }else{
            if(alpha > 50)alpha-=5;
        }
    }

    public void render(Graphics g){

        g.setColor(new Color(2, 116, 244, alpha));
        g.fillRect(x,y,width,height);
        g.setColor(new Color(2, 116, 244, alpha));
        g.fillRect(x + 10, y + 10, width - 20, height - 20);
        g.setColor(new Color(0xFFFFFF));
        g.setFont(UIManager.THEME_FONTS[0]);
        g.drawString(text, x+width /2, y+height / 2);
        if(icon != null) g.drawImage(icon, x + width/2 - icon.getWidth(), y + height/2 - icon.getHeight(), icon.getWidth(), icon.getHeight(), null);




    }
}
