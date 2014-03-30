public enum Direction {
    NORTH (-1, 0),
    EAST (0, 1),
    SOUTH (1, 0),
    WEST (0, -1);

    int i, j;

    Direction(int i, int j) {
        this.i = i;
        this.j = j;
    }

    Direction left() { return values()[(this.ordinal() + 3) % 4]; }

    Direction right() { return values()[(this.ordinal() + 1) % 4]; }

    Direction back() { return values()[(this.ordinal() + 2) % 4]; }
}
