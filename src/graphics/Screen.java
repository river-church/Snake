package graphics;

import UI.uicomponent.UIComponent;
import level.Tile.Tile;
import level.object.Snake;

import java.util.Random;

public class Screen {

    public int width;
    public int height;
    //public int xCenter = (int)width/2, yCenter = (int)height/2; JUST IN CASE OF ROTATING THE SCREEN
    public int[] pixels;

    int xOffset = 0, yOffset = 0, dir = 0;

    private Random  random = new Random();

    public Screen(int width, int height){ //sets dimensions of Screen to the dimensions of Game
        this.width = width;
        this.height = height;
        pixels = new int[width * height]; //lots of px in this array
    }

    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0xffffff;
        }
    }


    public void renderTile(int xp, int yp, Tile tile){
        yp -= yOffset;
        xp -= xOffset;
        for(int y = 0; y < tile.sprite.SIZE; y++){
            int ya = y + yp;
            for(int x = 0; x < tile.sprite.SIZE; x++){
                int xa = x + xp;
                if(xa < -tile.sprite.SIZE || xa >= width || ya < -tile.sprite.SIZE || ya >= height) break;
                if(xa < 0) xa = 0;
                if(ya < 0) ya = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }

        }
    }

    public void renderSprite(int xp, int yp, Sprite sprite){
        yp -= yOffset;
        xp -= xOffset;
        for(int y = 0; y < sprite.SIZE; y++){
            int ya = y + yp;
            for(int x = 0; x < sprite.SIZE; x++){
                int xa = x + xp;
                if(xa < -sprite.SIZE || xa >= width || ya < -sprite.SIZE || ya >= height) break;
                if(xa < 0) xa = 0;
                if(ya < 0) ya = 0;
                pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
            }

        }
    }

    public void setView(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }




}
