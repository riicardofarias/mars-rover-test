package com.ricardofarias.marsrover.parsers;

import com.ricardofarias.marsrover.exceptions.CommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionParseTest {
    @Test
    public void whenInstructionsIsValid() {
        String instruction = InstructionParser.parse("LMLMLMLMM");
        assertEquals("LMLMLMLMM", instruction);
    }

    @Test
    public void whenInstructionsIsInvalid() {
        assertThrows(CommandException.class, () -> InstructionParser.parse("LMLMLMLMMKT"));
    }
}
