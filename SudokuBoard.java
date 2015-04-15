public class SudokuBoard implements GameBoard{
    int boxnum;
    int rownum;
    int colnum;
    SudokuTile [][] board;

    public SudokuBoard(){
        String inputBoard = "003020600900305001001806400008102900700000008006708200002609500800203009005010300";
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
    
    public boolean isValidTileVal(int row, int col, int val){
        //colnum = the length of a row, rownum = the length of a column
        int [] valuesSeen = new int[this.colnum];

        SudokuTile t = this.board[row][col];
        int whichBox = t.box;
        
        SudokuTile t2;
        int i = row;
        int j = 0;

        for(j=0; j<this.colnum; j++){
            t2 = this.board[i][j];
            if (t2.state == SudokuTile.PERMANENT){
                valuesSeen[t2.value] = 1;
            }
        }

        j = col;
        for(i=0; i<this.rownum; i++){
            t2 = this.board[i][j];
            if (t2.state == SudokuTile.PERMANENT){
                valuesSeen[t2.value] = 1;
            }
        }
     
        for (i=0;i<this.colnum;i++){
            for(j=0;j<this.rownum;j++){
                t2 = this.board[i][j];
                if (t2.box == whichBox && t2.state == SudokuTile.PERMANENT){
                    valuesSeen[t2.value] = 1;
                }
            }
        }
        if (valuesSeen[val] == 1){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean allRowsCorrect(){
        SudokuTile t;
        int val;
        for(int i=0; i<this.rownum; i++){
            int [] valuesSeen = new int[this.colnum];
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
                    System.out.println(whichBox);
                    for(int k = 0; k< this.board.length; k++){
                        for(int l = 0; l<this.board.length; l++){    
                            t = this.board[k][l];
                            if (t.box == whichBox){
                                System.out.println(t.value);
                            }
                        }
                    }
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

    public boolean setTileAtPos(int row, int col, int val){
        SudokuTile t = this.board[row][col];
        if (t.state != SudokuTile.PERMANENT){
            t.setValue(val);
            return true;
        }
        return false;
    }
    
    public SudokuTile getTileAtPos(int row, int col){
        SudokuTile t = this.board[row][col];
        return t;
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
