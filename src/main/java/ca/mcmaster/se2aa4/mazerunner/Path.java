package ca.mcmaster.se2aa4.mazerunner;




import java.util.ArrayList;
import java.util.List;

public class Path {

    private final List<Character> moves= new ArrayList<>();



    public Path() {

    }

    public Path(String pathString) {
        String inputStr = expandFactorizedPath(pathString);
        for (Character c : inputStr.toCharArray()) {
            if (c != ' ') {
                this.add(c);
            }
        }

    }

    private String expandFactorizedPath(String path) {
        StringBuilder expanded = new StringBuilder();
        int i = 0;

        while(i < path.length()) {
            char current = path.charAt(i);

            if(Character.isDigit(current)) {
                // Build number
                int num = 0;
                while(i < path.length() && Character.isDigit(path.charAt(i))) {
                    num = num * 10 + (path.charAt(i) - '0');
                    i++;
                }
                // Get following character
                char move = path.charAt(i);
                expanded.append(String.valueOf(move).repeat(num));
            } else {
                expanded.append(current);
            }
            i++;
        }

        return expanded.toString();
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


    public List<Character> getMoves() {
        return new ArrayList<>(this.moves);
    }

    @Override
    public String toString() {
        return getCanonicalForm();
    }
}
