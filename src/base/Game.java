package base;

//WELCOME TO THE GAME CLASS
//HIGH SCORE: 98

import UI.*;
import UI.UIManager;
import event.Keyboard;
import event.Mouse;
import graphics.Screen;
import level.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

public class Game extends Canvas implements Runnable{ //Canvas::Game "can use" Runnable
    private static final long serialVersionUID = 1L; //Java Conventions *sigh*...

    public static int width = 600; //use 400 with level width 49 and h 27 for scale 3 with smaller map and no scroll
    public static int height = width / 16 * 9;
    //public static int height = width;
    public static int scale = 2;

    public static String title = "SnakeExtreme v0.0.0.1"; //TITLE

    private Thread thread;
    private JFrame frame;

    private Keyboard key;
    private Mouse mouse;
    private boolean running = false;
    private Screen screen;

    private Level level;

    private UIManager ui;




    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  //create image
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();     //image -> int[]

    public Game(){ //runs when new instance of Game is created
        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        key = new Keyboard();
        mouse = new Mouse();
        frame = new JFrame();

        addKeyListener(key);
        addMouseListener(mouse);

        level = new Level(74, 40, key);
        ui = new UIManager(key);

    }

    public synchronized void start(){ //creates a new thread that under the Game class and starts it
        running = true;
        thread = new Thread(this, "Display");
        thread.start();


    }

    public synchronized void stop(){ //joins threads, throws the inevitable exception, and exits the game
        running = false;
        try{
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){ //runs the game
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int ticks = 0;

        while(running){ //do this while the game is running
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) { //if more than one ns has passed, do this
                tick();
                ticks++;
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){ //tick regulator and fps counter
                timer += 1000;
                frame.setTitle(title + " | " + ticks + " ticks, " + frames + " fps");
                ticks = 0;
                frames = 0;
            }

        }
        stop();
    }


    public void tick(){ //regulates the refresh rate to 60 updates ("ticks") per second
        if(level.playing){
            level.tick();
        }

        //ui.tick();
    }



    public void render(){ //swap-chain, rendering...
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3); //if there's NO buffer, make one!
            return;
        }
        Graphics g = bs.getDrawGraphics();

        //rendering to the screen
        screen.clear();
        level.render(0, 0, screen);

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = screen.pixels[i];
        }


        //GRAPHICS CODE HERE V
        Random random = new Random();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        //ui.render(g);

        //GRAPHICS CODE HERE ^
        g.dispose();
        bs.show();

    }

    public static void main(String[] args){ // think int main() from C++ (calls all functions, creates instances of Game, etc.)
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(Game.title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }




}
