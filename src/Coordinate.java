/**
 * Created by MockeR on 3/29/2014.
 */
public class Coordinate {
    int i, j;
    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public double distance(Coordinate c) {
        return Math.sqrt((i - c.i) * (i - c.i) + (j - c.j) * (j - c.j));
    }

    public void set(Coordinate c) {
        i = c.i;
        j = c.j;
    }

    public void set(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
