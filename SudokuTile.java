public class SudokuTile implements GameTile{
    int state;
    int value;
    int row;
    int column;
    int box;

    public static final int EMPTY = 0;
    public static final int FULL = 1;
    public static final int PERMANENT = 2;
    
    public SudokuTile(int row, int column){
        this.state = EMPTY;
        this.value = EMPTY;
        this.row = row;
        this.column = column;
        this.box = getBoxFromRowCol(this.row, this.column);
    }
    
    public SudokuTile(int row, int column, int state, int value){
        this.row = row;
        this.column = column;
        this.state = state;
        this.value = value;
        this.box = getBoxFromRowCol(this.row, this.column);
    }
    
    public int getBoxFromRowCol(int r, int c){
        if (r<4 && c<4){
           return 1;
        } 
        else if (r<4 && c<7){
            return 2;
        }
        else if (r<4){
            return 3;
        }
        else if (r<7 && c<4){
            return 4;
        }
        else if (r<7 && c<7){
            return 5;
        }
        else if (r<7){
            return 6;
        }
        else if (c<4){
            return 7;
        }
        else if (c<7){
            return 8;
        }
        else {
            return 9;
        }
    }
    /*
     * 3 states: permanent, full, empty
     */ 
    public void setState(int state){
        if ((this.state == FULL || this.state == EMPTY) && (state == FULL || state == EMPTY)){
            this.state = state;
        } 
        System.out.println("CAN'T CHANGE A PERMANENT VALUE. INVALID");
    }
    /*
     * 10 values: 1-9 (for the numbers) and 0 for empty box
     */
    public void setValue(int value){
        this.value = value;
    }
    
    public int getRow(){
        return this.row; 
    }
    
    public int getColumn(){
        return this.column;
    }
    
    public int getBox(){
        return this.box;
    }    
}
