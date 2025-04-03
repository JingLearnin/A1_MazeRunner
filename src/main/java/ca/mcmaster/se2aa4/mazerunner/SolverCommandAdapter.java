package ca.mcmaster.se2aa4.mazerunner;

public class SolverCommandAdapter implements MazeSolverCommand {
    private final MazeSolver solver;

    public SolverCommandAdapter(MazeSolver solver){
        this.solver = solver;
    }

    @Override
    public Path execute(Maze maze) {
        return solver.solve(maze);
    }
    
}
