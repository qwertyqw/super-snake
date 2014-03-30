import java.util.Random;

/**
 * Created by MockeR on 3/30/2014.
 */
public class SnakePart extends Coordinate {
    Random rand;
    double r, g, b;

    public SnakePart(Coordinate c) {
        super(c.i, c.j);
        setColor();
    }

    public SnakePart(int i, int j) {
        super(i, j);
        setColor();
    }

    private void setColor() {
        rand = new Random();
//        r = rand.nextDouble();
//        g = rand.nextDouble();
//        b = rand.nextDouble();
        r = 1;
        g = 1;
        b = 0;
    }
}
