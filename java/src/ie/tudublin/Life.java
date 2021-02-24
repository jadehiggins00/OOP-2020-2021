package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    int size = 100;
    float cellSize;
    boolean[][] board = new boolean[size][size];
    boolean[][] next = new boolean[size][size];

    public int countNeighbours(int row, int col)
    {
        int count = 0;
        
        for(int r = row -1 ; r <= row + 1; r ++)
        {
            for(int c = col -1 ; c <= col + 1; c ++)
            {
                if (! (r == row && c == col))
                {
                    if (getCell(board, r, c))
                    {
                        count ++;
                        
                    }
                }
            }
        }
        
        // OR Use 8 if statements
        /*
        if (getCell(board, row-1, col-1))
        {
            count ++;
        }
        if (getCell(board, row-1, col))
        {
            count ++;
        }
        if (getCell(board, row-1, col+1))
        {
            count ++;
        }
        if (getCell(board, row, col-1))
        {
            count ++;
        }
        if (getCell(board, row, col+1))
        {
            count ++;
        }
        if (getCell(board, row+1, col-1))
        {
            count ++;
        }
        if (getCell(board, row+1, col))
        {
            count ++;
        }
        if (getCell(board, row+1, col+1))
        {
            count ++;
        }
        */
        
        return count;
        
    }

    public void setCell(boolean[][] board, int row, int col, boolean b)
    {
        if (row >= 0 && row < size -1 && col >= 0 && col < size -1)
        {
            board[row][col] = b;
        }
    }

    public boolean getCell(boolean[][] board, int row, int col)
    {
        if (row >= 0 && row < size -1 && col >= 0 && col < size -1)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }        
    }

    public void drawBoard(boolean[][] board)
    {
        // Use a nested loop
        // Use map to calculate x and y
        // Rect draw the cell
        // Use the cell size variable
        // Use some colours!
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);
                if (board[row][col])
                {
                    rect(x, y, cellSize, cellSize);
                }
            }
        }

    }

    private void printBoard(boolean[][] board)
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                print(board[row][col] ? 1 : 0);
            }
            println();
        }        
    }

    public void randomize()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float dice = random(0.0f, 1.0f);
                /*
                if (dice < 0.5)
                {
                    board[row][col] = true;
                }
                else
                {
                    board[row][col] = false;
                }
                */
                board[row][col] = (dice < 0.5f) ? true : false;
            }
        }
    }

    public void settings()
    {
        size(500, 500);
    }
    
    int mode = 0;
    boolean paused = false;
    public void keyPressed() {
        if (keyCode == ' ')
        {
        }
        
        if (keyCode == '1')
        {
        }
        if (keyCode == '2')
        {
        }
        if (keyCode == '3')
        {
        }
            
    }

    public void setup() {
        colorMode(RGB);
        randomize();
        
        /*
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;
        */
        println(countNeighbours(0, 2));

        cellSize = width / (size);
        
        //printBoard(board);        
    }

    private void updateBoard(boolean[][] board)
    {   
        boolean alive = true;
        boolean dead = false;
        // Put code here to apply the rules!!
        for (int row = 0; row < size; row++){

     
            for( int col = 0 ; col < size; col++){
                // if the cell is alive
                if(getCell(board, row, col) == alive){

                    // if the cell has exactly 2 or 3 neighbours it is set to true
                    if (  countNeighbours(row, col) == 2 || countNeighbours(row, col) == 3 ) {
                        board[row][col] = true;
                       

                    }//end if 
                    // otherwise the cell dies and is set to false
                    else {

                        board[row][col] = false;
                        if(getCell(board, row, col) == dead){

                            if(countNeighbours(row,col) == 3){
                                board[row][col] = alive;
                            }

                            else {
                                board[row][col] = dead;
                            }
                        }
                        
                    }//end else
                }//end if

                // else if(getCell(board, row, col) == dead){

                //     if( countNeighbours(row, col) ==3 ) {
                //         board[row][col] = alive;
                //     }//endif

                //     else {
                //         board[row][col] = dead;
                //     }//end else
                // }//end else if
                

            }//end inner for loop

        }//end outer for loop
        
        // Swap board and next
        boolean[][] temp = board;
        board = next;
        next = temp;

    }//end method

    public void mouseDragged()
    {
        // This method gets called automatically when the mouse is dragged across the screen
    }

    public void draw() {
        background(0);
        drawBoard(board);        
        updateBoard(board);
    }
}
