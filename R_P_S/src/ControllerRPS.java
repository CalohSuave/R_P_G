import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ControllerRPS {
    private final ViewRPS view;
    private final RockPaperScissors game;
    private final Scanner sc = new Scanner(System.in);
    private final String[] names = new String[2];
    private Round round;
    private final Pattern p = Pattern.compile("^[1-3]*$");
    private final String regex = "[0-9]+";

    public ControllerRPS(ViewRPS view, RockPaperScissors game) {
        this.view = view;
        this.game = game;
    }

    public void run() throws IOException {
        view.printInitMenu();
        System.in.read();
        getPlayers();
    }

    private void getPlayers() {
        for (int i = 1; i < 3; i++) {
            view.choosePlayerName(i);
            String name = sc.nextLine();
            names[i - 1] = name;
        }
        game.setPlayers(names);
        startRound();
    }

    private void startRound() {
        round = new Round();
        chooseAction(round);
        compareActions();
    }

    private void chooseAction(Round round) {
        for (int i = 0; i < 2; i++) {
            String sAction;
            int action;
            int cont = 0;
            do {
                if (cont > 0) {
                    view.printErrorAction();
                }

                view.chooseAction(names[i]);
                sAction = sc.nextLine();

                if (sAction.matches(regex)){
                    action = Integer.parseInt(sAction);
                } else {
                    action = 0;
                }

                cont++;
            } while (action > 3 || action < 1);
            if (i == 0) {
                round.setActionPlayer1(Action.values()[action - 1]);
            } else {
                round.setActionPlayer2(Action.values()[action - 1]);
            }

        }
    }

    private void compareActions() {
        if (round.getActionPlayer1() == Action.ROCK) {
            if (null == round.getActionPlayer2()) {
                view.printDraw();
            } else switch (round.getActionPlayer2()) {
                case PAPER:
                    game.player2.win();
                    view.printWinnerRound(game.player2.getName());
                    break;
                case SCISSORS:
                    game.player1.win();
                    view.printWinnerRound(game.player1.getName());
                    break;
                default:
                    view.printDraw();
                    break;
            }
        }

        if (round.getActionPlayer1() == Action.PAPER) {
            if (null == round.getActionPlayer2()) {
                view.printDraw();
            } else switch (round.getActionPlayer2()) {
                case SCISSORS:
                    game.player2.win();
                    view.printWinnerRound(game.player2.getName());
                    break;
                case ROCK:
                    game.player1.win();
                    view.printWinnerRound(game.player1.getName());
                    break;
                default:
                    view.printDraw();
                    break;
            }
        }

        if (round.getActionPlayer1() == Action.SCISSORS) {
            if (null == round.getActionPlayer2()) {
                view.printDraw();
            } else switch (round.getActionPlayer2()) {
                case ROCK:
                    game.player2.win();
                    view.printWinnerRound(game.player2.getName());
                    break;
                case PAPER:
                    game.player1.win();
                    view.printWinnerRound(game.player1.getName());
                    break;
                default:
                    view.printDraw();
                    break;
            }
        }

        checkWinnerGame();
    }

    private void checkWinnerGame() {
        if (game.player1.getWin() == 3) {
            view.printWinnerGame(game.player1.getName());
        } else if (game.player2.getWin() == 3) {
            view.printWinnerGame(game.player2.getName());
        } else {
            startRound();
        }
    }
}
