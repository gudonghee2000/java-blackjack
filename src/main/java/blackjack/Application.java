package blackjack;

import blackjack.model.BlackjackGame;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class Application {
    public static void main(String[] args) {
        BlackjackGame blackJackGame = new BlackjackGame(InputView.inputPlayerNames());

        blackJackGame.start();
        ResultView.printStartResult(blackJackGame.getDealer(), blackJackGame.getGamers());

        blackJackGame.hitOrStayUntilPossible(InputView::inputHitOrStaySign, ResultView::printCurrentTurnHitResult);

        ResultView.printFinalResult(blackJackGame.getDealer(), blackJackGame.getGamers());

        ResultView.printMatchResult(blackJackGame.createMatchResult());
    }
}
