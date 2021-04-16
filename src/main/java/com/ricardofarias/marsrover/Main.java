package com.ricardofarias.marsrover;

import com.ricardofarias.marsrover.models.Plateau;
import com.ricardofarias.marsrover.models.Position;
import com.ricardofarias.marsrover.models.Rover;
import com.ricardofarias.marsrover.parsers.InstructionParser;
import com.ricardofarias.marsrover.parsers.PlateauParser;
import com.ricardofarias.marsrover.parsers.PositionParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        Plateau plateau = PlateauParser.parse(scanner.nextLine());

        while(scanner.hasNextLine()) {
            Position position = PositionParser.parse(scanner.nextLine());
            String instruction = InstructionParser.parse(scanner.nextLine());

            Rover rover = new Rover(plateau, position);
            rover.move(instruction);
        }
    }
}
