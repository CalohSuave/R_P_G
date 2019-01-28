public class ViewRPS {

    public ViewRPS() {
    }

    public void printInitMenu(){
        System.out.print("WELCOME TO ROCK PAPER SCISSORS \n"
                + "Press ENTER to start...");
    }

    public void choosePlayerName(int i){
        System.out.print("Enter your name player "+i+": ");
    }

    public void chooseAction(String name){
        System.out.println("Insert your action " +name);
        System.out.println("(1-Rock --- 2-Paper --- 3-Scissors)");
    }

    public void printWinnerRound(String winner){
        System.out.println("The winner of this round is: " +winner);
    }

    public void printWinnerGame(String winner){
        System.out.println(winner.toUpperCase()+" HAS WON THE GAME!!!");
    }

    public void printDraw(){
        System.out.println("Draw, both players have chosen the same action");
    }

    public void printErrorAction(){
        System.out.println("Please, choose a valid action :D");
    }


}