package level.object.animations.particle;

import graphics.Screen;
import graphics.Sprite;

import java.util.Random;

public class ExplodeyParticle extends Particle{
    public Random random = new Random();

    public int color;

    public ExplodeyParticle(int x, int y, int size, int duration, int color, int xSpeed, int ySpeed){
        super(x,y,duration);
        this.size = size;
        this.color = color;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        setSprite(new Sprite(size, color));
    }

    public void tick(){
        if(duration > 0){
            //xSpeed *= 0.99;
            //ySpeed *= 0.99;
            x+=xSpeed;
            y+=ySpeed;
            duration--;
        }else{
            active = false;
        }
    }

    public void render(Screen screen){
        screen.renderSprite(x,y,sprite);
    }
}
