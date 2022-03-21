package blackjack.model.state.finished;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;
import blackjack.model.state.State;
import blackjack.model.state.created.Created;

public abstract class Finished extends Created {

    protected Finished(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public boolean isHitAble() {
        return false;
    }

    @Override
    public State add(Card card) {
        throw new IllegalArgumentException("[ERROR] 카드를 추가 할 수 없습니다.");
    }

    @Override
    public State stay() {
        throw new IllegalArgumentException("[ERROR] 이미 카드 분배가 끝났습니다.");
    }
}
