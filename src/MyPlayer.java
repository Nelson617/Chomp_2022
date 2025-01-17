import java.awt.*;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public int nLosers = 0;
    public int nWinners = 0;
    public Board[] losingBoards = new Board[10];
    public Board[] winningBoards = new Board[20];

    public MyPlayer() {
        columns = new int[10];

        int row = 3;
        int col = 3;
        int array[][] = new int[row][col];

        Board b = new Board(1, 0, 0, 0, 0);
        losingBoards[0] = new Board(1, 0, 0, 0, 0);
        nLosers++;
//        winningBoards[0] = new Board(1, 1, 0, 0, 1);

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        Print3x3boards();

        //fill columns array with 0's
        for (int i = 0; i < columns.length; i++) ;
        {
            for (int w = 0; w < columns.length; w++) ;
            {


            }

        }
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("My Player Move");


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
        System.out.println("My player clicked ");

        for (int c = 0; c < columns.length; c++) {
            int count = 0;
            for (int r = 0; r < gameBoard.length; r++) {
                if (gameBoard[r][c].isAlive == true) {
                    count++;
                }
            }
            columns[c] = count;
        }

        System.out.println(Arrays.toString(columns));

        // loop through your winning boards
        // if you find that winningBoards[i] cols has the same 3 numbers as columns[0], columns[1], columns[2]
        // then row = winningBoards[i].winRow and column = winningBoards[i].winCol

        Point myMove = new Point(row, column);

//        if (columns[0] == 3 && columns[1] == 3 && columns[2] == 0) {
//            myMove = new Point(2, 1);
//        }

        return myMove;

    }

    public void Print3x3boards() {
        //using 1 or more for a loop, print all possiable 3x3 or smaller board states
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (i >= j && j >= k) {
//                        System.out.println(i + " " + j + " " + k);
                        oneMove(i, j, k);
                    }
                }
            }
            System.out.println();


        }
    }

    public void oneMove(int i, int j, int k) {

        boolean isWinningBoard = false;
        int r = 0;
        int c = 0;

        System.out.println();

        System.out.println("Boards that are one move away:");

        System.out.println("Next Board");

        System.out.println("Board: " + i + " " + j + " " + k);

        System.out.println();

        System.out.println("Third column");

        if (k > 0) {
            // print coordiantes
            for (int x = k - 1; x >= 0; x--) {
                System.out.println(i + " " + j + " " + x + " Move: (" + x + ", " + 2 + ")");
                for(int l = 0; l < nLosers; l++) { // loops thru losing boards
                    if (i == losingBoards[l].cols[0] && j == losingBoards[l].cols[1] && x == losingBoards[l].cols[2]) {
                        isWinningBoard = true;
                        r = x;
                        c = 2;
                        System.out.println("LOSING BOARD");
                    }
                }
            }
        }


        System.out.println();
        System.out.println("Second column");

//        System.out.println(i + " " + j + " " + k);
        if (j > 0) {
            for (int c = j - 1; c >= 0; c--) {
                if (c < k) {
                    System.out.println(i + " " + c + " " + c + " Move: (" + c + ", " + 1 + ")");
                    for (int l = 0; l < nLosers; l++) { // loops thru losing boards
                        if (i == losingBoards[l].cols[0] && c == losingBoards[l].cols[1] && c == losingBoards[l].cols[2]) {
                            isWinningBoard = true;
                            System.out.println("LOSING BOARD");
                        }
                    }
                } else {
                    System.out.println(i + " " + c + " " + k + " Move: (" + c + ", " + 1 + ")");
                    for (int l = 0; l < nLosers; l++) { // loops thru losing boards
                        if (i == losingBoards[l].cols[0] && c == losingBoards[l].cols[1] && k == losingBoards[l].cols[2]) {
                            isWinningBoard = true;
                            System.out.println("LOSING BOARD");
                        }
                    }
                }
            }
        }

            System.out.println();
            System.out.println("First column");

//        System.out.println(i + " " + j + " " + k);
            if (i >= 2) {
                for (int v = i - 1; v >= 1; v--) { // v = 1
                    if (v < j) {
                        System.out.println(v + " " + v + " " + v + " Move: (" + v + ", " + 0 + ")");
                        for(int l = 0; l < nLosers; l++) { // loops thru losing boards
                            if (v == losingBoards[l].cols[0] && v == losingBoards[l].cols[1] && v == losingBoards[l].cols[2]) {
                                isWinningBoard = true;
                                System.out.println("LOSING BOARD");
                            }
                        }
                    }
                    else {
                        System.out.println(v + " " + j + " " + k + " Move: (" + v + ", " + 0 + ")");
                        for(int l = 0; l < nLosers; l++) { // loops thru losing boards
                            if (v == losingBoards[l].cols[0] && j == losingBoards[l].cols[1] && k == losingBoards[l].cols[2]) {
                                isWinningBoard = true;
                                System.out.println("LOSING BOARD");
                            }
                        }

                    }
                }
            }

            // was one of those one move away boards a loser?
            // if yes, add (i,j,k, row, col) to winningBoards
            // otherwise, add to losingBoards
            if (isWinningBoard == true) {
                winningBoards[nWinners] = new Board(i,j,k, r,c);
            } else {

            }
        }
    }



