package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    //Logger in init
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("**** Starting Maze Runner Program ****");
        
        //Create a parser
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(getParserOption(),args);
            String fileName = cmd.getOptionValue("i");
            Maze maze = new Maze(fileName);
            
            
}
    }
private static Options getParserOption(){
    Options options = new Options();
    
    Option mazeOption = new Option("i", true, "Maze File");
    //Print error message if there is no input
    mazeOption.setRequired(true);
    //adding options to the options object
    options.addOption(mazeOption);

}  
}
