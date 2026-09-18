package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    public void throwsIllegalArgumentExceptionInvaildInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");

    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void 입력값이_없을_경우() {
    }

    @Test
    public void 입력값_자리수가_세자리가_아닐경우() {

    }

    @Test
    public void 입력값에_숫자_외의_뮸자가_입력될_경우() {

    }

    @Test
    public void 입력값에_중복된_숫자가_입력될_경우() {

    }

    @Test
    public void 숫자_세개가_전부_일치_할_경우_3_strike() {

    }

    @Test
    public void 숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball() {

    }

    @Test
    public void 스트라이크만_있을_경우_1_strike_0_ball() {

    }

    @Test
    public void 볼만_있을_경우_0_strike_1_ball() {

    }

    @Test
    public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {

    }
}
