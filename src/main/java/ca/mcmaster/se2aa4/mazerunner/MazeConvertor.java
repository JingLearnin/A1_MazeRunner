package ca.mcmaster.se2aa4.mazerunner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Covert Maze to 2D Arrary
 * 
 */


public class MazeConvertor {
    
    public char[][] mazeArray (String fileLoc){
        int height = getHeight(fileLoc);
        int width = getWidth(fileLoc);

        char [][] array = new char [height][width];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileLoc))){
            String line;
            int row = 0;
            while ((line = reader.readLine())!= null) {
                for (int column = 0; column < width; column++) {
                    char currentChar = line.charAt(column);
                array[row][column] = currentChar;
                }
                row++;
            }

        }
        catch(IOException e){

        }

        return array;
    }


    private int getHeight(String fileLoc){
        int height = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLoc))) {
            while (reader.readLine() != null) height++;
        } catch (IOException e) {
        }
        return height;
    }


    private int getWidth(String fileLoc){
        int width = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLoc))){
            width = reader.readLine().length();
        }
        catch (IOException e) {
        }
        return width;
    }
}
