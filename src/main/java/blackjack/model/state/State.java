package blackjack.model.state;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import java.util.List;

public abstract class State {
    protected static final String HIT = "Hit";
    protected static final String BLACKJACK = "Blackjack";
    protected static final String BUST = "Bust";

    protected final Cards cards;
    protected String sign;

    public State() {
        this.cards = new Cards();
        this.sign = HIT;
    }

    protected State(Cards cards, String state) {
        this.cards = cards;
        this.sign = state;
    }

    public boolean isBust(){
        return sign.equals(BUST);
    }

    public boolean isBlackJack(){
        return sign.equals(BLACKJACK);
    }

    public boolean isWinBy(State otherState) {
        return this.sumScore() > otherState.sumScore();
    }

    public boolean isDrawWith(State otherState) {
        return this.sumScore() == otherState.sumScore();
    }

    public int sumScore() {
        return cards.sumScore();
    }

    public List<String> getCards() {
        return cards.getValues();
    }

    public abstract State getCopyInstance();

    public abstract boolean canHit();

    public abstract State addCard(Card card);
}