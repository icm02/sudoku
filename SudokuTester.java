public class SudokuTester{
    public static void main(String [] args){
        //eventually need a RFF
        String inputBoard = "003020600900305001001806400008102900700000008006708200002609500800203009005010300";
        String solBoard = "483921657967345821251876493548132976729564138136798245372689514814253769695417382";
        String asolBoard = "003921657967345821251876493548132976729564138136798245372689514814253769695417382";
        SudokuBoard b = new SudokuBoard(inputBoard);
        b.print();
        SudokuPlayer isabel = new SudokuPlayer();
        while(!b.isDone()){
            System.out.println("Enter your move.");
            int [] isabelMove = isabel.getMove();
            b.setTileAtPos(isabelMove[0], isabelMove[1], isabelMove[2]);
            b.print();
        }
        System.out.println("CONGRATS");
    }
}
