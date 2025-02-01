package ca.mcmaster.se2aa4.mazerunner;

public class DirectionHandler {
    /**
     * Returns the direction after turning right.
     *
     * @param current The current direction its facing.
     * @return The new direction facing after turning right.
     */
    
     public static Direction turnRight(Direction current) {
         return switch (current) {
             case NORTH -> Direction.EAST;
             case EAST -> Direction.SOUTH;
             case SOUTH -> Direction.WEST;
             case WEST -> Direction.NORTH;
             default -> throw new IllegalStateException("Invalid direction: " + current);
         };
    }

    /**
     * Returns the direction after turning left.
     *
     * @param current The current direction its facing.
     * @return The new direction facing after turning left.
     */
    public static Direction turnLeft(Direction current) {
        return switch (current) {
            case NORTH -> Direction.WEST;
            case EAST -> Direction.NORTH;
            case SOUTH -> Direction.EAST;
            case WEST -> Direction.SOUTH;
            default -> throw new IllegalStateException("Invalid direction: " + current);
        };
    }
/**
 * Returns the direction after turning to the opposite.
 *
 * @param current The current direction its facing.
 * @return The new direction facing after uturning.
 */
public static Direction uTurn(Direction current) {
    return switch (current) {
        case NORTH -> Direction.SOUTH;
        case SOUTH -> Direction.NORTH;
        case EAST -> Direction.WEST;
        case WEST -> Direction.EAST;
        default -> throw new IllegalStateException("Invalid direction: " + current);
    };
}



}
