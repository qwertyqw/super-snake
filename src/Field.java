import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;

/**
 * Created by MockeR on 3/29/2014.
 */
public class Field {
    private int windowWidth;
    private int windowHeight;
    private double cellSize;
    private double orthoWidth;
    private double orthoHeight;

    public Field(int windowWidth, int windowHeight, double cellSize) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.cellSize = cellSize;
        orthoWidth = windowWidth / cellSize;
        orthoHeight = windowHeight / cellSize;
    }

    public void draw() {
        glColor3d(0, 0, 1);
        glBegin(GL_LINES);

//        for (int i = 0; i < orthoWidth; i++) {
//            glVertex2d(i, 0);
//            glVertex2d(i, orthoHeight);
//
//        }
//
//        for (int i = 0; i < orthoHeight; i++) {
//            glVertex2d(0, i);
//            glVertex2d(orthoWidth, i);
//        }
        glEnd();
    }
}
