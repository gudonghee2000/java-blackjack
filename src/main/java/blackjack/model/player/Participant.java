package blackjack.model.player;

import blackjack.model.state.State;
import blackjack.model.card.CardDeck;

import java.util.List;

public abstract class Participant {
    protected static final int START_DRAW_COUNT = 2;

    protected final String name;

    protected Participant(final String name) {
        checkEmpty(name);
        this.name = name.trim();
    }

    private void checkEmpty(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백이거나 없을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public abstract List<String> getCards();

    public abstract Participant getCopyInstance();

    public abstract Participant drawCardsBy(final CardDeck cardDeck);

    public abstract boolean canHit();

    public abstract Participant hitBy(final CardDeck cardDeck);

    public abstract State getState();
}
