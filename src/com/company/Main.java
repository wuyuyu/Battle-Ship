package com.company;

/*
 * Membres du groupe : Ivann, Laurent, Yuyuan, Jérémy.
 *
 * Description   : TP "BATAILLE NAVALE"
 */

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
public class Main {

    /**
     * displayBoard() : Function which displays an empty battlefield (10 rows / 10 columns).
     */
    public static void displayBoard(char board[][], boolean isHidden) {

        String line = " ";
        char letter = 'A';

        // display letters according to the array width
        System.out.print("    ");
        for (int j = 0; j < board[0].length; j = j + 1) {
            System.out.print((char) (letter + j));
            System.out.print(" ");
        }
        System.out.print("\n");

        // display numbers according to the array height
        for (int i = 0; i < board.length; i = i + 1) { // rows
            line = "";
            for (int j = 0; j < board[0].length; j = j + 1) { // columns
                if (board[i][j] == '#' && isHidden == true) {
                    line = line + "~" + " ";
                }
                else {
                    line = line + board[i][j] + " ";
                }
            }
            if (i < 9) {
                System.out.print(" ");
            }
            System.out.print((i + 1) + "  "); // row index
            System.out.println(line);
        }
    }

    /**
     * initBoard() : Function which displays the elements of the battlefield.
     */
    static void initBoard(char board[][]) {

        for (int i = 0; i < board.length; i = i + 1) { // rows
            for (int j = 0; j < board[0].length; j = j + 1) { // columns
                board[i][j] = '~';
            }
        }
        createBoat(5, board);
        createBoat(2, board);
        createBoat(3, board);
        createBoat(3, board);
        createBoat(4, board);
    }

    /**
     * getRandom() : Function which returns a random value between 0 included
     * and 'maxValue' included.
     */
    static int getRandom(int maxValue) {
        return (int) (Math.random() * (maxValue + 1));
    }

    /**
     * createBoat() : Function which creates and displays boats randomly on the battlefield.
     */
    static void createBoat(int N, char board[][]) {

        boolean isShipPossible = true;
        boolean hiddenBoat = true;
        do {
            //ALEA
            int HV = getRandom(1);
            int idxRow = getRandom(9);
            int idxCol = getRandom(9);
            if (HV == 0) {
                idxCol = getRandom(board[0].length - N);
            } else {
                idxRow = getRandom(board.length - N);
            }

            //CHECK
            isShipPossible = true;
            for (int i = 0; i <= N - 1; i = i + 1) {
                if (HV == 0) {//horizontal
                    if (board[idxRow][idxCol + i] == '#') {
                        isShipPossible = false;
                    }
                } else {//vertical
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
                        System.out.print('~');
                    } else {//horizontal
                        board[idxRow + i][idxCol] = '#';
                        System.out.print('~');
                    }
                }
            }
        }
        while (isShipPossible == false);
    }

    /**
     * getInputColIndex(): function that takes a string as a parameter and checks if the first character
     * is between A and J.
     * if it is not the case, it returns -1
     */
    static int getInputColIndex(String s) {
        if (s.length() > 0) {
            char first = s.toLowerCase().charAt(0);
            if (first >= 'a' && first <= 'j') {
                return (first - 'a');
            }
        }
        return -1;
    }

    /**
     * getInputRowIndex(): function that takes a string as a parameter and checks if second and third characters
     * are between '1' and '10'.
     * if it is not the case, it returns -1
     */
    static int getInputRowIndex(String s) {
        if (s.length() > 1) {
            char second = s.toLowerCase().charAt(1);
            if (second >= '1' && second <= '9') {
                if (s.length() > 2) {
                    char third = s.toLowerCase().charAt(2);
                    if (third == '0') {
                        return Integer.parseInt(s.substring(1, 3)) - 1;
                    }
                } else {
                    return (second - '0' - 1);
                }
            }
        }
        return -1;
    }

    /**
     * shoot(): Function witch shoots on the battlefield thanks to the coordinates entered by the player.
     */
    static boolean shoot(int rowIdx, int colIdx, char board[][]) {
        if (board[rowIdx][colIdx] == '#') { // touched
            board[rowIdx][colIdx] = 'x';
            System.out.println("Hit !");
            return true;
        } else if (board[rowIdx][colIdx] == 'x') {//already touched
            System.out.println("You already have hit the target, stupid human !");
            return false;
        } else { //failed
            System.out.println("You suck.");
            board[rowIdx][colIdx] = 'o';
            return false;
        }
    }

    /**
     * turnPlayer(): Function witch defines when the human player can play.
     */
    static boolean turnPlayer(char board[][]) {
        System.out.println("Enter position: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // get column index
        int colIdx = getInputColIndex(input);
        // get row index
        int rowIdx = getInputRowIndex(input);
        if (colIdx != -1 && rowIdx != -1) {
            System.out.print("PLAYER : ");
            return shoot(rowIdx, colIdx, board);
            // Here i got valid position for ROW and COLUMN indexes
        } else {
            // i typed something wrong
            return true;
        }
    }

    /**
     * turnEnemy(): Function witch defines when the "IA" can play.
     */
    static boolean turnEnemy(char board[][]) {
        int colIdx = getRandom(9);
        int rowIdx = getRandom(9);
        System.out.print("CPU : ");
        return shoot(rowIdx, colIdx, board);
    }

    /**
     * scanShip(): Function witch scans all the battlefield and returns the number of remaining boats.
     */
    static int scanShip(char board[][]) {
        int nbship = 0;
        for (int i = 0; i < board.length; i = i + 1) { // rows
            for (int j = 0; j < board[0].length; j = j + 1) { // columns
                if (board[i][j] == '#') {
                    nbship = nbship + 1;
                }
            }
        }
        return nbship;
    }

    /**
     * doYouWantReplay(): Function witch ask the player if he wants to retry or quit .
     */
    static boolean doYouWantReplay(){
        Scanner sc = new Scanner(System.in);

        while( true ) {
            System.out.println("Reload Game ? Y/N ");
            String s = sc.next();
            if (s.length() == 1) {
                if (s.equals("Y") || s.equals("y")) {
                    return true;
                } else if (s.equals("N") || s.equals("n")) {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {

        do {
            System.out.println("**** Welcome to the battleship game ! **** ");
            System.out.println(" ");

            char playerBoard[][] = new char[10][10];
            char enemyBoard[][] = new char[10][10];

            initBoard(enemyBoard);
            initBoard(playerBoard);

            boolean isMyTurn = true;
            boolean gameOver = false;

                while (gameOver == false) {
                    displayBoard(enemyBoard,true);
                    System.out.println(" ");
                    displayBoard(playerBoard,false);

                    if (isMyTurn) {
                        isMyTurn = turnPlayer(enemyBoard);
                        if (isMyTurn) {
                            if (scanShip(enemyBoard) == 0) {
                                gameOver = true;
                            }
                        }

                    } else {
                        isMyTurn = turnEnemy(playerBoard);
                        if (isMyTurn) {
                            if (scanShip(playerBoard) == 0) {
                                gameOver = true;
                            }
                            isMyTurn = false;
                        } else {
                            isMyTurn = true;
                        }

                    }
                }
                System.out.println("game over");
                System.out.println(" ");
                if (scanShip(enemyBoard) == 0) {
                    System.out.println("player win!!!");
                } else {
                    System.out.println("cpu Win!!");
                }

        } while( doYouWantReplay() == true);

        System.out.println("See you soon for the next Battleship !");
    }
}
