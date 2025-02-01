package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
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
                throw new IOException("Maze file does not exist: " + filePath);
            }

            // Load the maze
            Maze maze = new Maze(filePath);
            logger.info("Maze successfully loaded.");

            // Solve the maze
            MazeSolver solver = new MazeSolver();
            Path path = solver.solve(maze);

            // Print the path in factorized form
            System.out.println(path.getFactorizedForm());

        } catch (IOException e) {
            logger.error("File I/O error: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            logger.error("Invalid maze: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        }

        logger.info("** End of Maze Runner");
    }
}