package ca.mcmaster.se2aa4.mazerunner;

public class SolverCommandFactory {
    public static MazeSolver createCommand(String algorithm) {
        return switch (algorithm.toLowerCase()) {
            case "righthand" -> new RightHandMethod();
            default -> new RightHandMethod();
        };
    }
}

