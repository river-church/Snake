package level.object;

import event.Keyboard;
import graphics.Screen;
import graphics.Sprite;

import java.util.ArrayList;

public class Snake extends Object {
    private Keyboard key;
    public int length, dir = 0, speed, cooltime;
    public boolean alive;
    private int lastx, lasty;

    public ArrayList<SnakeTrail> trail = new ArrayList<SnakeTrail>();

    public Snake(int x, int y, int startSpeed, Keyboard key) {
        this.x = x;
        this.y = y;
        this.key = key;
        this.speed = startSpeed;
        this.dir = 1;
        this.cooltime = 0;
        this.alive = true;
        this.trail.add(new SnakeTrail(x,y));
        this.length = trail.size();
        setSprite(Sprite.spr_snake);
    }

    public void tick() {
            key.update();
            if (key.up) dir = 0;
            if (key.right) dir = 1;
            if (key.down) dir = 2;
            if (key.left) dir = 3;


            //moves the snake every set interval "speed"
            if (cooltime % speed == 0) {
                move();
                cooltime = 1;
            } else {
                cooltime++;
            }
    }

    private void move() {

        lastx = x;
        lasty = y;

        if (dir == 0) y--;
        if (dir == 1) x++;
        if (dir == 2) y++;
        if (dir == 3) x--;



        trail.get(0).lastx = trail.get(0).x;
        trail.get(0).lasty = trail.get(0).y;
        trail.get(0).x = lastx;
        trail.get(0).y = lasty;

        for(int i = 1; i < trail.size(); i++){
            trail.get(i).lastx = trail.get(i).x;
            trail.get(i).lasty = trail.get(i).y;
            trail.get(i).x = trail.get(i-1).lastx;
            trail.get(i).y = trail.get(i-1).lasty;
        }
    }

    public void render(Screen screen){
        screen.renderSprite(x << 3, y << 3, sprite);
        //screen.renderSprite(x, y, sprite);
        for(int i = 0; i < trail.size(); i++){
            trail.get(i).render(screen);
        }
    }
}