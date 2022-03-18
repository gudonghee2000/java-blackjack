package blackjack.model;

import blackjack.model.card.CardDeck;
import blackjack.model.participant.Participants;
import blackjack.view.MoneyBetter;
import java.util.List;

public class BlackjackGame {
    private final Participants participants;
    private final CardDeck cardDeck;

    public BlackjackGame(final List<String> names, final MoneyBetter moneyBetter) {
        this.participants = new Participants(names, moneyBetter);
        this.cardDeck = new CardDeck();
    }
}
