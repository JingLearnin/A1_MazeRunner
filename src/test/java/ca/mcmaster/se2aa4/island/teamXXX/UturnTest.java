package ca.mcmaster.se2aa4.island.teamXXX;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.DirectionHandler;

public class UturnTest {
    // Test U-turn permutations
    @ParameterizedTest
    @MethodSource("uTurnCases")
    void uTurnShouldReturnOppositeDirection(Direction input, Direction expected) {
        assertEquals(expected, DirectionHandler.uTurn(input));
    }

    private static Stream<Arguments> uTurnCases() {
        return Stream.of(
            Arguments.of(Direction.NORTH, Direction.SOUTH),
            Arguments.of(Direction.SOUTH, Direction.NORTH),
            Arguments.of(Direction.EAST, Direction.WEST),
            Arguments.of(Direction.WEST, Direction.EAST)
        );
    }

    @ParameterizedTest
    @EnumSource(Direction.class)
    void uTurnShouldReturnTrueOpposite(Direction direction) {
        Direction result = DirectionHandler.uTurn(direction);
        // Verify opposite relationship is bidirectional
        assertEquals(direction, DirectionHandler.uTurn(result));
    }
}
