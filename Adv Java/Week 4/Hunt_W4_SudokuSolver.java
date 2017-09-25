/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 4 
 * Due: 09/24/17
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Hunt_W4_SudokuSolver {

    static int puzzle[][] = new int[9][9];

    public static void main(String[] args) {
        System.out.println("\n~~~~~~~~~~~~ Sudoku Solver Program - Advanced Java Week 4 ~~~~~~~~~~~~\n");

        String fileName = "";
        if (args.length == 1) {
            fileName = args[0];
        } else if (args.length == 0) {
            System.out.print("Please enter the file path: ");
            Scanner sc = new Scanner(System.in);
            fileName = sc.nextLine();
        } else {
            System.out.println("There was a problem processing your file");
            System.exit(0);
        }

        System.out.println("Attempting to open file " + fileName + "...");
        System.out.println();

        try {
            //Read in from file
            Scanner sc = new Scanner(new File(fileName));
            for (int row = 0; row < 9; ++row) {

                //Test file has '*' 
                for (int col = 0; col < 9; ++col) {
                    String value = sc.next();
                    if (value.equals("*"))
                        puzzle[row][col] = 0;
                    else
                        puzzle[row][col] = value.charAt(0) - '0';
                }
            }

            // File not Found Exception
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            System.exit(0);
        }

        // Prints initial puzzle
        System.out.println("This is your unsolved puzzle");
        System.out.println("-----------------");
        printPuzzle(puzzle);
        System.out.println();

        //Attempt to solve puzzle
        int solved[][] = solvePuzzle(0, 0, puzzle);

        //Check if is correctly solved
        boolean isSolved = isSolvedPuzzle(solved);

        if(isSolved){
            System.out.println("This is your solved puzzle");
            System.out.println("-----------------");
            printPuzzle(solved);
        }else{
            System.out.print("This puzzle is having issues.....");
            System.out.println("and/or is unsolvable! \n\tSorry, Try again some other time!");
        }

    }

    public static int [][] solvePuzzle(int x, int y, int[][] puzzle)
    {//Contract 
        //  @notes:     accepts the puzzle then solves it
        //  @params     int x, the horz coordinate
        //  @params     int y, the vert coordinate
        //  @params     char[][] array, the puzzle
        //  @return     int [][] array

        while (!isValidPuzzle(puzzle) && puzzle[8][8] == 0) // While puzzle not solved
        {
            if (puzzle[y][x] < 9){
                puzzle[y][x]++;
                if (isValidPuzzle(puzzle)) {
                    int Yy, Xx;
                    if (x == 8) {
                        Yy = y + 1;
                        Xx = 0;
                    } else {
                        Yy = y;
                        Xx = x + 1;
                    }

                    //Recursive call to solvePuzzle
                    solvePuzzle(Yy, Xx, puzzle);
                }
            } else {
                puzzle[y][x] = 0;
                break;
            }
        }
        return puzzle;
    }

    public static boolean isCompletePuzzle(int[][] t)
    {//Contract 
        //  @notes:     accepts the puzzle then check if complete
        //  @params     char[][] array, the puzzle
        //  @return     boolean
        boolean result = true;
        out:
        for (int r = 0; r < t.length; ++r) {
            for (int c = 0; c < t[r].length; ++c) {
                if (t[r][c] == 0) {
                    result = false;
                    break out;
                }
            }
        }
        return result;
    }

    public static boolean isValidPuzzle(int [][] table)
    {//Contract 
        //  @notes:     accepts the puzzle then check if is valid
        //  @params     char[][] array, the puzzle
        //  @return     boolean

        boolean result = false;

        while(!isCompletePuzzle(table)) {
            try {
                solve(0,0);
            }
            catch (Exception e) {}

            if(isCompletePuzzle(table)) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isSolvedPuzzle(int [][] game)
    {//Contract 
        //  @notes:     accepts the game then checks if it valid
        //  @params     char[][] array, the game
        //  @return     void
        
        try{ //Loop thru all value in game
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){

                    //Check rows
                    for(int col = 0; col < 9; col++){
                        if(col != j && game[i][col] == game[i][j]){
                            return false;
                        }
                    }

                    //Check columns
                    for(int row = 0; row < 9; row++){
                        if(row != i && game[row][j] == game[i][j]){
                            return false;
                        }
                    }

                    //Check grids
                    for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++){
                        for(int col = (j / 3) *3; col < (j / 3) * 3 + 3 ; col++){
                            if(row != i && col != j && game[row][col] == game[i][j]){
                                return false;
                            }
                        }   
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Game error: \n\t" + e.getMessage());
            System.out.println("Stack Trace: \n\t" + e.getStackTrace());
            return false;
        }

        //Return true if game is valid
        return true;
    }

    public static void solve(int row, int col) 
    {//Contract 
        //  @notes:     accepts the row & col index then check if is solved
        //  @params     int row, index value
        //  @params     int col, index value
        //  @return     boolean

        // if(row > 8){
        //     //System.out.println("The sudoku puzzle has been solved!");
        //     //printPuzzle(puzzle);
        //     System.out.println();
        // }

        if(puzzle[row][col] != 0) {
            next(row,col);
        }
        else {
            for(int num = 1; num < 10; num++) {
                if(rowCheck(row,num) && colCheck(col,num) && boxCheck(row,col,num)) {
                    puzzle[row][col] = num;
                    next(row,col);
                }
            }
            puzzle[row][col] = 0;
        }
    }

    public static boolean rowCheck(int row, int num) 
    {//Contract 
        //  @notes:     accepts the row  index then checks num in row
        //  @params     int row, index value
        //  @params     int num
        //  @return     boolean

        for(int col = 0; col < 9; col++) {

            if(puzzle[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean colCheck(int col, int num)
    {//Contract 
        //  @notes:     accepts the col index then checks num in col
        //  @params     int col, index value
        //  @params     int num, value
        //  @return     boolean

        for(int row = 0; row < 9; row++) {
            if(puzzle[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean boxCheck(int row, int col, int num) 
    {//Contract 
        //  @notes:     accepts the row,col, num index then checks num in box
        //  @params     int col, index value to check
        //  @params     int num, value
        //  @return     boolean

        row = (row/3) * 3;
        col = (col/3) * 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                if(puzzle[row + i][col + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void next(int row, int col) 
    {//Contract 
        //  @notes:     accepts the row & col index then moves to next
        //  @params     int row, value
        //  @params     int col, value
        //  @return     void

        if(col < 8) {
            solve(row, col + 1);
        } else {
            solve(row + 1, 0);
        }
    }

    public static void printPuzzle(int [][] table) 
    {//Contract 
        //  @notes:     Print table 
        //  @params     int col, index value to check
        //  @params     int num, value
        //  @return     boolean
        for(int r = 0; r < table.length; ++r) {
            for(int c = 0; c < table[r].length; ++c) {
                int cell = table[r][c];
                if(cell == 0)
                    System.out.print("* ");
                else
                    System.out.print(table[r][c] + " ");
            }
            System.out.println();
        }
        System.out.print("-----------------");
        System.out.println();
    }
}