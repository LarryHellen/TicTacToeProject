import java.util.Scanner;

public class UserInterface {
    private GameManager manager;
    private Scanner scan;
    
    
    public UserInterface(GameManager manager, Scanner scan){
        this.manager = manager;
        this.scan = scan;
    }
    
    public void start(){
        while(true){
            System.out.println("Current board: ");
            System.out.println(this.manager);
            
            String winner = this.manager.checkWinner();
            
            if(winner.equals("x")){
                System.out.println("\nPlayer x has won!");
                break;
            } else if(winner.equals("o")){
                System.out.println("\nPlayer o has won!");
                break;
            } else if(winner.equals("L")){
                System.out.println("\nBoth players have lost the game.");
                break;
            }
            
            System.out.println("\nEnter the grid # in which you want to place your " + this.manager.getTurn());
            System.out.println();
            System.out.println(this.manager.getNumGrid());
            System.out.println();
            int input = scan.nextInt();
            
            if(input == -1){
                break;
            } else if(input > 8 || input < 0){
                System.out.println();
                System.out.println("That is not a valid grid space!");
                System.out.println();
                continue;
            } else if(!(manager.getGrid()[input].equals(" "))){
                System.out.println();
                System.out.println("That grid space already has an " + manager.getGrid()[input] + "!");
                System.out.println();
                continue;
            }
            
            this.manager.place(input);
            
            System.out.println();
        }
        
        System.out.println("Do you wish to play again?");
        String again = this.scan.next();
        
        //System.out.println(again);
        
        if(again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y")){
            System.out.println();
            manager.reset();
            start();
        }
    }
}
