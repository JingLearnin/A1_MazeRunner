package ca.mcmaster.se2aa4.mazerunner;




import java.util.ArrayList;
import java.util.List;

public class Path {

    private final List<Character> moves;

    public Path() {
        this.moves = new ArrayList<>();
    }

    public Path(List<Character> moves) {
        this.moves = new ArrayList<>(moves);
    }


    public void add(char move) {
        if (move != 'F' && move != 'L' && move != 'R') {
            throw new IllegalArgumentException("Invalid move: " + move);
        }
        moves.add(move);
    }


    public String getCanonicalForm() {
        StringBuilder canonical = new StringBuilder();
        for (char move : moves) {
            canonical.append(move);
        }
        return canonical.toString();
    }


    public String getFactorizedForm() {
        StringBuilder factorized = new StringBuilder();
        int count = 1;

        for (int i = 0; i < moves.size(); i++) {
            if (i < moves.size() - 1 && moves.get(i) == moves.get(i + 1)) {
                count++;
            } else {
                if (count > 1) {
                    factorized.append(count); // Append the count first
                }
                factorized.append(moves.get(i)); // Append the move character
                if (i < moves.size() - 1) {
                    factorized.append(' '); // Add a space between moves
                }
                count = 1;
            }
        }

        return factorized.toString();
    }

    @Override
    public String toString() {
        return getCanonicalForm();
    }
}
