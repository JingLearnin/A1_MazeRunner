package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    
    private static final Logger logger = LogManager.getLogger();
    private final List<List<Boolean>> maze = new ArrayList<>();

    private final Position startPos;
    private final Position endPos;

    public Maze(String filePath) throws Exception {
        logger.debug("Loading maze file from: " + filePath);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String blocks;
        
        while ((blocks = reader.readLine()) != null) {
            //A list representing the current row of the maze.
            List<Boolean> arrayblock = new ArrayList<>();
            
            
            for (int i = 0; i < blocks.length(); i++) {
                
                if (blocks.charAt(i) == '#') {
                    arrayblock.add(true);

                } else if (blocks.charAt(i) == ' ') {
                    arrayblock.add(false);
                }
            }
            maze.add(arrayblock);
        }
        startPos = startPosFinder();
        endPos = endPosFinder();
    }

    
    private Position startPosFinder() throws Exception {
        for (int i = 0; i < maze.size(); i++) {
            Position pos = new Position(0, i);
            if (isPath(pos) && !isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("No vaild start position");
    }

    private Position endPosFinder() throws Exception {
        int lastColumn = maze.getFirst().size() - 1;
        for (int i = 0; i < maze.size(); i++) {
            Position pos = new Position(lastColumn, i);
            if (isPath(pos) && !isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("No vaild end position");
    }

    public Boolean isPath(Position pos) {
        return !maze.get(pos.y()).get(pos.x());
    }

    public Boolean isWall(Position pos){
        return maze.get(pos.y()).get(pos.x());
    }

    public Position getStartPos(){
        return startPos;
    }

    public Position getEndPos(){
        return endPos;
    }

    public int getSizeX() {
        return this.maze.getFirst().size();
    }

    public int getSizeY() {
        return this.maze.size();
    }

}
