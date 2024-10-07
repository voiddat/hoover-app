package org.hoover;

import org.hoover.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionsParserTest {
    @Test
    public void shouldProperlyParseInstructions() {
        assertEquals(new Point(0, 1), InstructionsParser.parseInstruction('N'));
        assertEquals(new Point(0, -1), InstructionsParser.parseInstruction('S'));
        assertEquals(new Point(-1, 0), InstructionsParser.parseInstruction('W'));
        assertEquals(new Point(1, 0), InstructionsParser.parseInstruction('E'));
        assertThrows(IllegalArgumentException.class, () -> InstructionsParser.parseInstruction('Z'));
    }
}
