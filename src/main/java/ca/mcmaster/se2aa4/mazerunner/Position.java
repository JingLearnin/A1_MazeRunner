package ca.mcmaster.se2aa4.mazerunner;

public record Position (int x, int y) {
    public Position move(Direction direction){
        switch (direction){
            case UP ->{
                return Position (0,1)
            }
        }
    }
    
}
