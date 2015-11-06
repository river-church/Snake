package UI.menus;

import UI.UICursor;
import UI.UIPanel;
import UI.uicomponent.UIButton;
import base.Game;

import java.awt.*;

public class StartMenu extends UIState{
    UIPanel main;
    UIButton button_left, button_middle, button_right;

    public StartMenu(){
        main = new UIPanel(Game.width * 2/ 8, Game.height / 8, Game.width / 4, Game.height / 4);
        button_left = new UIButton(Game.width    * 2  / 12, Game.height * 2 / 12, Game.width * 2 / 6, Game.height * 2 * 10/12, "single player");
        button_middle = new UIButton(Game.width  * 2  / 3, Game.height * 2 / 12, Game.width * 2 / 6, Game.height * 2 * 10/12, "multiplayer");
        button_right = new UIButton(Game.width   * 2 * 7 / 12, Game.height * 2 / 12, Game.width  * 2 / 6, Game.height * 2 * 10/12, "stats");
    }

    public void tick(UICursor cursor){
        button_left.tick(cursor);
        button_middle.tick(cursor);
        button_right.tick(cursor);
    }

    public void render(Graphics g){
        button_left.render(g);
        button_middle.render(g);
        button_right.render(g);
    }
}
