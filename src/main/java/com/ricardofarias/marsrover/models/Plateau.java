package com.ricardofarias.marsrover.models;

import com.ricardofarias.marsrover.exceptions.MovementException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/*
    This class represents the plateau
    @author Ricardo Farias
*/
@ToString
@Getter
@AllArgsConstructor
public class Plateau {
    // Max top x coordinate
    private final int topX;

    // Max top y coordinate
    private final int topY;

    /**
     * Check if the next coordinate is inside the plateau
     * Throws {@link RuntimeException} if the coordinate is invalid
     * @param position next coordinate {@link Position}
     */
    public void validate(Position position) {
        int x = position.getX();
        int y = position.getY();

        if(x < 0 || x > topX || y < 0 || y > topY) {
            throw new MovementException("Invalid coordinate");
        }
    }
}
