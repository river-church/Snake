package level;

import event.Keyboard;
import graphics.Screen;
import level.Tile.Tile;
import level.object.*;
import level.object.Object;
import level.object.animations.Explosion;
import level.object.animations.Twinkle;
import level.object.collectable.AddItem;

import java.util.ArrayList;
import java.util.Random;


public class Level{
    public final int WIDTH, HEIGHT;
    public int[] tiles;
    private Random random = new Random();
    public boolean playing = true;

    public Snake player;
    public AddItem addItem;


    public ArrayList<Object> explosions = new ArrayList<Object>();

    public Level(int width, int height, Keyboard key) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.tiles = new int[WIDTH * HEIGHT];
        this.player = new Snake(1, HEIGHT/2, 4, key);
        this.addItem = new AddItem(10,10);
    }

    public void render(int xScroll, int yScroll, Screen screen){
        screen.setView(xScroll, yScroll);
        int x0 = xScroll >> 3;
        int x1 = (xScroll + screen.width + 16) >> 3;
        int y0 = yScroll >> 3;
        int y1 = (yScroll + screen.height + 16) >> 3;

        for (int y = y0; y < y1; y++){
            for (int x = x0; x < x1; x++){
                if(x > 0 && x < WIDTH && y > 0 && y < HEIGHT)getTile(x, y).render(x, y, screen);
            }
        }

        if (player.alive) player.render(screen);
        addItem.render(screen);

        for (Object explosion : explosions) {
            explosion.render(screen);
        }

        
        
    }

    public void tick() {
            //update player data
            player.tick();

            //makes sure the objective position is random
            if (player.x == addItem.x && player.y == addItem.y) {
                addItem.collectTo(player);
                explosions.add(new Explosion(addItem.x << 3, addItem.y << 3, 100, 0xffb900));
                addItem.x = random.nextInt(WIDTH - 3) + 2;
                addItem.y = random.nextInt(HEIGHT - 3) + 2;
            }


            //checks if snake is outta bounds
            if (player.x <= 1 || player.x >= WIDTH - 1 || player.y <= 1 || player.y >= HEIGHT - 1) {

                if (player.alive == true) explosions.add(new Explosion(player.x << 3, player.y << 3, 250, 0x0081b8));
                player.alive = false;
            }

            //checks if the snake runs into self
            for (int i = 0; i < player.trail.size(); i++) {
                if (player.x == player.trail.get(i).x && player.y == player.trail.get(i).y) {
                    if (player.alive == true)
                        explosions.add(new Explosion(player.x << 3, player.y << 3, 100, 0x0081b8));
                    player.alive = false;
                }
            }

            for (int i = 0; i < explosions.size(); i++) {
                explosions.get(i).tick();
            }


        updateBoard();
    }

    public Tile getTile(int x, int y){
        if(tiles[x + y * WIDTH] == 1)
            return Tile.tile_wall;
        if(tiles[x + y * WIDTH] == 2)
            return Tile.tile_collected;
        //if(tiles[x + y * WIDTH] == 5)
          //  return Tile.tile_snake_tail;
        //if(tiles[x + y * WIDTH] == 6)
          //  return Tile.tile_snake_head;



        return Tile.tile_void;
    }

    public void updateBoard(){
        for(int y = 0; y < HEIGHT; y ++){
            for(int x = 0; x < WIDTH; x++){

                //determines border tiles
                if(x == 1 || x == WIDTH-1 || y == 1 || y == HEIGHT - 1){
                    tiles[x + y * WIDTH] = 1;
                }else{
                    tiles[x + y * WIDTH] = 0;
                }



                //determines
            }
        }
    }
}