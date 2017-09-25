/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 4 
 * Due: 09/24/17
 * Reference info - http://codefordummies.blogspot.com/2014/01/backtracking-solve-sudoku-in-java.html
*/

import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

 
public class Hunt_W4_SudokuSolver_test{
    public static char [][] theGame;
    
    public static class Cell {

        int row, col;

        public Cell(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
        return "Cell [row=" + row + ", col=" + col + "]";
        }
    }

    public static void main(String [] args){
        // Test File names  
            // sudoku_answers.txt
            // sudoku_test1.txt

        //Game info
            // number delim     = "\s"
            // Zero delim       = '*'
        
        
        //Display intro message
        introMessage();

        //Get params from cmd or user input
        String[] params = getParams(args);

        //Save file name to string
        String fileName = params[0];
        
        //Read in the file
        System.out.println("Reading from file " + fileName + "...");

        try { 
            Scanner f = new Scanner(new File(fileName)); 
            theGame = new char[9][9];

            //Read in new game board
            for( int r = 0; r < 9; ++r) {
                for(int c = 0; c < 9; ++c) {
                theGame[r][c] = f.next().charAt(0);
                }
            }

            //Dislay Game
            displayGame(theGame);

		} catch (FileNotFoundException e) {
            System.out.println(fileName + " was not found!");
            System.out.println(e.toString());
            System.exit(0);
		}

        //Test base cases
            //boolean t1 = isValid(theGame);
            // boolean t2 = isComplete(theGame);
            // System.out.println("\nis isComplete: \t" + t1);
            // System.out.println("\nis Valid: \t" + t2);

        boolean isSolved = solve(new Cell(0,0));

        if (!isSolved) {
            System.out.println("SUDOKU cannot be solved.");
        }else{
            System.out.println("SOLUTION\n");
            displayGame(theGame);
        }
     }

    public static boolean solve(char [][] game)
    {//Contract 
        //  @notes:     accepts the game then solves it
        //  @params     int i, the horz coordinate
        //  @params     int j, the vert coordinate
        //  @params     char[][] array, the game
        //  @return     boolean

        boolean isValid = isValidPuzzle(theGame);
        boolean isComplete = isCompletePuzzle(theGame);
        boolean isSolvedPuzzle = isSolvedPuzzle(theGame);

        //Base Cases
        if (!isValid) return false;                 // if is not valid
        if (isComplete) return true;                // if is complete
        if (isSolvedPuzzle) return true;            // if is valid & complete

        
        
        return false;
    }


    public static boolean isValidPuzzle(char [][] game)
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

    public static boolean isCompletePuzzle(char [][] game)
    {//Contract 
        //  @notes:     accepts the game then solves it
        //  @params     char[][] array, the game
        //  @return     void
        boolean isComplete = false;

        for(int r = 0; r < 9; ++r) {
			for(int c = 0; c < 9; ++c) {
			    if(theGame[r][c] > '0' && theGame[r][c] <= '9'){
                    isComplete = true;
                }else{
                    return false;
                }
                //System.out.print(theGame[r][c]);
			}
		}

        return isComplete;
    }

    public static boolean isSolvedPuzzle(char [][] game)
    {//Contract 
        //  @notes:     accepts the game then solves it
        //  @params     char[][] array, the game
        //  @return     void

        boolean isComplete = isCompletePuzzle(game);
        boolean isValid = isValidPuzzle(game);
        boolean isSolved = false;

        if(isComplete && isValid) {isSolved = true;}
        
        return isSolved;
    }

    public static boolean isCellValid(int i, int j, char [][] game) //test method?
    {//Contract 
        //  @notes:     accepts the game, then checks if cell is valid
        //  @params     char[][] array, the game
        //  @params     int x, row ref
        //  @params     int y, col ref
        //  @return     void
        
        try{ //Loop thru all value in game

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
        }catch(Exception e){
            System.out.println("Game error: \n\t" + e.getMessage());
            System.out.println("Stack Trace: \n\t" + e.getStackTrace());
            return false;
        }

        System.out.println("row="+ i +" col="+ j +" is valid");
        //Return true if game is valid
        return true;
    }

    public static void introMessage()
    {//Contract 
        //  Print intro message
        //  @return -> void, no output  
        System.out.println("\n~~~~~~~~~~~~ Sudoku Solver Program - Advanced Java Week 4 ~~~~~~~~~~~~\n");
    }

    public static boolean isCmdLine(String [] args)
    {//Contract 
        //  @notes:     Check to see if user started progam with cmd inputs
        //  @param      args[], cmd line input array 
        //  @param      isCmd, check if input > 0 and == 3
        //  @return     boolean, predicate
        //  @Tested     8/24/17

        boolean isCmd = false;
        isCmd = (args.length == 1) ? true : false;
        return isCmd;
    }

    public static String [] getParams(String [] args)
    { //Contract 
        //  @notes:     get input from either cmd or user input
        //  @param      args[], cmd line input array or manual user input array
        //  @param      isCmd, boolean
        //  @return     String array of user input
        //  @Tested     8/24/17

        //Check if user entered cmd input
        boolean is_cmdLine = isCmdLine(args);

        if(is_cmdLine){
            return args;
        }else{
            return getInputParams();
        }
    }

    public static String [] getInputParams()
    {//Contract 
        //  @notes:     If no cmd input then get user input
        //  @return     String array of user input
        //  @Tested     8/25/17


        //Create input scanner
        Scanner input = new Scanner(System.in);
        String [] params = new String[3];

        //Get string param
        System.out.print("\tEnter file name (ex: fileName.txt): ");
        params[0] = input.nextLine();

        //Close scanner object
        input.close();

        //return String []
        return params;
    }

	public static void displayGame(char[] [] theGame)
    {//Contract 
        //  @notes:     print the game to the console
        //  @params     char[][] array, theGame
        //  @return     void

        System.out.println("");
		for(int r = 0; r < 9; ++r) {
			for(int c = 0; c < 9; ++c) {
			    if(c % 9 == 0){System.out.println();}
                System.out.print(theGame[r][c] + " ");
			}
		}
        System.out.println();
	}
}

