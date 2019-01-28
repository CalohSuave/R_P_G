public class ViewRPS {

    public ViewRPS() {
    }

    public void printInitMenu(){
        System.out.print("WELOCME TO ROCK PAPER SCISSORS \n"
                + "Press ENTER to start...");
    }

    public void choosePlayerName(int i){
        System.out.print("Enter your name player "+i+": ");
    }

    public void chooseAction(int i){
        System.out.println("Insert your action player "+i);
        System.out.println("(1-Rock || 2-Paper || 3-Scissors)");
    }

    public void printWinnerRound(String winner){
        System.out.println("The winner of this round is: " +winner);
    }

    public void printWinnerGame(String winner){
        System.out.println(winner.toUpperCase()+" HAS WON THE GAME!!!");
    }

    public void printDraw(){
        System.out.println("Draw, both of the players choose the same action");
    }

    public void printErrorAction(){
        System.out.println("Please, choose a valid action :D");
    }


}