package ca.mcmaster.se2aa4.mazerunner;


/**
     * Interface for the mazesolver
     * Make the code able to add new algorithm
     * @param maze
     * @return Path from start position to end position
     */
public interface MazeSolver {
    Path solve(Maze maze);
}