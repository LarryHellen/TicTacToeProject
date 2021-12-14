import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        GameManager manager = new GameManager();
        Scanner scan = new Scanner(System.in);
        UserInterface ui = new UserInterface(manager, scan);
        
        ui.start();
        System.out.println("Thank you for playing my tic tac toe game!");
    }
}
