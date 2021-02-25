package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    int size = 100;
    float cellSize;
    float[][] board = new float[size][size];
    float[][] next = new float[size][size];

    // creating  amthod to clear the board(erase it)
    public void clear(){

        for(int row = 0; row <  size ; row ++) {
        
            for(int col=0 ; col < size + 1; col ++){
                //setting every cell to be false - clearing all cells on board
                setCell(board, row, col, 0);
            }//end inner for
        }//end outer for


    }//end method

    public int countNeighbours(int row, int col)
    {
        int count = 0;
        
        for(int r = row -1 ; r <= row + 1; r ++)
        {
            for(int c = col -1 ; c <= col + 1; c ++)
            {
                if (! (r == row && c == col))
                {
                    if (getCell(board, r, c) >0)
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
    //bounds checking
    public void setCell(float[][] board, int row, int col, float b)
    {
        if (row >= 0 && row < size && col >= 0 && col < size )
        {
            board[row][col] = b;
        }
    }

    public float getCell(float[][] board, int row, int col)
    {
        if (row >= 0 && row < size && col >= 0 && col < size )
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
                float c = getCell(board, row, col);
                //if cell value is greater than 0 it means its alive
                if (c > 0)
                {
                    noStroke();
                    fill(c, 255,255);
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
                //setting to random value or 0
                board[row][col] = (dice < 0.5f) ? random(255) : 0;
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
            //pausing cell board - flips flag between true and false
            paused = ! paused;
        }
        
        if (keyCode == '1')
        {
            //calling the function randomize to randomize the board
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
            
    }

    // drawing the cross shape 
    public void drawCross(){
        for(int i=0; i< size ;  i++){
            //size/2 means halfway up the board
            setCell(board, size/2, i, random(255)); // rows
            setCell(board, i, size/2, random(255));
        }//end for

    }//end method

    // finding the average colour
    public float averageAround(float[][] board, int row, int col){
        float sum =0;
        for (int r = row-1; r <= row+1; r++ ){
            for (int c = col-1; c <= col+1; c++ ){
                
                sum += getCell(board, r, c);
            }//end iiner for
        }
        return sum /3.0f;
    }


    public void setup() {
        colorMode(HSB);
        randomize();
        
        /*
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;
        */
        println(countNeighbours(0, 2));

        cellSize = width / (size);

        //changing the framerate
        frameRate(10);
        
        //printBoard(board);        
    }

    private void updateBoard()
    {   
      
        // Put code here to apply the rules!!
        for (int row = 0; row < size ; row++){

            for( int col = 0 ; col < size ; col++){
            //putting the countNeighbour functon into a count var
            int count = countNeighbours(row, col);

                // if the cell is alive
                if(getCell(board, row, col)>0){

                    // if the cell has exactly 2 or 3 neighbours it is set to true
                    if(  count == 2 || count == 3 ) {
                        setCell(next, row, col, random(255)); //random 255 for colours
                       

                    }//end if 
                    // otherwise the cell dies and is set to false
                    else {
                        setCell(next, row, col, 0);
            
                    }//end else
                }//end if

                //  if there are exatcly three neighbours a cell is born 
                else {

                     if( count == 3 ) {
                        setCell(next, row, col, averageAround(board,row, col));
                    }//endif

                    // otherwise it dies
                    else {
                        setCell(next, row, col, 0);
                   }//end else
                 }//end else
                

             }//end inner for loop
        }//end outer for loop

        // Swap board and next
        float[][] temp = board;
        board = next;
        next = temp;
       
    }//end method

    //called by superclass
    public void mouseDragged()
    {
        // This method gets called automatically when the mouse is dragged across the screen
        int row = (int)map(mouseY, 0, height,0, size); // y axis
        int col = (int)map(mouseX, 0, width, 0, size);
        // calling set cell to implement row and col
        setCell(board, row, col, random(255));
    }

    public void draw() {
        background(0);
        drawBoard(board);  
        if(!paused){
            updateBoard();
        }      
       
    }
}
