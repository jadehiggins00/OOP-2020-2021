package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    int size = 100;
    float cellSize;
    float[][] board = new float[size][size];
    boolean[][] next = new boolean[size][size];

    // public void clear(){

    // for(int row = 0 ; row < size ; row ++){

    //     for(int col =0 ; col <size ;col ++){

    //       pass

    //     }//end inner loop
    // }///end methof

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

    public void setCell(float[][] board, int row, int col, float b)
    {
        if (row >= 0 && row < size  && col >= 0 && col < size -1)
        {
            board[row][col] = b;
        }
    }

    public boolean getCell(float[][] board, int row, int col)
    {
        if (row >= 0 && row < size  && col >= 0 && col < size -1)
        {
            return board[row][col];
        }
        else
        {
            return 0;
        }        
    }

    public void drawBoard(float[][] board)
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
            // paused != paused;
        }
        
        if (keyCode == '1')
        {
            randomize();
        }
        if (keyCode == '2')
        {
            clear();
        }
        if (keyCode == '3')
        {
            drawCross();
        }
        
           
        frameRate(20);
    }

    public void drawCross(){

        for (int i = 0 ; i < size; i ++){

            setCell(board, size/2, i, true);
            setCell(board, i, size/2, true);
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

    private void updateBoard()
    {
        // Put code here to apply the rules!!
        for(int row = 0 ; row < size ; row ++){

            for(int col =0 ; col <size ;col ++){

                int count = countNeighbours(row, col);
                if(getCell(board, row, col)){

                    if(count == 2 ||  count ==3){
                        setCell(next, row, col, true);
                    }

                    else{

                        setCell(board, row, col, false);
                    }
                }//end if

            }//end inner loop
        }
        
        // Swap board and next
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    public void mouseDragged()
    {
        // This method gets called automatically when the mouse is dragged across the screen
        int row = (int)map(mouseY, 0, height, 0, size);
        int col = (int)map(mouseX, 0, width, 0, size);
        setCell(board, row, col, true);
    }

    public void draw() {
        background(0);
        drawBoard(board);        
        updateBoard();
    }
}
