package BasicProgramming;

public class SudokuProblem {

	

	 
	/* Searches the grid to find an entry that is still unassigned. If
	   found, the referenc
	   
	   e parameters row, col will be set the location
	   that is unassigned, and true is returned. If no unassigned entries
	   remain, false is returned. */
	
	
	private static  int NSquare;
	private static  int N;
	private static int UNASSIGNED=0;
	private static int unAssignedRow=-1;
	private static int unAssignedCol=-1;
	
	public static void main(String[] args) {
		int grid[][] = new int[][]{
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
				{5, 2, 0, 0, 0, 0, 0, 0, 0},
				{0, 8, 7, 0, 0, 0, 0, 3, 1},
				{0, 0, 3, 0, 1, 0, 0, 8, 0},
				{9, 0, 0, 8, 6, 3, 0, 0, 5},
				{0, 5, 0, 0, 9, 0, 6, 0, 0},
				{1, 3, 0, 0, 0, 0, 2, 5, 0},
				{0, 0, 0, 0, 0, 0, 0, 7, 4},
				{0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
//		int grid[][] = new int[][]{
//				{5, 3, 0, 0, 7, 0, 0, 0, 0},
//				{6, 0, 0, 1, 9, 5, 0, 0, 0},
//				{0, 9, 8, 0, 0, 0, 0, 6, 0},
//				{8, 0, 0, 0, 6, 0, 0, 0, 3},
//				{4, 0, 0, 8, 0, 3, 0, 0, 1},
//				{7, 0, 0, 0, 2, 0, 0, 0, 6},
//				{0, 6, 0, 0, 0, 0, 2, 8, 0},
//				{0, 0, 0, 4, 1, 9, 0, 0, 5},
//				{0, 0, 0, 0, 8, 0, 0, 7, 9}};
		
//		int grid[][] = new int[][]{{0, 0, 0,0},{0, 0, 0,0},{0, 0, 0,0},{0, 0, 0,0}};
		
//		int grid[][] = new int[][]{{1, 0, 0,0},
//									{0, 0, 2,0},
//									{0, 3, 0,0},
//									{0, 0, 0,4}};
//		int grid[][] = new int[][]{
//				{1, 2, 3, 0, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 0, 0, 1, 2, 3},
//				{0, 0, 0, 1, 2, 3, 0, 0, 0},
//				{2, 3, 1, 0, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 0, 0, 2, 3, 1},
//				{0, 0, 0, 2, 3, 1, 0, 0, 0},
//				{3, 1, 2, 0, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 0, 0, 3, 1, 2},
//				{0, 0, 0, 3, 1, 2, 0, 0, 0}};
			if (SolveMagicSquare(grid) == 1)
					printGrid(grid);
			else
				System.out.println("No solution exists");
//			printGrid(grid);

	}
	
	/* Takes a partially filled-in grid and attempts to assign values to
	  all unassigned locations in such a way to meet the requirements
	  for Sudoku solution (non-duplication across rows, columns, and boxes) */
	public static int SolveMagicSquare(int[][] grid){
		NSquare=grid.length;
		N=(int) Math.sqrt(NSquare);
	    
	    // If there is no unassigned location, we are done
	    if (!FindUnassignedLocation(grid)){
	    			return 1; // success!
	    }
	    //These are variables to hold values for specific recurive calls 
	    int row=unAssignedRow;
	    int col=unAssignedCol;
	    
	    // consider digits 1 to 9
	    for (int num = 1; num <= NSquare; num++)
	    {
	        // if looks promising
	        if (isSafe(grid, row, col, num))
	        {
	            // make tentative assignment
	            grid[row][col] = num;
	 
	            // return, if success, yay!
	            if (SolveMagicSquare(grid)==1){
	                return 1;
	            }
	 
	            // failure, unmake & try again
	            grid[row][col] = UNASSIGNED;
	        }
	    }
	    return 0; // this triggers backtracking
	}
	
	
	static boolean FindUnassignedLocation(int grid[][])
	{
	    for (int row = 0; row < grid.length; row++){
	        for (int col = 0; col < grid[row].length; col++){
	            if (grid[row][col] == UNASSIGNED){
	                unAssignedRow=row;
	                unAssignedCol=col;
	            	return true;
	            }
	        }
	    }
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified row matches the given number. */
	static boolean UsedInRow(int grid[][], int row, int num)
	{
	    for (int col = 0; col < NSquare; col++){
	        if (grid[row][col] == num){
	            return true;
	        }
	    }
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified column matches the given number. */
	static boolean UsedInCol(int grid[][], int col, int num)
	{
	    for (int row = 0; row < NSquare; row++){
	        if (grid[row][col] == num){
	            return true;
	        }
	    }
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   within the specified 3x3 box matches the given number. */
	static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num)
	{
	    for (int row = 0; row < N; row++){
	        for (int col = 0; col < N; col++){
	            if (grid[row+boxStartRow][col+boxStartCol] == num){
	                return true;
	            }
	        }
	    }
	    return false;
	}
	 
	/* Returns a boolean which indicates whether it will be legal to assign
	   num to the given row,col location. */
	
	// Checks whether it will be legal to assign num to the given row,col
	static boolean isSafe(int grid[][], int row, int col, int num)
	{
	    /* Check if 'num' is not already placed in current row,
	       current column and current 3x3 box */
	    return ((!UsedInRow(grid, row, num) && !UsedInCol(grid, col, num)) &&
	           !UsedInBox(grid, row - row%N , col - col%N, num));
	}
	 
	/* A utility function to print grid  */
	static void printGrid(int grid[][])
	{
	    for (int row = 0; row < NSquare; row++)
	    {
	       for (int col = 0; col < NSquare; col++){
	             System.out.printf("%2d", grid[row][col]);
	       }
	       System.out.printf("\n");
	    }
	}
}

