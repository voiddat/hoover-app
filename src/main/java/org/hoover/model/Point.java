package org.hoover.model;

public record Point(int x, int y) {
    Point(int[] coords) {
        this(coords[0], coords[1]);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
