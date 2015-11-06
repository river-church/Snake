package level.object.collectable;

import graphics.Screen;
import graphics.Sprite;
import level.object.Snake;
import level.object.SnakeTrail;

public class AddItem extends Collectable{
    public AddItem(int x, int y){
        this.x = x;
        this.y = y;
        setSprite(Sprite.spr_add_piece_icon);
    }

    public void collectTo(Snake snake){
        snake.trail.add(new SnakeTrail(snake.trail.get(snake.trail.size()-1).x,snake.trail.get(snake.trail.size()-1).y));
        snake.length++;
    }

    public void render(Screen screen){
        screen.renderSprite(x << 3, y << 3, sprite);
    }
}
