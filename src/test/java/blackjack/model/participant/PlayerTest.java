package blackjack.model.participant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("베팅 금액이 음수이면 예외가 발생한다.")
    @Test
    void construct_exception_minus() {
        assertThatThrownBy(() -> new Player("리버", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 베팅 금액은 0보다 큰 금액이여야 합니다.");
    }

    @DisplayName("베팅 금액이 0이면 예외가 발생한다.")
    @Test
    void construct_exception_zero() {
        assertThatThrownBy(() -> new Player("리버", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 베팅 금액은 0보다 큰 금액이여야 합니다.");
    }
}
