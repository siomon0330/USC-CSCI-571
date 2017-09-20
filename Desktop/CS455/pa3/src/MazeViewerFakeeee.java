// Name:Chuanli Wei
// USC loginid:6222006323
// CS 455 PA3
// Spring 2017


import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.*;
import java.io.File;

/**
 * MazeViewer class
 *
 * Program to read in and display a maze and a path through the maze. At user
 * command displays a path through the maze if there is one.
 *
 * How to call it from the command line:
 *
 *      java MazeViewer mazeFile
 *
 * where mazeFile is a text file of the maze. The format is the number of rows
 * and number of columns, followed by one line per row, followed by the start location,
 * and ending with the exit location. Each maze location is
 * either a wall (1) or free (0). Here is an example of contents of a file for
 * a 3x4 maze, with start location as the top left, and exit location as the bottom right
 * (we count locations from 0, similar to Java arrays):
 *
 * 3 4
 * 0111
 * 0000
 * 1110
 * 0 0
 * 2 3
 *
 */

public class MazeViewerFakeeee {

    private static final char WALL_CHAR = '1';
    private static final char FREE_CHAR = '0';

    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in);

        String fileName = in.next();

        try {

                JFrame frame = readMazeFile(fileName);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);
            }


        catch (FileNotFoundException exc) {
            System.out.println("File not found: " + fileName);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    /**
     readMazeFile reads in maze from the file whose name is given and
     returns a MazeFrame created from it.

     @param fileName
     the name of a file to read from (file format shown in class comments, above)
     @returns a MazeFrame containing the data from the file.

     @throws FileNotFoundException
     if there's no such file (subclass of IOException)
     @throws IOException
     (hook given in case you want to do more error-checking --
     that would also involve changing main to catch other exceptions)
     */
    private static MazeFrame readMazeFile(String fileName) throws IOException {


        File newfile = new File(fileName);
        Scanner in = new Scanner(newfile);

        int mazeRow = in.nextInt();
        int mazeCol = in.nextInt();
        boolean[][] mazeData = new boolean[mazeRow][mazeCol];
        for(int i = 0; i < mazeRow; i++) {

            String maze = in.next();
            for(int j = 0; j < mazeCol; j++) {

                if (maze.charAt(j) == '1') {
                    mazeData[i][j] = true;
                } else {
                    mazeData[i][j] = false;
                }
            }

        }

        int entryLocRow = in.nextInt();
        int entryLocCol = in.nextInt();
        int exitLocRow = in.nextInt();
        int exitLocCol = in.nextInt();

        MazeCoord entryLoc = new MazeCoord(entryLocRow, entryLocCol);
        MazeCoord exitLoc = new MazeCoord(exitLocRow, exitLocCol);

        return new MazeFrame(mazeData, entryLoc, exitLoc);

    }

}

