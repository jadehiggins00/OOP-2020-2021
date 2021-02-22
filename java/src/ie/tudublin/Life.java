package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
    
    int size = 100;
    //width and height of every cell written to the screen
    float cellSize; 
    //store the board - declared row
    boolean[][] board = new boolean[size][size];

    //GETTER AND SETTERS
    public void setCell(boolean[][] board, int row, int col, boolean b) {
        //bounds checking
        if(row > 0 && row < size -1 && col > 0 && col < size -1){
            board[row][col] = b;

        }
    }//end method

    //getter
    public boolean getCell(boolean[][] board, int row, int col){
        //checking bounds 
        if(row > 0 && row < size -1 && col > 0 && col < size -1){
            return board[row][col];

        }
        else {
            return false;
        }
       
    }

    public int countCellsAround(int row, int col ){

        int count = 0;

        //use getCell here
        // if(getCell(board,row-1, col-1)){
        //     count++;
        // }
        // if(getCell(board,row-1, col)){
        //     count++;
        // }
        // if(getCell(board,row-1, col+1)){
        //     count++;
        // }
        // if(getCell(board,row, col-1)){
        //     count++;
        // }
        // if(getCell(board,row, col+1)){
        //     count++;
        // }
        // if(getCell(board,row+1, col-1)){
        //     count++;
        // }
        // if(getCell(board,row+1, col)){
        //     count++;
        // }
        // if(getCell(board,row+1, col+1)){
        //     count++;
        // }

        //seconf way
        for(int r = row -1; r<= row+1 ; r++){

            for(int c = col -1; c<= col+1 ; c++){
                if( r != row && c!= col){
                    if(getCell(board, r, col)){
                        count++;
                    }

                }
               
            }
        }

        return count;
    }


    public void drawBoard(boolean[][] board){
        //use rect and nested loop and map
        // use cellSize var
        // use some colours
        
        for (int row = 0 ; row < size ; row ++){

            for (int col = 0 ; col < size ; col ++){
                
                float x = map(col, 0, size,0, width);
                float y = map(row,0,size,0,height);
                if(board[row][col]){
                    rect(x,y,cellSize,cellSize);
                }


            }//end inner loop


        }//end outer loop
    }

    private void printBoard(boolean[][] board ){
        for(int row= 0 ; row < size ; row ++){

            for(int col = 0 ; col < size ; col++){
             
               print(board[row][col] ? 1 : 0);

            }//end inner for
            println();
        }//end outer for
    }


    public void randomize(){
        for(int row= 0 ; row < size ; row ++){

            for(int col = 0 ; col < size ; col++){
                float dice = random(0.0f, 1.0f);
                // if(dice < 0.5){

                //     board[row][col] = true;
                // }//end if

                // else{
                //     board[row][col] = false;
                // }

                board[row][col] = (dice <0.5f) ? true : false; 

            }//end inner for

        }//end outer for

    }//end method

    public void settings(){
        size(500, 500);
    }


    int mode = 0;
    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);
        // randomize();
        
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;
        printBoard(board);
        println(countCellsAround(0,2));
       cellSize = width / (size);
    }

 

    public void draw() {
        background(0);
        drawBoard(board);
    }
}
