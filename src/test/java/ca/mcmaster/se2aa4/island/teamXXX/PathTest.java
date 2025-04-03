package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Path;

import static org.junit.jupiter.api.Assertions.*;

public class PathTest {

    @Test
    void testEmptyPath() {
        Path path = new Path();
        assertEquals("", path.getCanonicalForm(), "Empty path should return empty string");
    }

    @Test
    void testAddValidMoves() {
        Path path = new Path();
        path.add('F');
        path.add('L');
        path.add('R');
        assertEquals("FLR", path.getCanonicalForm(), "Should contain all added moves in order");
    }

    @Test
    void testInvalidMove() {
        Path path = new Path();
        assertThrows(IllegalArgumentException.class, () -> path.add('X'),
                "Should throw exception for invalid move");
    }

    @Test
    void testPathFromString() {
        Path path = new Path("FFLR");
        assertEquals("FFLR", path.getCanonicalForm(), "Should match input string");
    }

    @Test
    void testFactorizedForm() {
        Path path = new Path();
        path.add('F');
        path.add('F');
        path.add('L');
        path.add('R');
        path.add('R');
        assertEquals("2F L 2R", path.getFactorizedForm(), "Should properly factorize repeated moves");
    }

    @Test
    void testExpandFactorizedPath() {
        Path path = new Path("2F 3R L");
        assertEquals("FFRRRL", path.getCanonicalForm(), 
            "Should properly expand factorized notation");
    }

  

    @Test
    void testGetMoves() {
        Path path = new Path("FLR");
        var moves = path.getMoves();
        assertArrayEquals(
            new Character[]{'F', 'L', 'R'}, 
            moves.toArray(new Character[0]),
            "Should return correct list of moves"
        );
    }
}
