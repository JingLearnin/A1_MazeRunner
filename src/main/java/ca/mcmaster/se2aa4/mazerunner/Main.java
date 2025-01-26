package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        try {
            // Parse CLI arguments using Configuration
            Configuration config = new Configuration(args);

            // Get the maze file path
            String filePath = config.getMazeFile();
            logger.info("Maze file path provided: " + filePath);

            // Validate that the file exists
            if (!Files.exists(Paths.get(filePath))) {
                throw new Exception("Maze file does not exist: " + filePath);
            }

            // Read and process the maze file
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int row = 0;

                logger.info("Processing maze file:");
                while ((line = reader.readLine()) != null) {
                    System.out.println("Row " + row + ": " + line);
                    row++;
                }

                logger.info("Maze file successfully loaded and processes. Total rows: " + row);
            }

        } catch (Exception e) {
            logger.error("Error occurred: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        }

        logger.info("** End of Maze Runner");
    }
}