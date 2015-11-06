package level.object;

import graphics.Screen;
import graphics.Sprite;

public class SnakeTrail extends Object{
    int lastx, lasty;
    public SnakeTrail(int x, int y){
        this.x = x;
        this.y = y;
        setSprite(Sprite.spr_snake);
    }

    public void render(Screen screen) {
        screen.renderSprite(x << 3, y << 3, sprite);
        //screen.renderSprite(x, y, sprite);
    }
}
