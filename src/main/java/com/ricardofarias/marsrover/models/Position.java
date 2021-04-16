package com.ricardofarias.marsrover.models;

import com.ricardofarias.marsrover.enums.Direction;
import com.ricardofarias.marsrover.exceptions.MovementException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/*
 * This class represents the coordinate
 * @author Ricardo Farias
 */
@ToString
@Builder
@Getter
@AllArgsConstructor
public class Position {
    private int x;
    private int y;
    private Direction direction;

    /**
     * Move the rover
     * @param move type of movement
     */
    public void move(char move){
        switch (move) {
            case 'M': move(); break;
            case 'L': rotateLeft(); break;
            case 'R': rotateRight(); break;
            default: throw new MovementException("Invalid instruction " + move + ". Ex: 0 5 N");
        }
    }

    /**
     * Move one point in same direction
     */
    private void move() {
        switch (direction) {
            case N: this.y += 1; break;
            case S: this.y -= 1; break;
            case E: this.x += 1; break;
            case W: this.x -= 1; break;
        }
    }

    /**
     * Rotate 90 degrees to right
     */
    private void rotateRight() {
        switch (direction) {
            case N: direction = Direction.E; break;
            case E: direction = Direction.S; break;
            case S: direction = Direction.W; break;
            case W: direction = Direction.N; break;
        }
    }

    /**
     * Rotate 90 degrees to left
     */
    private void rotateLeft() {
        switch (direction) {
            case N: direction = Direction.W; break;
            case W: direction = Direction.S; break;
            case S: direction = Direction.E; break;
            case E: direction = Direction.N; break;
        }
    }
}
