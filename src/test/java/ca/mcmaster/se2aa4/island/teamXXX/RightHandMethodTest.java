package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.DirectionHandler;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.Position;
import ca.mcmaster.se2aa4.mazerunner.RightHandMethod;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

/**
 * RightHandMethod Tests
 *  
 */
public class RightHandMethodTest {
    
    private RightHandMethod solver;
    
    @BeforeEach
    void setUp() {
        solver = new RightHandMethod();
    }

    @Test
    void testEasyMaze() throws IOException {
        
        String mazePath = "./examples/straight.maz.txt";
        Maze maze = new Maze(mazePath);
        Path solution = solver.solve(maze);
        
        
        assertValidPath(maze, solution);
    }

    
    private void assertValidPath(Maze maze, Path solution) {
        Position currentPos = maze.getStartPos();
        Direction currentDir = Direction.EAST;
        
        for (char move : solution.getCanonicalForm().toCharArray()) {
            switch (move) {
                case 'F':
                    currentPos = currentPos.move(currentDir);
                    assertTrue(maze.isPath(currentPos), 
                        String.format("Invalid move to position: %s in direction: %s", 
                        currentPos, currentDir));
                    break;
                case 'R':
                    currentDir = DirectionHandler.turnRight(currentDir);
                    break;
                case 'L':
                    currentDir = DirectionHandler.turnLeft(currentDir);
                    break;
            }
        }
        
        assertEquals(maze.getEndPos(), currentPos, 
            "Path did not reach the end position. Ended at: " + currentPos);
    }
}
