package blackjack.model.player;

import blackjack.model.MatchResult;
import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import java.util.List;

public abstract class Player {
    protected final Cards cards;

    public Player() {
        this.cards = new Cards();
    }

    public void receive(Card card) {
        this.cards.add(card);
    }

    public boolean isBlackJack() {
        return cards.isSameWithLimitScore() && cards.hasTwoCard();
    }

    public boolean isBust() {
        return cards.isOverLimitScore();
    }

    public boolean isWinBy(Player otherPlayer) {
        return cards.sumScore() > otherPlayer.cards.sumScore();
    }

    public boolean isDrawWith(Player otherPlayer) {
        return cards.sumScore() == otherPlayer.cards.sumScore();
    }

    public List<String> getCards() {
        return cards.getValues();
    }

    public Cards getCards2() {
        return cards;
    }

    public abstract String getName();

    public abstract boolean isImpossibleHit();
}
