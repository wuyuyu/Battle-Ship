package com.company;

/*
 * Membres du groupe : Ivann, Laurent, Yuyuan.
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
        System.out.print("    "); // column index
        for(int j=0;j<board[0].length;j=j+1){
            System.out.print( (char)(letter+j) );
            System.out.print(" ");
        }
        System.out.print("\n");

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

    // returns a    random value between 0 included and 'maxValue' included
    static int getRandom(int maxValue){
        return (int)( Math.random()*(maxValue+1) );
    }

    static void createBoat (int N,char board[][]){
        // une valeur aleatoire pour l'orientation (H / V)
        // idxCol generer une valeur aleatoire pour la position colonne   idxCol = getRandom(9);
        // idxRow une aleatoire pour la ligne

        // on boucle sur la taille du bateau (variable i de 0 a N-1 inclu)
        // on va ecrire le caractere # pour chaque case du bateau ( board[idxRow][idxCol+i] = '#'; ) // Horizontal
        // on va ecrire le caractere # pour chaque case du bateau ( board[idxRow+i][idxCol] = '#'; ) // Vertical


// encadrer le code par un while(shipExisting == true)

        int HV = getRandom(1);
        int idxRow = getRandom(9);
        int idxCol = getRandom(9);
        if (HV==0) {
            idxCol = getRandom(board[0].length-N);
        }
        else{
            idxRow = getRandom(board.length-N);
        }

        // boucle sur les cases du bateau 
        // si deja une case # alors on met un booleen "shipExisting" a true


        // encadrer ce code par if(shipExisting == false)
        int i;
        for(i=0;i<=N-1;i=i+1){
            if(HV==0){
                board[idxRow][idxCol+i] = '#';
            }
            else{
                board[idxRow+i][idxCol] = '#';
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("**** Welcome to the battleship game ! **** ");
        System.out.println(" ");

        char playerBoard [][] = new char[10][10] ;



        initBoard(playerBoard);
        displayBoard(playerBoard);


    }
}