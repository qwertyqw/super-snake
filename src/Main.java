import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;


public class Main {
    static private Game game;
    static private final int windowWidth = 600;
    static private final int windowHeight = 600;
    static private final double fieldCellSize = 5; //in pixels

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        try {
            Display.setDisplayMode(new DisplayMode(windowWidth, windowHeight));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        initGL();

        while (!Display.isCloseRequested()) {

            game.update();
            game.render();

            Display.update();
            Display.sync(60);
        }

        Display.destroy();
    }

    public static void initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, windowWidth / fieldCellSize, windowHeight / fieldCellSize, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glClearColor(0.7f, 0.7f, 0.7f, 1f);
        game = new Game(windowWidth, windowHeight, fieldCellSize);
    }

}