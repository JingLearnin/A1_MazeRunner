package ca.mcmaster.se2aa4.mazerunner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RightHandMethod implements MazeSolver{

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Path solve(Maze maze) {
        Path movelist = new Path();
        Position currentPos = maze.getStartPos();
        Direction currentDir = Direction.EAST;


        while (!currentPos.equals(maze.getEndPos())) {

            Position rightPos = currentPos.move(DirectionHandler.turnRight(currentDir));
            if (maze.isPath(rightPos)) {
                // Turn right and move forward
                movelist.add('R');
                currentDir = DirectionHandler.turnRight(currentDir);
                movelist.add('F');
                currentPos = currentPos.move(currentDir);
            }

            else if (maze.isPath(currentPos.move(currentDir))) {
                // Move forward
                movelist.add('F');
                currentPos = currentPos.move(currentDir);
            }

            else if (maze.isPath(currentPos.move(DirectionHandler.turnLeft(currentDir)))) {
                // Turn left and move forward
                movelist.add('L');
                currentDir = DirectionHandler.turnLeft(currentDir);
                movelist.add('R');
                currentPos = currentPos.move(currentDir);

            }

            else {
                movelist.add('R');
                movelist.add('R');
                currentDir = DirectionHandler.turnRight(DirectionHandler.turnRight(currentDir));
                currentPos = currentPos.move(currentDir);
                movelist.add('F');
            }


            logger.debug("Current Position is: " + currentPos.toString() + "\nCurrent Direction Facing is: " + currentDir.toString() + "\nPath: " + movelist.getCanonicalForm());
        }

        return movelist;
    }
}



