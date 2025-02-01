package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeSolver {
    private static final Logger logger = LogManager.getLogger();

    public Path solve(Maze maze) {
        Path path = new Path();

        Position currentPos = maze.getStartPos();
        Direction currentDir = Direction.EAST;


        while (!currentPos.equals(maze.getEndPos())) {

            Position rightPos = currentPos.move(DirectionHandler.turnRight(currentDir));
            if (maze.isPath(rightPos)) {
                // Turn right and move forward
                currentDir = DirectionHandler.turnRight(currentDir);
                path.add('R');
                currentPos = currentPos.move(currentDir);
                path.add('F');
            }

            else if (maze.isPath(currentPos.move(currentDir))) {
                // Move forward
                currentPos = currentPos.move(currentDir);
                path.add('F');
            }

            else if (maze.isPath(currentPos.move(DirectionHandler.turnLeft(currentDir)))) {
                // Turn left and move forward
                currentDir = DirectionHandler.turnLeft(currentDir);
                path.add('L');
                currentPos = currentPos.move(currentDir);
                path.add('F');
            }

            else {
                currentDir = DirectionHandler.uTurn(currentDir);
                path.add('R');
                path.add('R');
            }


            logger.debug("Position: " + currentPos.toString() + "\nPath: " + path.getCanonicalForm());
        }

        return path;
    }
}