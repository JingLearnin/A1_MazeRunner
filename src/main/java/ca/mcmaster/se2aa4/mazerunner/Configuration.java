package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {
    private static final Logger logger = LogManager.getLogger();
    private final CommandLine cmd;

    /**
     * Parses the command-line arguments.
     *
     * @param args Command-line arguments.
     * @throws ParseException If argument parsing fails.
     */
    
     public Configuration(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        this.cmd = parser.parse(getParser(), args);
    }

    /**
     * Retrieves the value of the -i flag.
     *
     * @return The maze file path.
     */
    public String getMazeFile() {
        return cmd.getOptionValue("i");
    }
    /**
     * Retrieves the value of the -p flag.
     *
     * @return The maze file path.
     */
    public boolean hasPathOption() {return cmd.hasOption("p");}

    public String getPath() {
        return cmd.getOptionValue("p");
    }

    /**
     * Defines the CLI options.
     *
     * @return The available CLI options.
     */
    
     private static Options getParser() {
        Options options = new Options();

        Option fileOption = new Option("i", true, "File that contains the maze");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        options.addOption(new Option("p", true, "Path provided by user is vaild to finish the maze"));

        return options;
    }
}