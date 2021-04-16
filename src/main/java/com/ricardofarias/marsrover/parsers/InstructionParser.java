package com.ricardofarias.marsrover.parsers;

import com.ricardofarias.marsrover.exceptions.CommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    The instruction text parser
 */
public class InstructionParser {

    /**
     * Validate string with instructions
     * @param str coordinate. Ex: LMLMLMLMM
     * @return original value
     */
    public static String parse(String str) {
        Pattern pattern = Pattern.compile("([L,M,R]+)");
        Matcher parser = pattern.matcher(str);

        if(!parser.matches()) {
            throw new CommandException("Invalid instruction: " + str + ". Allowed values: L, R or M. Ex: LMLMLMLMM");
        }

        return parser.group(1);
    }
}
