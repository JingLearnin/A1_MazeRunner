package ca.mcmaster.se2aa4.island.teamXXX;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.DirectionHandler;


public class TurningLeftTest {
    // Test left turn permutations
    @ParameterizedTest
    @MethodSource("leftTurnCases")
    void turnLeftShouldReturnCorrectDirection(Direction input, Direction expected) {
        assertEquals(expected, DirectionHandler.turnLeft(input));
    }

    private static Stream<Arguments> leftTurnCases() {
        return Stream.of(
            Arguments.of(Direction.NORTH, Direction.WEST),
            Arguments.of(Direction.WEST, Direction.SOUTH),
            Arguments.of(Direction.SOUTH, Direction.EAST),
            Arguments.of(Direction.EAST, Direction.NORTH)
        );
    }

    @ParameterizedTest
    @EnumSource(Direction.class)
    void turnLeftShouldNotReturnOriginalDirection(Direction direction) {
        assertNotEquals(direction, DirectionHandler.turnLeft(direction));
    }
    
}
