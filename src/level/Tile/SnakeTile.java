package level.Tile;

import graphics.Screen;
import graphics.Sprite;

public class SnakeTile extends Tile{
    public SnakeTile(Sprite sprite){
        super(sprite);
    }

    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 3, y << 3,this);
    }

}
