package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the battle ship");

        String line = " ";
        String column = " ";

        char tab[][] = new char[10][10];
        for (int i = 0; i < 10; i = i + 1) {
            line = line + tab[0][i];
            for (int j = 0; j < 10; j = j + 1) {
                column = column + tab[i][j];
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
}