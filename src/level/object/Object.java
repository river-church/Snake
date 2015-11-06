package level.object;

import graphics.Screen;
import graphics.Sprite;

public abstract class Object {
    public int x, y, size;
    public boolean active = true;
    protected Sprite sprite;

    public void render(Screen screen){

    }

    public void tick(){

    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
}
