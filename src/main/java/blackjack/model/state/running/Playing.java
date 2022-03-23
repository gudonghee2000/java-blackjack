package blackjack.model.state.running;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import blackjack.model.state.State;
import blackjack.model.state.finished.Bust;
import blackjack.model.state.finished.Stay;

public class Playing extends Running {

    public Playing(final Cards cards) {
        super(cards);
    }

    @Override
    public State add(Card card) {
        Cards cards = this.cards.add(card);

        if (cards.isFinishScore()) {
            return new Stay(cards);
        }
        if (cards.isBust()) {
            return new Bust(cards);
        }
        return new Playing(cards);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public boolean isHitAble() {
        return true;
    }

    @Override
    public State stay() {
        return new Stay(cards);
    }
}
