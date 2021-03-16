package blackjack.domain.state;

import blackjack.domain.card.Cards;

import java.math.BigDecimal;

public class Bust extends Finish {
    public Bust(final Cards cards) {
        super(cards);
    }

    @Override
    public BigDecimal getEarningRates(State dealerState) {
        return new BigDecimal("-1");
    }
}