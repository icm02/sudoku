public class SudokuBoard implements GameBoard{
    int boxnum;
    int rownum;
    int colnum;
    SudokuTile [][] board;

    public SudokuBoard(){
        //the row & column numbers have to be perfect squares so that you can use the boxes
        this.boxnum = 9;
        this.rownum = 9;
        this.colnum = 9;
        
        board = new SudokuTile[this.rownum][this.colnum];
    }
    /*
     * check if board is correct AND is full
     */
    public boolean isDone(){
        if(tilesFull() && allRowsCorrect() && allColsCorrect() && allBoxesCorrect()){
            return true;
       }
        return false;
    }
    
    public boolean allRowsCorrect(){
        SudokuTile t;
        int val;
        for(int i=0; i<this.rownum; i++){
            int [] valuesSeen = new int[colnum];
            for(int j=0; j<this.colnum; j++){
                t = this.board[i][j];
                val = t.value;
                if(valuesSeen[val-1] == 0){
                    valuesSeen[val-1] = val;
                }
                else{
                    System.out.println("INVALID. DUPLICATES FOUND IN ROW.");
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean allColsCorrect(){
        int val;
        SudokuTile t;
        for(int j=0; j<this.colnum; j++){
            int [] valuesSeen = new int[rownum];
            for(int i=0; i<this.rownum; i++){
                t = this.board[i][j];
                val = t.value;
                if(valuesSeen[val-1] == 0){
                    valuesSeen[val-1] = val;
                }
                else{
                    System.out.println("INVALID. DUPLICATES FOUND IN COLUMN.");
                    return false;
                }
            }
        } 
        return true;
    }
    
    public boolean allBoxesCorrect(){
        int numValues = this.rownum;
        int whichBox;
        int val;
        SudokuTile t;
        int [][] valuesSeen = new int[this.boxnum][numValues];    
        for(int i=0; i<this.rownum; i++){
            for(int j=0; j<this.colnum; j++){
                t = this.board[i][j];
                whichBox = t.box;
                val = t.value;
                if(valuesSeen[whichBox-1][val-1] == 0){
                    valuesSeen[whichBox-1][val-1] = val;
                }
                else{
                    System.out.println("INVALID. DUPLICATES FOUND IN BOX");
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean tilesFull(){
        for(int i=0; i<this.rownum; i++){
            for(int j=0; j<this.colnum; j++){
                SudokuTile t = this.board[i][j];
                if (t.value < 1){
                    return false;
                }
            }
        }
        return true;
    }

    public int getNumRows(){
        return this.rownum;
    }
    
    public void setNumRows(int rownum){
        this.rownum = rownum;
    }
    
    public int getNumCols(){
        return this.colnum;
    }
    
    public void setNumCols(int colnum){
        this.colnum = colnum;
    }
}
