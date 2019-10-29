package com.company;

/*
 * Membres du groupe : Ivann, Laurent, Yuyuan.
 *
 * Description   : TP "BATAILLE NAVALE"
 */

public class Main {

    /**
     * initBoard() : Function which displays an empty battlefield (10 rows / 10 columns).
     */
    public static void initBoard(char board[][]) {

        String line = " ";
        System.out.println("   A B C D E F G H I J"); // column index
        for (int i = 0; i < board.length; i = i + 1) { // rows
            line = "";
            for (int j = 0; j < board.length; j = j + 1) { // columns
                line = line + board[i][j] + " ";
            }
            System.out.print(i +"  "); // row index
            System.out.println(line);
        }
    }

    /**
     * displayBoard() : Function which displays the elements of the battlefield.
     */
    static void displayBoard (char board[][]) {

        for (int i = 0; i < board.length; i = i + 1) { // rows
            for (int j = 0; j < board.length; j = j + 1) { // columns
                board[i][j] = '~';
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("**** Welcome to the battleship game ! **** ");
        System.out.println(" ");

        char playerBoard [][] = new char[10][10] ;
        char cpuBoard [][] = new char[10][10] ;

        displayBoard(playerBoard);
        initBoard(playerBoard);
        System.out.println(" ");
        displayBoard(cpuBoard);
        initBoard(playerBoard);

    }
}