package com.ricardofarias.marsrover;

import com.ricardofarias.marsrover.enums.Direction;
import com.ricardofarias.marsrover.exceptions.MovementException;
import com.ricardofarias.marsrover.models.Plateau;
import com.ricardofarias.marsrover.models.Position;
import com.ricardofarias.marsrover.models.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverTest {
    @Test
    public void whenRover1MovementIsValid(){
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(1, 2, Direction.N);
        String instruction = "LMLMLMLMM";

        Rover rover = new Rover(plateau, position);
        rover.move(instruction);

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
        assertEquals(Direction.N, rover.getPosition().getDirection());
    }

    @Test
    public void whenRover2MovementIsValid(){
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(3, 3, Direction.E);
        String instruction = "MMRMMRMRRM";

        Rover rover = new Rover(plateau, position);
        rover.move(instruction);

        assertEquals(5, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.E, rover.getPosition().getDirection());
    }

    @Test
    public void whenRoverMovementIsInvalid(){
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(1, 2, Direction.N);
        String instruction = "LMLMLMLMM 534534";

        Rover rover = new Rover(plateau, position);

        assertThrows(MovementException.class, () -> rover.move(instruction));
    }

    @Test
    public void whenExceedsEdges(){
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(8, 8, Direction.E);
        String instruction = "MMRMMRMRRM";

        Rover rover = new Rover(plateau, position);

        assertThrows(MovementException.class, () -> rover.move(instruction));
    }
}
