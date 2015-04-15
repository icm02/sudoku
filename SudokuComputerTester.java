public class SudokuComputerTester{
    public static void main(String [] args){
        //eventually need a RFF
        String input2Board = "007962400900010002010853060500479001000080000400321007090248050600030008008695100";
        String inputBoard = "020456789457080236689237040005362974274090653396574800040618397761040528938725060";
        SudokuBoard b = new SudokuBoard(inputBoard);
        b.print();
        SudokuComputerPlayer isabel = new SudokuComputerPlayer(b);
        int [] isabelMove;
        while(!b.isDone()){
 //           System.out.println("Enter your move.");
            isabelMove = isabel.getMove();
            b.setTileAtPos(isabelMove[0], isabelMove[1], isabelMove[2]);
            if(isabelMove[0] != 0){
           //     System.out.println(isabelMove[0] + " " + isabelMove[1] + " " + isabelMove[2]);
                b.print();
            }
        }
        System.out.println("CONGRATS");
    }
}
