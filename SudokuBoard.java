public class SudokuBoard implements GameBoard{
    int boxnum;
    int rownum;
    int colnum;
    SudokuTile [][] board;

    public SudokuBoard(String inputBoard){
        //the row & column numbers have to be perfect squares so that you can use the boxes
        this.boxnum = 9;
        this.rownum = 9;
        this.colnum = 9;
        board = new SudokuTile[this.rownum][this.colnum];
        int counter = 0;
        int val;
        int curstate;
        SudokuTile t;
        for(int i=0; i<this.rownum; i++){
            for(int j=0; j<this.colnum; j++){
                val = Integer.parseInt(inputBoard.substring(counter, counter+1));
                if (val == 0){
                    curstate = SudokuTile.EMPTY;
                }
                else{
                    curstate = SudokuTile.PERMANENT;
                }
                t = new SudokuTile(i, j, curstate, val);
                board[i][j] = t;
                counter +=1;
            }
        }
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
    
    public void print(){
        String result = "    A B C  D E F  G H I\n\n";
        String letters = "ABCDEFGHI";
        for(int i=0; i<this.rownum; i++){
            result += letters.substring(i,i+1);
            result += "   ";
            for(int j=0; j<this.colnum; j++){
                result += board[i][j].value; 
                if (j == 2 || j == 5){
                    result +="  ";
                }
                else{
                    result +=" ";
                }
            }
            if (i == 2 || i == 5){
                result += "\n\n";
            }
            else{
                result += "\n";
        
            }
        }
        System.out.println(result);
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
