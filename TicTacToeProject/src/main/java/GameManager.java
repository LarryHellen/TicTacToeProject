public class GameManager {
    private String turn;
    private String[] grid;
    
    
    public GameManager(){
        this.turn = "x";
        this.grid = new String[9];
        
        for(int i = 0; i < 9; i++){
            
            this.grid[i] = " ";
        }
    }
    
    public String getTurn(){
        return this.turn;
    }
    
    public String[] getGrid(){
        return this.grid;
    }
    
    @Override
    public String toString(){
        String temp = "";
        
        for(int i = 0; i < this.grid.length; i++){
            if(i == 3 || i == 6){
                temp = temp + "\n";
            }
            if(i%3 != 0){
                temp = temp + "| ";
            }
            
            temp = temp + this.grid[i] + " ";
        }
        
        return temp;
    }
    
    public String getNumGrid(){
        String temp = "";
        
        for(int i = 0; i < this.grid.length; i++){
            if(i == 3 || i == 6){
                temp = temp + "\n";
            }
            if(i%3 != 0){
                temp = temp + "| ";
            }
            
            temp = temp + i + " ";
        }
        
        return temp;
    }
    
    public void advanceTurn(){
        if(this.turn.equals("x")){
            this.turn = "o";
        } else{
            this.turn = "x";
        }
    }
    
    public void place(int location){
        this.grid[location] = this.turn;
        advanceTurn();
    }
    
    public String checkWinner(){
        if(this.grid[0].equals(this.grid[1]) && this.grid[0].equals(this.grid[2])){
            return this.grid[0];
        } else if(this.grid[3].equals(this.grid[4]) && this.grid[3].equals(this.grid[5])){
            return this.grid[3];
        } else if(this.grid[6].equals(this.grid[7]) && this.grid[6].equals(this.grid[8])){
            return this.grid[6];
        } else if(this.grid[0].equals(this.grid[3]) && this.grid[0].equals(this.grid[6])){
            return this.grid[0];
        } else if(this.grid[1].equals(this.grid[4]) && this.grid[1].equals(this.grid[7])){
            return this.grid[1];
        } else if(this.grid[2].equals(this.grid[5]) && this.grid[2].equals(this.grid[8])){
            return this.grid[2];
        } else if(this.grid[0].equals(this.grid[4]) && this.grid[0].equals(this.grid[8])){
            return this.grid[0];
        } else if(this.grid[2].equals(this.grid[4]) && this.grid[2].equals(this.grid[6])){
            return this.grid[2];
        } else {
            boolean test = false;
            for(String i : grid){
                if(i.equals(" ")){
                    test = true;
                }
            }
            
            if(test == false){
                return "L";
            }
        }
        
        return "k";
    }
    
    public void reset(){
        this.turn = "x";
        this.grid = new String[9];
        
        for(int i = 0; i < 9; i++){
            
            this.grid[i] = " ";
        }
    }
}
