package com.ricardofarias.marsrover.parsers;

import com.ricardofarias.marsrover.enums.Direction;
import com.ricardofarias.marsrover.exceptions.CommandException;
import com.ricardofarias.marsrover.models.Position;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
    The position text parser
 */
public class PositionParser {

    /**
     * Parse of string to object
     * @param str coordinate. Ex: 1 3 N
     * @return plateau {@link Position}
     */
    public static Position parse(String str) {
        Pattern pattern = Pattern.compile("(\\d)\\s(\\d)\\s([N,E,S,W])");
        Matcher parser = pattern.matcher(str);

        if(!parser.matches()) {
            throw new CommandException("Invalid position: " + str);
        }

        return Position.builder()
            .x(Integer.parseInt(parser.group(1)))
            .y(Integer.parseInt(parser.group(2)))
            .direction(Direction.valueOf(parser.group(3)))
        .build();
    }
}
