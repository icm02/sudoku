public class SudokuTester{
    public static void main(String [] args){
        String inputBoard = "003020600900305001001806400008102900700000008006708200002609500800203009005010300";
        SudokuBoard b = new SudokuBoard(inputBoard);
        b.print();
        SudokuPlayer isabel = new SudokuPlayer();

    }
}
