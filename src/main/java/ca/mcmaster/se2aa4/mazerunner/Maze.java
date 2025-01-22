package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    public Maze(String filePath) throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader(filePath));

    
    startPos = startPosition();
    endPos = endPostion();

    }
    


private Position startPosition () throws Exception {
    for (int i = 0; i < maze.size; i++){
        Position pos = new Position(0,i);
        
        if 
    }
}

private Position endPostion() throws Exception{
    for (int i - 0; i < maze.size; i++){
        
    }
}
}