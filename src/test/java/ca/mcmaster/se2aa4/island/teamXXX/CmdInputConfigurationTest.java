package ca.mcmaster.se2aa4.island.teamXXX;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Configuration;

import static org.junit.jupiter.api.Assertions.*;

public class CmdInputConfigurationTest {

    @Test
    void validConfigurationWithInputOnly() throws ParseException {
        String[] args = {"-i", "maze.txt"};
        Configuration config = new Configuration(args);
        assertEquals("maze.txt", config.getMazeFile());
        assertFalse(config.hasPathOption());
    }



    @Test
    void emptyArgs() {
        String[] args = {};
        assertThrows(ParseException.class, () -> new Configuration(args));
    }

    @Test
    void invalidFlag() {
        String[] args = {"-x", "invalid.txt", "-i", "maze.txt"};
        assertThrows(ParseException.class, () -> new Configuration(args));
    }
}
