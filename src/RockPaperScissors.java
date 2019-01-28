import java.io.IOException;

/**
 *
 * @author PolPuigdo
 */
public class RockPaperScissors {

    Player player1;
    Player player2;

    public RockPaperScissors() {
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic
        ViewRPS view = new ViewRPS();
        RockPaperScissors game = new RockPaperScissors();

        ControllerRPS ROCK_PAPER_SCISSOR = new ControllerRPS(view, game);

        ROCK_PAPER_SCISSOR.run();
    }

    public void setPlayers(String[] names) {
        player1 = new Player(names[0]);
        player2 = new Player(names[1]);
    }

}
