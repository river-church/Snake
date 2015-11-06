package level.Tile;

import graphics.Screen;
import graphics.Sprite;

public class CollectedTile extends Tile{
    public CollectedTile(Sprite sprite){
        super(sprite);
    }

    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 3, y << 3, this);
    }
}
