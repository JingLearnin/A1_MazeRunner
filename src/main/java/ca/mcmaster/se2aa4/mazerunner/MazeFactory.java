package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public interface MazeFactory {
    Maze createMaze(String source) throws IOException;
    
}
