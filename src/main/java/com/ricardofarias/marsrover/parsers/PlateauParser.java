package com.ricardofarias.marsrover.parsers;

import com.ricardofarias.marsrover.exceptions.CommandException;
import com.ricardofarias.marsrover.models.Plateau;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    The plateau text parser
 */
public class PlateauParser {
    /**
     * Parse of string to object
     * @param str coordinate. Ex: 5 5
     * @return plateau {@link Plateau}
     */
    public static Plateau parse(String str) {
        Pattern pattern = Pattern.compile("(\\d)\\s(\\d)");
        Matcher parser = pattern.matcher(str);

        if(!parser.matches()) {
            throw new CommandException("Invalid plateau: " + str + ". The value must be two numbers of integer separated by space in same line. Ex: 5 5");
        }

        int x = Integer.parseInt(parser.group(1));
        int y = Integer.parseInt(parser.group(2));

        return new Plateau(x, y);
    }
}
