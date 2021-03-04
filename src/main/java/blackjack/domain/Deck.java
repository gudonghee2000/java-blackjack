package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> deck = new ArrayList<>(52);

    public Deck() {
        for (CardPattern cardPattern : CardPattern.values()) {
            for (CardNumber cardNumber : CardNumber.values()) {
                deck.add(new Card(cardPattern, cardNumber));
            }
        }
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        return deck.remove(0);
    }

    public Card choiceCard(int index) {
        return deck.get(index);
    }

    public int getSize() {
        return deck.size();
    }
}
