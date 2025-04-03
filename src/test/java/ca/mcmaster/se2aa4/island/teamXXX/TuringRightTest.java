package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.Arguments;
import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.DirectionHandler;

class TuringRightTest {

    // Test right turn permutations
    @ParameterizedTest
    @MethodSource("rightTurnCases")
    void turnRightShouldReturnCorrectDirection(Direction input, Direction expected) {
        assertEquals(expected, DirectionHandler.turnRight(input));
    }

    private static Stream<Arguments> rightTurnCases() {
        return Stream.of(
            Arguments.of(Direction.NORTH, Direction.EAST),
            Arguments.of(Direction.EAST, Direction.SOUTH),
            Arguments.of(Direction.SOUTH, Direction.WEST),
            Arguments.of(Direction.WEST, Direction.NORTH)
        );
    }




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

    // Test method contracts
    @ParameterizedTest
    @EnumSource(Direction.class)
    void turnRightShouldNotReturnOriginalDirection(Direction direction) {
        assertNotEquals(direction, DirectionHandler.turnRight(direction));
    }
}

