import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by MockeR on 3/29/2014.
 */
public class Snake {
    Random r = new Random();
    private double thick;
    private Direction currentDirection;
    private double worldWidth;
    private double worldHeight;
    List<SnakePart> body;

    public Snake(Coordinate head, double thick, double worldWidth, double worldHeight) {
        body = new ArrayList<SnakePart>();
        body.add(new SnakePart(head));
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.thick = thick;
        currentDirection = Direction.EAST;
    }

    public void eat() {
        for (int i = 0; i < thick; i++)
            body.add(new SnakePart(body.get(body.size() - 1).i, body.get(body.size() - 1).j));
    }

    public void draw() {
        drawHead();
        drawTail();
    }

    private void drawHead() {
        double i1, i2, i3, i4, j1, j2, j3, j4;
        double coeff = thick / 2;
        SnakePart current;
        for (int i = body.size() - 1; i >= 0; i--) {

            current = body.get(i);
//            i1 = current.i + currentDirection.i * coeff + currentDirection.left().i * coeff;
//            i2 = current.i + currentDirection.i * coeff + currentDirection.right().i * coeff;
//            i3 = current.i + currentDirection.back().i * coeff + currentDirection.left().i * coeff;
//            i4 = current.i + currentDirection.back().i * coeff + currentDirection.right().i * coeff;
//
//            j1 = current.j + currentDirection.j * coeff + currentDirection.left().j * coeff;
//            j2 = current.j + currentDirection.j * coeff + currentDirection.right().j * coeff;
//            j3 = current.j + currentDirection.back().j * coeff + currentDirection.left().j * coeff;
//            j4 = current.j + currentDirection.back().j * coeff + currentDirection.right().j * coeff;
//
//
//            glColor3d(current.r, current.g, current.b);
//            glBegin(GL_QUADS);
//
//            glVertex2d(j1, i1);
//            glVertex2d(j2, i2);
//            glVertex2d(j4, i4);
//            glVertex2d(j3, i3);
//
//            glEnd();

            glColor3d(current.r, current.g, current.b);
            glBegin(GL_TRIANGLE_FAN);
            glVertex2d(current.j, current.i);
            for (double a = 0; a <= 2 * Math.PI; a += Math.PI / 20)
                glVertex2d(current.j + 2 * Math.cos(a), current.i + 2 * Math.sin(a));
            glEnd();
        }

    }

    private void drawTail() {

    }

    public void move() {
        int ti, tj;
        ti = body.get(0).i + currentDirection.i;
        tj = body.get(0).j + currentDirection.j;

        if (ti < 0 || ti >= worldHeight)
            ti = (int) ((ti + worldHeight) % worldHeight);
        if (tj < 0 || tj >= worldWidth)
            tj = (int) ((tj + worldWidth) % worldWidth);
        Coordinate t = new Coordinate(ti, tj);
        for (int i = body.size() - 1; i > 0; i--)
            body.get(i).set(body.get(i - 1));
        body.get(0).set(t);
    }

    public void setDirection(Direction dir) {
        currentDirection = dir;
    }

    public double getThick() {
        return thick;
    }
}
