import java.util.Scanner;
public class SudokuPlayer implements GamePlayer{
    public SudokuPlayer(){    
    }
    public int convertLetterToNumber(String letter){
        
        if (letter.equals("A")){
            return 0;
        }
        else if (letter.equals("B")){
            return 1; 
        }
        else if (letter.equals("C")){
            return 2;
        }
        else if (letter.equals("D")){
            return 3;
        }
        else if (letter.equals("E")){
            return 4;
        }
        else if (letter.equals("F")){
            return 5;
        }
        else if (letter.equals("G")){
            return 6;
        }
        else if (letter.equals("H")){
            return 7;
        }
        else if (letter.equals("I")){
            return 8;
        }
        else {
            return -1;
        }
    }
    
    
    public int [] getMove(){
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        int [] move = new int[3];
        int [] noMove = new int[1];
        noMove[0] = 0;
        while(!done){
            try{
                String scannedMove = scan.nextLine();
                String [] strMove = scannedMove.split(" ");
                move[2] = Integer.parseInt(strMove[1]);
                move[0] = convertLetterToNumber(strMove[0].substring(0,1));
                move[1] = convertLetterToNumber(strMove[0].substring(1,2));
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
