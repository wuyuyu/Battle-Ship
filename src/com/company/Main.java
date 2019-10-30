package com.company;

/*
 * Membres du groupe : Ivann, Laurent, Yuyuan, Jérémy.
 *
 * Description   : TP "BATAILLE NAVALE"
 */

import java.util.Random;
public class Main {

    /**
     * displayBoard() : Function which displays an empty battlefield (10 rows / 10 columns).
     */
    public static void displayBoard(char board[][]) {

        String line = " ";
        char letter = 'A';

        // display letters according to the array width
        System.out.print("    ");
        for(int j=0;j<board[0].length;j=j+1){
            System.out.print( (char)(letter+j) );
            System.out.print(" ");
        }
        System.out.print("\n");

        // display numbers according to the array height
        for (int i = 0; i < board.length; i = i + 1) { // rows
            line = "";
            for (int j = 0; j < board[0].length; j = j + 1) { // columns
                line = line + board[i][j] + " ";
            }
            if(i<9){
                System.out.print(" ");
            }
            System.out.print( (i+1) +"  "); // row index
            System.out.println(line);
        }
    }

    /**
     * initBoard() : Function which displays the elements of the battlefield.
     */
    static void initBoard (char board[][]) {

        for (int i = 0; i < board.length; i = i + 1) { // rows
            for (int j = 0; j < board[0].length; j = j + 1) { // columns
                board[i][j] = '~';
            }
        }
        createBoat(5,board);
        createBoat(2,board);
        createBoat(3,board);
        createBoat(3,board);
        createBoat(4,board);
    }

    /**
<<<<<<< HEAD
     * getRandom() : Function which returns a random value between 0 included
=======
     * createBoat() : Function which returns a random value between 0 included
>>>>>>> master
     * and 'maxValue' included.
     */
    static int getRandom(int maxValue){
        return (int)( Math.random()*(maxValue+1) );
    }

    /**
     * createBoat() : Function which creates and displays boats randomly on the battlefield.
     */
    static void createBoat (int N,char board[][]){

        boolean isShipPossible = true;

        do {
            //ALEA
            int HV = getRandom(1);
            int idxRow = getRandom(9);
            int idxCol= getRandom(9);
            if (HV == 0) {
                idxCol = getRandom(board[0].length - N);
            } else {
                idxRow = getRandom(board.length - N);
            }

            //CHECK
            isShipPossible = true;
            for (int i = 0; i <= N - 1; i = i + 1) {
                if (HV == 0) {//vertical
                    if (board[idxRow][idxCol + i] == '#') {
                        isShipPossible = false;
                    }
                } else {//horizontal
                    if (board[idxRow + i][idxCol] == '#') {
                        isShipPossible = false;
                    }
                }
            }

            // CREATION
            if (isShipPossible == true) {

                for (int i = 0; i <= N - 1; i = i + 1) {
                    if (HV == 0) {//vertical
                        board[idxRow][idxCol + i] = '#';
                    } else {//horizontal
                        board[idxRow + i][idxCol] = '#';
                    }
                }
            }
        }
            while (isShipPossible == false);
    }

    public static void main(String[] args) {

        System.out.println("**** Welcome to the battleship game ! **** ");
        System.out.println(" ");

        char playerBoard [][] = new char[10][10] ;

        initBoard(playerBoard);
        displayBoard(playerBoard);
    }
}