package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
    
    public Direction turnRight() {
        switch (this) {
            case UP -> {return RIGHT;}
            case DOWN -> {return LEFT;}
            case LEFT -> {return UP;}
            case RIGHT -> {return DOWN;} 
        }
        throw new IllegalStateException();
    }

     public Direction turnLeft() {
        switch (this) {
            case UP -> {return LEFT;}
            case DOWN -> {return RIGHT;}
            case LEFT -> {return DOWN;}
            case RIGHT -> {return UP;}
        }
        throw new IllegalStateException();
    }

    public Direction uTurn() {
        switch (this) {
            case UP -> {return DOWN;}
            case DOWN -> {return UP;}
            case LEFT -> {return RIGHT;}
            case RIGHT -> {return LEFT;}
        }
        throw new IllegalStateException();
    }


}
