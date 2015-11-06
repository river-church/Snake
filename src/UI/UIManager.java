package UI;

import UI.menus.StartMenu;
import UI.menus.UIState;
import event.Keyboard;
import event.Mouse;

import java.awt.*;

/**
 * Created by BC013806 on 10/22/2015.
 */
public class UIManager {
    private Keyboard key;
    private Mouse mouse;
    private UICursor cursor;

    public UIState state;

    //CONSTANTS
    public static final Color[] COLOR_SCHEME = {
            new Color(0x0274f4), //blue
            new Color(0x79b8ff), //light blue
            new Color(0xbbbbbb), //gray
            new Color(0xffffff)  //white
    };

    public static final Font[] THEME_FONTS = {
            new Font("Verdana", 0, 18)
    };

    public UIManager(Keyboard key){
        this.key = key;
        cursor = new UICursor(key);
        state = new StartMenu();
    }

    public void tick(){
        cursor.tick();
        state.tick(cursor);
    }

    public void render(Graphics g){
        state.render(g);
        cursor.render(g);
    }
}
