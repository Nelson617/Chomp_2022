import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

        int row = 3;
        int col = 3;
        int array[][] = new int [row][col];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        //fill columns array with 0's
        for (int i = 0; i  < columns.length; i++);{
            for (int w = 0; w < columns.length; w++);{



            }

        }
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */
        System.out.println("My player clicked " );

        Point myMove = new Point(row, column);
        return myMove;
    }

}
// add code to fill in the columns array
//so that it represents the gameboard in number form
//print columns array to show its working
