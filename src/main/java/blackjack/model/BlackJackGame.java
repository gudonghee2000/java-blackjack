package blackjack.model;

import blackjack.dto.DealerDto;
import blackjack.dto.PlayerDto;
import blackjack.model.card.CardDeck;
import blackjack.model.player.Dealer;
import blackjack.model.player.Gamers;
import blackjack.model.player.Player;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class BlackJackGame {
    private static final int START_CARD_COUNT = 2;

    private final Player dealer;
    private final Gamers gamers;

    public BlackJackGame(List<String> gamerNames) {
        this.dealer = new Dealer();
        this.gamers = new Gamers(gamerNames);
    }

    public void start() {
        giveCardsToDealer();
        giveCardsToGamers();
    }

    private void giveCardsToDealer() {
        CardDeck deck = CardDeck.getInstance();
        for (int i = 0; i < START_CARD_COUNT; i++) {
            dealer.receive(deck.draw());
        }
    }

    private void giveCardsToGamers() {
        gamers.giveCardsToGamer();
    }

    public void hitOrStayUntilPossible(UnaryOperator<String> operator, Consumer<PlayerDto> consumer) {
        gamers.hitOrStayToGamer(operator, consumer);
        hitOrStayToDealer(consumer);
    }

    private void hitOrStayToDealer(Consumer<PlayerDto> consumer) {
        CardDeck deck = CardDeck.getInstance();
        while (!dealer.isBlackJack() && !dealer.isImpossibleHit()) {
            dealer.receive(deck.draw());
        }
        consumer.accept(DealerDto.from(dealer));
    }

    public Map<String, MatchResult> getGamerMatchResults() {
        return gamers.getMatchResult(dealer);
    }

    public Map<MatchResult, Integer> getDealerMatchResult() {
        return gamers.getDealerMatchResult(dealer);
    }

    public Player getDealer() {
        return dealer;
    }

    public Gamers getGamers() {
        return gamers;
    }

    public List<Player> getGamers2() {
        return gamers.getValues();
    }
}
