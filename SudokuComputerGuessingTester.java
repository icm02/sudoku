public class SudokuComputerGuessingTester{
    public static void main(String [] args){
        //eventually need a RFF
        String inputBoard = "007962400900010002010853060500479001000080000400321007090248050600030008008695100";
        SudokuBoard b = new SudokuBoard(inputBoard);
        b.print();
        SudokuComputerGuessingPlayer isabel = new SudokuComputerGuessingPlayer(b);
        int [] isabelMove;
        while(!b.isDone()){
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
