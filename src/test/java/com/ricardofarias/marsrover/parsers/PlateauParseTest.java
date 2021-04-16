package com.ricardofarias.marsrover.parsers;

import com.ricardofarias.marsrover.exceptions.CommandException;
import com.ricardofarias.marsrover.models.Plateau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlateauParseTest {
    @Test
    public void whenPlateauIsValid() {
        Plateau plateau = PlateauParser.parse("5 5");

        assertEquals(5, plateau.getTopX());
        assertEquals(5, plateau.getTopY());
    }

    @Test
    public void whenPlateauIsInvalid() {
        assertThrows(CommandException.class, () -> PlateauParser.parse("5 G"));
    }
}
