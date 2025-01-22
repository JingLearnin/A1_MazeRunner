package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Configuration {
    private static final Logger logger = LogManager.getLogger();
    private static String filename;

    public static void configure(String[] args){

        try{
            Options options = new Options();
            CommandLineParser parser = new DefaultParser();
            options.addOption("i", true, "option reacting to -i");

            CommandLine cmd = parser.parse(options, args);
            filename = cmd.getOptionValue("i");
            

            if (cmd.hasOption("i")){
                
            }
        }
    }

    
};
    
}
