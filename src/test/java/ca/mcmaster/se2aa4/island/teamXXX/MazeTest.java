package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Position;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class MazeTest {
    
    private Maze maze;
    
    @BeforeEach
    void setUp() throws IOException {
        maze = new Maze("./examples/direct.maz.txt");
    }
    
    @Test
    void testWallIdentification() {
        
        Position wallPos = new Position(0, 0);  
        assertTrue(maze.isWall(wallPos), "Should identify wall correctly");
        assertFalse(maze.isPath(wallPos), "Wall should not be identified as path");
    }
    
    @Test
    void testPathIdentification() {
        
        Position pathPos = new Position(1, 1);  
        assertTrue(maze.isPath(pathPos), "Should identify path correctly");
        assertFalse(maze.isWall(pathPos), "Path should not be identified as wall");
    }
    
    @Test
    void testStartPosition() {
        Position start = maze.getStartPos();
        assertTrue(maze.isPath(start), "Start position should be a path");
        assertEquals(0, start.x(), "Start should be at left edge");
    }
    
    @Test
    void testEndPosition() {
        Position end = maze.getEndPos();
        assertTrue(maze.isPath(end), "End position should be a path");
        assertEquals(maze.getSizeX() - 1, end.x(), "End should be at right edge");
    }
}
