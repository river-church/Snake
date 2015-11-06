package level.object.animations;

import graphics.Screen;
import level.object.animations.particle.ExplodeyParticle;
import level.object.Object;

import java.util.ArrayList;
import java.util.Random;

public class Explosion extends Object {

    int particle_count, color;
    private Random random = new Random();

    public ArrayList<ExplodeyParticle> particles = new ArrayList<ExplodeyParticle>();

    public Explosion(int x, int y, int particle_count, int color){
        this.x = x;
        this.y = y;
        this.particle_count = particle_count;
        this.color = color;
        generateParticles(x,y,color);

    }

    private void generateParticles(int x, int y, int color){
        for(int i = 0; i < particle_count; i++){
            particles.add(new ExplodeyParticle(x,y,random.nextInt() % 4 + 1, 30 + random.nextInt() % 20, color,random.nextInt() % 5,random.nextInt() % 5));

        }
    }

    public void tick(){
        for(int i = 0; i < particles.size(); i++){
            particles.get(i).tick();
            if(particles.get(i).active == false)particles.remove(i);

        }
    }

    public void render(Screen screen){
        for (int i = 0; i < particles.size(); i++){
            particles.get(i).render(screen);
        }
    }

}
