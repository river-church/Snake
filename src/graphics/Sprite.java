package graphics;

public class Sprite {
    protected Spritesheet spritesheet;
    protected int x, y;
    public final int SIZE;
    public int[] pixels;
    public int color;


    //Sprites
    public static Sprite spr_snake =  new Sprite(8,0,0,Spritesheet.spritesheet);
    public static Sprite spr_void =  new Sprite(8, 0x000000);
    public static Sprite spr_wall = new Sprite(8, 8, 0, Spritesheet.spritesheet);
    public static Sprite spr_add_piece_icon = new Sprite(8, 8, 8, Spritesheet.spritesheet);

    public Sprite(int size, int x, int y, Spritesheet spritesheet) {
        this.SIZE = size;
        this.x = x;
        this.y = y;
        this.spritesheet = spritesheet;
        this.pixels = new int[SIZE*SIZE];
        load();
    }

    public Sprite(int size, int x, int y, Spritesheet spritesheet, int color) {
        this.SIZE = size;
        this.x = x;
        this.y = y;
        this.spritesheet = spritesheet;
        this.color = color;
        this.pixels = new int[SIZE*SIZE];
        load();
    }

    public Sprite(int size, int color){
        this.SIZE = size;
        this.pixels = new int[SIZE*SIZE];
        this.color = color;
        fillColor(color);
    }

    private void load(){
        System.out.println("loading...");
        for(int y = 0; y < SIZE; y++){
            for(int x = 0; x < SIZE; x++){
                pixels[x + y * SIZE] = spritesheet.pixels[(x + this.x) + (y + this.y) * spritesheet.SIZE];

                System.out.println("pixel color: " + spritesheet.pixels[x+y*SIZE]);
            }
        }
    }

    protected void fillColor(int color){
        for(int i = 0; i < SIZE*SIZE; i++){
            this.pixels[i] = color;
        }
    }


}
