import java.util.Scanner;
public class SudokuPlayer implements GamePlayer{
    public SudokuPlayer(){
    
    }
    public int [] getMove(){
        System.out.println("Enter your move.");
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        int [] move = new int[3];
        int [] noMove = new int[1];
        noMove[0] = 0;
        while(!done){
            try{
                String scannedMove = scan.nextLine();
                String [] strMove = scannedMove.split(" ");
               /* String [] strRowColMove = new String[3];
                strRowColMove[0] = strMove[0].substring(0,1);
                strRowColMove[1] = strMove[0].substring(1,2);
                strRowColMove[2] = strMove[1];
                for(int i=0; i<3; i++){
                    move[i] = Integer.parseInt(strRowColMove[i]);
                }*/
                done = true;
            }
            
            catch(NumberFormatException e){
                System.out.println("INVALID FORMAT" + "\n" + "Enter your move.");
            }
            
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("INVALID FORMAT" + "\n" + "Enter your move.");
            }
            return move;
        }
        return noMove;
    }
}
