package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
Checking if user has entered the correct path from start to end

 @return if the path entered is vaild


 */

public class PathValidator {
    private static final Logger logger = LogManager.getLogger();
    private final Maze maze;
    private final Position entry;
    private final Position exit;
    private Direction initialDir;

    public PathValidator(Maze maze) {
        this.maze = maze;
        this.entry = maze.getStartPos();
        this.exit = maze.getEndPos();
        this.initialDir = initialDirectionFinder(entry);
    }

    public boolean isValidate(Path path) {
        List<Character> moves = path.getMoves();
        return isValidateMoves(moves);
    }

    private boolean isValidateMoves(List<Character> moves) {
        Position currentPos = entry;
        Direction currentDir = initialDir;

        logger.debug("Starting validation at " + entry + " facing " + currentDir);

        for (Character move : moves) {
            switch (move) {
                case 'F' -> {
                    Position newPos = currentPos.move(currentDir);
                    if (isOutOfBounds(currentPos) || maze.isWall(currentPos)) {
                        logger.error("Collision at position: " + currentPos);
                        return false;
                    }
                    currentPos = newPos;
                }
                case 'L' -> currentDir = DirectionHandler.turnLeft(currentDir);
                case 'R' -> currentDir = DirectionHandler.turnRight(currentDir);
            }

            logger.debug("Step: " + move +
                    " | Position: " + currentPos +
                    " | Facing: " + currentDir);
        }

        boolean valid = currentPos.equals(exit);
        logger.debug("Path validation result: " + (valid ? "VALID" : "INVALID"));
        return valid;
    }



    /**
     * Checking for initial facing direction
     * Can be used for future extention
     *
     * @param entryPos
     * @return
     */
    private Direction initialDirectionFinder(Position entryPos) {
        if (entryPos.x() == 0) {  // West entry
            return Direction.EAST;  // Entry faces East
        } else {  // East entry
            return Direction.WEST;  // Entry faces West
        }
    }


    private boolean isOutOfBounds(Position pos){
        return pos.x() < 0 || pos.y() < 0 || pos.x() >= maze.getSizeX() || pos.y() >= maze.getSizeY();
    }


}
