package blackjack.model.participant;

import blackjack.model.card.Card;
import blackjack.model.card.CardDeck;
import blackjack.model.game.GameSign;
import blackjack.model.game.TurnProgress;
import blackjack.model.state.State;
import blackjack.model.state.running.Ready;
import java.util.List;

public abstract class Participant {
    protected final String name;
    protected State state;

    protected Participant(final String name) {
        this.name = name;
        this.state = new Ready();
    }

    public void drawFrom(final CardDeck cardDeck) {
        while (this.state.isReady()) {
            this.state = this.state.add(cardDeck.draw());
        }
    }

    public abstract void hitFrom(final CardDeck cardDeck, final GameSign gameSign, final TurnProgress turnProgress);

    public abstract double getProfit(final Participant otherParticipant);

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return state.getCards();
    }

    public int getScore() {
        return state.getScore();
    }
}
