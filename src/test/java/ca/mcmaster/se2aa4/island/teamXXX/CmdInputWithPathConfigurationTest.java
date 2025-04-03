package ca.mcmaster.se2aa4.island.teamXXX;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.Configuration;

public class CmdInputWithPathConfigurationTest {
    @Test
    void validConfigurationWithInputAndPath() throws ParseException {
        String[] args = {"-i", "maze.txt", "-p", "NSEW"};
        Configuration config = new Configuration(args);
        assertEquals("maze.txt", config.getMazeFile());
        assertTrue(config.hasPathOption());
        assertEquals("NSEW", config.getPath());
    }

    @Test
    void missingRequiredInputFlag() {
        String[] args = {"-p", "NSEW"};
        assertThrows(ParseException.class, () -> new Configuration(args));
    }
}