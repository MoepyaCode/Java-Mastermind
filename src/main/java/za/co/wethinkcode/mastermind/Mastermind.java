package za.co.wethinkcode.mastermind;


public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }


    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    /**
     * Run game runs the logic of the game.
     * States how many digits are correct 
     */
    public void runGame(){
        //TODO: implement the main run loop logic

        String userGuess = "";
        int count = 12;
        
        while (count > 0) {
            
            // System.out.print(code);
            userGuess = player.getGuess();
            int correctPlace = 0;
            int correctDigit = 0;

            if(player.endGame()){
                System.out.print("The code was: " + code + "\n");
                break;
            }

            for (int i = 0; i < userGuess.length(); i++) {
                
                if (code.charAt(i) == userGuess.charAt(i)) {
                    correctPlace += 1;
                } else if(userGuess.contains(String.valueOf(code.charAt(i))) 
                && userGuess.charAt(i) != code.charAt(i)){
                    correctDigit += 1;
                }

            }

            System.out.print("Number of correct digits in correct place: " + correctPlace + "\n");
            System.out.print("Number of correct digits not in correct place: " + correctDigit + "\n");

            count -= 1;
            if(correctPlace == 4){
                System.out.print("Congratulations! You are a codebreaker!\n");
                System.out.print("The code was: " + code);
                break;
            }else if (count == 0) {
                System.out.print("No more turns left.\n");
                System.out.print("The code was: " + code + "\n");
                break;
            }
            System.out.print("Turns left: " + count + "\n");


        }
        

    }

    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
