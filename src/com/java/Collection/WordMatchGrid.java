package com.java.Collection;

public class WordMatchGrid
{

    public static boolean doCheckAllDirWord(char[][] grid, String word, int row, int col, int pos, int x, int y) {
        int length = word.length();
        //base case//
        if(pos == length) return true;

        if(x < 0 || y < 0 || x >= row || y >= col) return false;

         if(grid[x][y] == word.charAt(pos)){
             char visitedVal = grid[x][y];
             grid[x][y] = '#';
             boolean traversalCheck =  doCheckAllDirWord(grid, word, row, col, pos + 1, x-1, y) |
                     doCheckAllDirWord(grid, word, row, col, pos + 1, x+1, y) |
                     doCheckAllDirWord(grid, word, row, col, pos + 1, x, y-1) |
             doCheckAllDirWord(grid, word, row, col, pos + 1, x, y+1);

             grid[x][y] = visitedVal;
             return traversalCheck;
         }else{
             return false;
         }

    }
    public static boolean doWordMatch(char[][] matrix, String word, int row, int col){
        int matLen = matrix.length;
        //base case//
        if(matLen > row * col) return false;

        for(int i=0; i < row; i++){
            for(int j=0; j < col;j++){
                if(matrix[i][j] == word.charAt(0)){
                    if(doCheckAllDirWord(matrix, word, row, col, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        char[][] wordMatrix = {
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray()
        };

        String input = "BFSAB";

        if(doWordMatch(wordMatrix, input, 3, 4)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
