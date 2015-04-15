public class SudokuComputerGuessingPlayer implements GamePlayer{
    public SudokuBoard sudokuBoard = new SudokuBoard();
    public boolean [] hashmap = new boolean[10];
    public int numCanceled = 0;
    public SudokuComputerGuessingPlayer(SudokuBoard board){
        this.sudokuBoard = board;
        //hashmap starts at 1, board starts at 0
        this.hashmap = new boolean[10];
        for(int i = 0; i<this.hashmap.length; i++){
            this.hashmap[i] = false;
        }
        this.numCanceled = 0;
    }
    
    public void printHashmap(){
        for(int i=1; i<this.hashmap.length; i++){
            if(this.hashmap[i] == false){
                System.out.print(i + " ");
            }
        }
        System.out.print("\n");
    }
    public void cancelRowNum(int row){
        SudokuTile t;
        for(int j = 0; j<this.sudokuBoard.rownum; j++){
            t = this.sudokuBoard.getTileAtPos(row, j);
            if(t.value == 0){
                continue;
            }
            if(this.hashmap[t.value] == false){
                this.hashmap[t.value] = true;
                this.numCanceled += 1;
            }
        }
    }   

    public void cancelColNum(int col){
        SudokuTile t;
        for(int i=0; i<this.sudokuBoard.colnum; i++){
            t = this.sudokuBoard.getTileAtPos(i, col);
            if(t.value == 0){
                continue;
            }
            if (this.hashmap[t.value] == false){
                this.hashmap[t.value] = true;
                this.numCanceled += 1;
            }
        }
    }
    
    public void cancelBoxNum(int box){
        SudokuTile t;
        for(int i=0;i<this.sudokuBoard.colnum;i++){
            for(int j=0;j<this.sudokuBoard.rownum;j++){
                t = this.sudokuBoard.getTileAtPos(i,j);
                if (t.box == box && t.value != 0){
                   if (this.hashmap[t.value] == false){
                        this.hashmap[t.value] = true;
                        this.numCanceled += 1;
                   }
                }
            }
        }
    }
    
    public int [] getBasicMove(){
        int [] move = new int[3];
        SudokuTile t;
        for(int row = 0; row < this.sudokuBoard.colnum; row++){
            for(int col = 0; col < this.sudokuBoard.rownum; col++){
                t = this.sudokuBoard.getTileAtPos(row,col);
                this.numCanceled = 0;
                if (t.state == SudokuTile.PERMANENT){
                //    System.out.println("PERMANENT TILE"+ " " + t.value);
                    continue;
                }
                this.hashmap = new boolean[10];
                for(int i=0;i<hashmap.length;i++){
                    this.hashmap[i] = false;
                }
                //System.out.println(row + " " + col + " NEW MOVE");
                //printHashmap();
                
                cancelRowNum(row);
               // printHashmap();
                
                cancelColNum(col);
               // printHashmap();
                
                cancelBoxNum(t.getBoxFromRowCol(row,col));
               // printHashmap();
                
                if (this.numCanceled == 8){
                    for(int i=1;i<this.hashmap.length;i++){
                        if (this.hashmap[i] == false){
                            move[0] = row;
                            move[1] = col;
                            move[2] = i;
                            return move;
                        }
                    }
                }
            
            }
        }
        return move;
    } 
    
    public SudokuTile getTileWith2Vals(){
        for(int row = 0; row < this.sudokuBoard.colnum; row++){
            for(int col = 0; col < this.sudokuBoard.rownum; col++){
                t = this.sudokuBoard.getTileAtPos(row,col);
                this.numCanceled = 0;
                if (t.state == SudokuTile.PERMANENT){
                //    System.out.println("PERMANENT TILE"+ " " + t.value);
                    continue;
                }
                this.hashmap = new boolean[10];
                for(int i=0;i<hashmap.length;i++){
                    this.hashmap[i] = false;
                }
                cancelRowNum(row);
                cancelColNum(col);
                cancelBoxNum(t.getBoxFromRowCol(row,col));
               // printHashmap();
                
                if (this.numCanceled == 7){
                    for(int i=1;i<this.hashmap.length;i++){
                        if (this.hashmap[i] == false){
                            move[0] = row;
                            move[1] = col;
                            move[2] = i;
                            return move;
                        }
                    }
                }
            }
        }
    }
    public int [] getMove(){
        int [] move = new int[3];
        SudokuTile t;
        move = getBasicMove();
        //this will be an array of zeros
        return move;
    }
}






