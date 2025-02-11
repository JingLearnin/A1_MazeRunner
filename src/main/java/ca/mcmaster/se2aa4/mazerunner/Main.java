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

            Configuration config = new Configuration(args);



            String filePath = config.getMazeFile();
            logger.debug("Maze file path provided: " + filePath);


            if (!Files.exists(Paths.get(filePath))) {
                throw new IOException("Maze file does not exist: " + filePath);
            }

            // Load the maze
            Maze maze = new Maze(filePath);
            logger.debug("Maze successfully loaded.");
            PathValidator validator = new PathValidator(maze);


            // Solve the maze
            if (config.hasPathOption()) {
                // Validate user-provided path
                String pathInput = config.getPath();
                Path userPath = new Path(pathInput);



                boolean isValid = validator.isValidate(userPath);
                System.out.println((isValid ? "correct path" : "incorrect path"));
            } else
            {
                // Compute and show path normally
                MazeSolver solver = new RightHandMethod();
                Path solution = solver.solve(maze);
                System.out.println(solution.getFactorizedForm());
            }

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