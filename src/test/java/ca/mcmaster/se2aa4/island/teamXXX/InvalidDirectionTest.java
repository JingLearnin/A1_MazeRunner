package ca.mcmaster.se2aa4.island.teamXXX;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.DirectionHandler;

public class InvalidDirectionTest {
    // Test invalid direction handling
    @Test
    void invalidDirectionShouldThrowException() {
        assertThrows(NullPointerException.class, () -> {
            DirectionHandler.turnRight(null);
        });
        
        
        assertThrows(IllegalArgumentException.class, () -> {
            Direction invalid = Direction.valueOf("INVALID");
            DirectionHandler.turnLeft(invalid);
        });
    }
}
