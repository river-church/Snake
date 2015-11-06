package level.object.animations.particle;

import level.object.Object;

public abstract class Particle extends Object{

    public int xSpeed, ySpeed, duration, size;

    public Particle(int x, int y, int duration){
        this.x = x;
        this.y = y;
        this.duration = duration;
    }


}
