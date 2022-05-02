package com.java.Collection;

import java.util.*;

public class NquuensOptimisedUsingHash {

    static List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        int[] left = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];
        doDFS(0, board, left, lowerDiagonal, upperDiagonal, result );
        return result;
    }

    private static List<String> construct(char[][] board){
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    static void doDFS(int col, char[][] board, int[] left, int[] lowerDiagonal, int[] upperDiagonal, List<List<String>> result){
        if(col == board.length){
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row ++){
            if(left[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[(board.length-1) + (col - row)] == 0){
                board[row][col] = 'Q';
                left[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[(board.length-1)+(col-row)] = 1;
                doDFS(col+1, board, left, lowerDiagonal, upperDiagonal, result);
                board[row][col] = '.';
                left[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[(board.length-1)+(col-row)] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queens = solveNQueens(N);
        int i = 1;
        for(List<String> it: queens){
            System.out.println("Arrangement :: "+ i);
            for(String s : it){
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }
}









