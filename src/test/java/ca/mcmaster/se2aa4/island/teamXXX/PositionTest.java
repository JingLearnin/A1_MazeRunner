package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    void testPositionCreation() {
        Position pos = new Position(1, 2);
        assertEquals(1, pos.x());
        assertEquals(2, pos.y());
    }

    @Test
    void testPositionAdd() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(3, 4);
        Position result = pos1.add(pos2);
        
        assertEquals(4, result.x());
        assertEquals(6, result.y());
    }

    @Test
    void testMoveNorth() {
        Position pos = new Position(1, 1);
        Position result = pos.move(Direction.NORTH);
        assertEquals(1, result.x());
        assertEquals(0, result.y()); // y decreases when moving north
    }

    @Test
    void testMoveSouth() {
        Position pos = new Position(1, 1);
        Position result = pos.move(Direction.SOUTH);
        assertEquals(1, result.x());
        assertEquals(2, result.y()); // y increases when moving south
    }

    @Test
    void testMoveEast() {
        Position pos = new Position(1, 1);
        Position result = pos.move(Direction.EAST);
        assertEquals(2, result.x()); // x increases when moving east
        assertEquals(1, result.y());
    }

    @Test
    void testMoveWest() {
        Position pos = new Position(1, 1);
        Position result = pos.move(Direction.WEST);
        assertEquals(0, result.x()); // x decreases when moving west
        assertEquals(1, result.y());
    }

    @ParameterizedTest
    @EnumSource(Direction.class)
    void testMoveDoesNotModifyOriginal(Direction dir) {
        Position original = new Position(1, 1);
        Position moved = original.move(dir);
        
        assertEquals(1, original.x());
        assertEquals(1, original.y());
        assertNotEquals(original, moved);
    }
}
