package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;

public class Maze {
    
    private static final Logger logger = LogManager.getLogger();
    private final List<List<CellType>> maze = new ArrayList<>();

    private final Position startPos;
    private final Position endPos;

    
    /**
     * Reading the each block from the maze file
     * 
     * @param filePath from the maze file
     */

    public Maze(String filePath) throws IOException, IllegalStateException {
        logger.debug("Loading maze file from: " + filePath);
        logger.debug("Maze successfully loaded.");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){

        
        String line;
        //Longest Row
        int maxLength = 0;
        
        
        while ((line = reader.readLine()) != null ){
            if (line.length() > maxLength){
                maxLength = line.length();
            }

        }
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath));
        while ((line = reader2.readLine()) != null) {
            //A list representing the current row of the maze.
            List<CellType> row = new ArrayList<>();
            
            
            for (int i = 0; i < maxLength; i++) {
                if (i < line.length()) {
                    char c = line.charAt(i);
                    if (c == '#') {
                        row.add(CellType.WALL);
                    } else if (c == ' ') {
                        row.add(CellType.PATH);
                    } else {
                        throw new IllegalStateException("Invalid character in maze file: " + c);
            }
        }
            else {
                row.add(CellType.PATH);
            }
        }
            
            maze.add(row);
        }
    }

    if (maze.isEmpty()) {
        throw new IllegalStateException("Maze file is empty or invalid.");
    }
    logger.debug("Maze rows loaded: " + maze.size());

        startPos = startPosFinder();
        endPos = endPosFinder();
        logger.debug("Start Position: " + startPos);
        logger.debug("Eng Position: " + endPos);
    }
    

    
    private Position startPosFinder() throws IllegalStateException {
        for (int y = 0; y < maze.size(); y++) {
            Position pos = new Position(0, y);
            if (isPath(pos)) {
                return pos;
            }
        }
        throw new IllegalStateException("No vaild start position");
    }

    private Position endPosFinder() throws IllegalStateException {
        int lastColumn = maze.get(0).size() - 1;
        for (int y = 0; y < maze.size(); y++) {
            Position pos = new Position(lastColumn, y);
            if (isPath(pos)) {
                return pos;
            }
        }
        throw new IllegalStateException("No vaild end position");
    }

    public Boolean isPath(Position pos) {
        return maze.get(pos.y()).get(pos.x()) == CellType.PATH;
    }

    public Boolean isWall(Position pos){
        return maze.get(pos.y()).get(pos.x()) == CellType.WALL;
    }

    public Position getStartPos(){
        return startPos;
    }

    public Position getEndPos(){
        return endPos;
    }

    public int getSizeX() {
        return this.maze.get(0).size();
    }

    public int getSizeY() {
        return this.maze.size();
    }

}
