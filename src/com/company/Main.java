package com.company;

/*
 * Membres du groupe : Ivann, Laurent, Yuyuan, Jérémy.
 *
 * Description   : TP "BATAILLE NAVALE"
 */

import java.util.Random;
import java.util.Scanner;
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
     * getRandom() : Function which returns a random value between 0 included
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
                    } else {//horizontal
                        board[idxRow + i][idxCol] = '#';
                    }
                }
            }
        }
            while (isShipPossible == false);
    }

    /**
     * function that takes a string as a parameter and checks if the first character
     * is between A and J.
     * if it is not the case, it returns -1
     */
        static int getInputColIndex(String s){
            if(s.length() > 0){
                char first = s.toLowerCase().charAt(0);
            if(first >= 'a' && first <= 'j') {
                return (first-'a');
            }
        }
        return -1;
        }

    /**
     *function that takes a string as a parameter and checks if second and third characters
     * are between '1' and '10'.
     *if it is not the case, it returns -1
     */
    static int getInputRowIndex(String s){
        if(s.length() > 1){
            char second = s.toLowerCase().charAt(1);
            if(second >= '1' && second <= '9') {
                if(s.length() > 2) {
                    char third = s.toLowerCase().charAt(2);
                    if (third == '0') {
                        return Integer.parseInt(s.substring(1, 2))-1;
                    }
                }
                else{
                    return (second-'0'-1);
                }
            }
        }
        return -1;
    }

    static boolean shoot(int rowIdx, int colIdx, char board[][]) {
        if (board[rowIdx][colIdx] == '#') { // touched
            board[rowIdx][colIdx] = 'x';
            System.out.println("Touché !");
            return true;
        } else if (board[rowIdx][colIdx] == 'x') {//already touched
            System.out.println("Vous avez déjà touché cette cible !");
            return false;
        } else { //failed
            System.out.println("Vous n'avez pas atteint votre cible.");
            board[rowIdx][colIdx] = 'o';
            return false;
        }
    }

    static boolean turnPlayer(char board[][]) {
        System.out.println("Entrez des coordonnées : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // get column index
        int colIdx = getInputColIndex(input);
        // get row index
        int rowIdx = getInputRowIndex(input);
        if(colIdx != -1 && rowIdx != -1){
            System.out.print("PLAYER : ");
            return shoot(rowIdx, colIdx, board);
            // Here i got valid position for ROW and COLUMN indexes
        }
        else{
            // i typed something wrong
            return true;
        }
    }

    static boolean turnEnemy(char board[][]) {
        int colIdx = getRandom(9);
        int rowIdx = getRandom(9);
        System.out.print("CPU : ");
        return shoot(rowIdx, colIdx, board);
    }

    public static void main(String[] args) {

        System.out.println("**** Welcome to the battleship game ! **** ");
        System.out.println(" ");

        char playerBoard [][] = new char[10][10] ;
        char enemyBoard [][] = new char[10][10];

        initBoard(enemyBoard);
        initBoard(playerBoard);

        // game loop
        while( true ){
            displayBoard(enemyBoard);
            displayBoard(playerBoard);

            /*if(      ) {
                // recup retour de turnplayer
                // si c false, alors ca l'ordi de jouer : modif du booleen cestmontour
                turnPlayer(enemyBoard);
            }
            else{
                // recjup retour de turnenemey
                // si c false alors c a moi de jouer : modif la valeur du booleen
                turnEnemy(playerBoard);
            }*/
        }

    }
}