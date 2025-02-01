package ca.mcmaster.se2aa4.mazerunner;

public record Position (int x, int y) {

    public Position add(Position other) {
        return new Position(this.x + other.x, this.y + other.y);
    }
    public Position move(Direction direction) {
        return switch (direction) {
            case NORTH -> new Position(x, y - 1); // Move up (decrease y)
            case SOUTH -> new Position(x, y + 1); // Move down (increase y)
            case EAST  -> new Position(x + 1, y); // Move right (increase x)
            case WEST  -> new Position(x - 1, y); // Move left (decrease x)
        };
    }

    
}
