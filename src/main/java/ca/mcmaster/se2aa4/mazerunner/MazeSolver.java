package ca.mcmaster.se2aa4.mazerunner;



public interface MazeSolver {
    /**
     * Interface for the mazesolver
     * Make the code able to add new algorithm
     * @param maze
     * @return Path from start position to end position
     */
    Path solve(Maze maze);
}
/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class MazeSolver {
    private static final Logger logger = LogManager.getLogger();

    public Path solve(Maze maze) {
        Path path = new Path();
        List<Character> moveList = new ArrayList<>();
        Position currentPos = maze.getStartPos();
        Direction currentDir = Direction.EAST;


        while (!currentPos.equals(maze.getEndPos())) {

            Position rightPos = currentPos.move(DirectionHandler.turnRight(currentDir));
            if (maze.isPath(rightPos)) {
                // Turn right and move forward
                path.add('R');
                currentDir = DirectionHandler.turnRight(currentDir);
                path.add('F');
                currentPos = currentPos.move(currentDir);
            }

            else if (maze.isPath(currentPos.move(currentDir))) {
                // Move forward
                path.add('F');
                currentPos = currentPos.move(currentDir);
            }

            else if (maze.isPath(currentPos.move(DirectionHandler.turnLeft(currentDir)))) {
                // Turn left and move forward
                path.add('L');
                currentDir = DirectionHandler.turnLeft(currentDir);
                path.add('R');
                currentPos = currentPos.move(currentDir);

            }

            else {
                path.add('R');
                path.add('R');
                currentDir = DirectionHandler.turnRight(DirectionHandler.turnRight(currentDir));
                currentPos = currentPos.move(currentDir);
                path.add('F');
            }


            logger.debug("Position: " + currentPos.toString() + "\nPath: " + path.getCanonicalForm());
        }

        return path;
    }
}

 */
