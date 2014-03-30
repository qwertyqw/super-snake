import org.lwjgl.input.Keyboard;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

public class Game {
    private final int[] keys = {Keyboard.KEY_UP, Keyboard.KEY_RIGHT, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT};
    private Field field;
    public int windowWidth;
    public int windowHeight;
    private double worldWidth;
    private double worldHeight;
    public double cellSize;
    public Snake snake;
    private Food food;
    private HashMap<Integer, Direction> directionMap;

    public Game(int windowWidth, int windowHeight, double cellSize) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.cellSize = cellSize;
        worldWidth = windowWidth / cellSize;
        worldHeight = windowHeight / cellSize;

        field = new Field(windowWidth, windowHeight, cellSize);
        snake = new Snake(new Coordinate(10, 10), 5, worldWidth, worldHeight);

        snake.body.get(0).r = 1;
        snake.body.get(0).g = 0;
        snake.body.get(0).b = 0;
        food = new Food();
        food.nextPlace(this);

        directionMap = new LinkedHashMap<Integer, Direction>();

        for (int d = 0; d < 4; d++)
            directionMap.put(keys[d], Direction.values()[d]);
    }

    public void update() {
        int key = keyListener();
        if (key != -1)
            snake.setDirection(directionMap.get(key));
        if (snake.body.get(0).distance(food.currentPlace) < 5) {
            snake.eat();
            food.nextPlace(this);
        }
        snake.move();

    }

    public void render() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        field.draw();
        food.draw();
        snake.draw();

    }

    private int keyListener() {
        while(Keyboard.next()) {
            if (Keyboard.getEventKeyState() && directionMap.containsKey(Keyboard.getEventKey()))
                return Keyboard.getEventKey();
        }
        return -1;
    }
}
