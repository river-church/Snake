package UI;

import UI.uicomponent.UIComponent;
import graphics.Screen;

import java.awt.*;
import java.util.ArrayList;

public class UIPanel {
    int x, y, width, height;
    private ArrayList<UIComponent> components = new ArrayList<>();

    public UIPanel(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void addComponent(UIComponent c){
        components.add(c);
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(UIManager.COLOR_SCHEME[2]);
        g.fillRect(x,y,width,height);
        for(UIComponent component : components){
            //component.render();
        }
    }


}
