import java.util.Random;
import static org.lwjgl.opengl.GL11.*;
/**
 * Created by MockeR on 3/30/2014.
 */
public class Food {
    private Random r = new Random();
    Coordinate currentPlace;
    private double size = 0;

    public void nextPlace(Game game) {
        Coordinate t = null;
        size = game.windowHeight / game.cellSize;
        boolean ch = true;
         while (ch) {
             ch = false;
             t = new Coordinate(r.nextInt((int)size), r.nextInt((int)size));
             for (Coordinate c : game.snake.body) {
                  if (t.distance(c) < game.snake.getThick()) {
                      ch = true;
                      break;
                  }
             }
         }
        currentPlace = t;
    }

    public void draw() {
        glColor3d(0, 1, 1);
        glBegin(GL_TRIANGLE_FAN);
        glVertex2d(currentPlace.j, currentPlace.i);
        for (double a = 0; a <= 2 * Math.PI; a += Math.PI / 20)
             glVertex2d(currentPlace.j + 2 * Math.cos(a), currentPlace.i + 2 * Math.sin(a));
        glEnd();
    }
}
