package com.ricardofarias.marsrover.models;

import lombok.*;

/*
 * This class represents the rover
 * @author Ricardo Farias
 */
@ToString
@Getter
@AllArgsConstructor
public class Rover {
    private final Plateau plateau;
    private final Position position;

    /**
     * Move the rover
     * M: Move one point in same direction
     * L: Rotate 90 degrees to left
     * R: Rotate 90 degrees to right
     * @param instruction series of instructions. Ex: MMRMMRMRRM
     */
    public void move(String instruction) {
        plateau.validate(position);

        for(char move: instruction.toCharArray()) {
            position.move(move);
        }

        System.out.printf("%s %s %s", position.getX(), position.getY(), position.getDirection());
        System.out.println();
    }
}
