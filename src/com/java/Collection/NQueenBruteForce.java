package com.java.Collection;

import java.util.*;

public class NQueenBruteForce {

    static List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        doDFS(0, board, result);
        return result;
    }

    private static boolean isValidate(int row, int col, char[][] board){
        int rowDup = row;
        int colDup = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row --;
            col --;
        }
        row = rowDup;
        col = colDup;

        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col --;
        }

        row = rowDup;
        col = colDup;

        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q') return false;
            row ++;
            col --;
        }

        return true;
    }

    private static List<String> construct(char[][] board){
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    static void doDFS(int col, char[][] board, List<List<String>> result){

        if(col == board.length){
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isValidate(row, col, board)){
                board[row][col] = 'Q';
                doDFS(col+1, board, result);
                board[row][col] = '.';
            }
        }


    }

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queens = solveNQueens(N);
        int i = 1;
        for(List<String> it: queens){
            System.out.println("Arrangement :: "+i);
            for(String s: it){
                System.out.println(s);
            }
            System.out.println();
            i+=1;
        }

    }
}
