package com.ricardofarias.marsrover.parsers;

import com.ricardofarias.marsrover.enums.Direction;
import com.ricardofarias.marsrover.exceptions.CommandException;
import com.ricardofarias.marsrover.models.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionParseTest {
    @Test
    public void whenPositionIsValid() {
        Position position = PositionParser.parse("1 2 N");

        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void whenPositionIsInvalid() {
        assertThrows(CommandException.class, () -> PositionParser.parse("Y 2 N"));
    }

    @Test
    public void whenDirectionIsInvalid() {
        assertThrows(CommandException.class, () -> PositionParser.parse("1 2 T"));
    }
}
