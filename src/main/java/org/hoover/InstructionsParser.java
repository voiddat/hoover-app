package org.hoover;

import org.hoover.model.Point;

public class InstructionsParser {
    public static Point parseInstruction(char ch) {
        return switch (ch) {
            case 'N' -> new Point(0, 1);
            case 'S' -> new Point(0, -1);
            case 'W' -> new Point(-1, 0);
            case 'E' -> new Point(1,0);
            default -> throw new IllegalArgumentException();
        };
    }
}
