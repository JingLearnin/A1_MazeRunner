package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class FileMazeFactory implements MazeFactory {
    @Override
    public Maze createMaze(String filePath) throws IOException {
        return new Maze(filePath);
}
}
