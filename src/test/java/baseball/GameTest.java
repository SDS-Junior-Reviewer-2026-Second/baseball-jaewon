package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

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

    private void generateQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    @Test
    void returnSolvedResultIfMatchedNumber() {
        generateQuestion("123");

        assertMatchedNumber(game.guess("123"), true, 3, 0);

    }

    @Test
    void returnSolvedResultIfUnMatchedNumber() {
        generateQuestion("123");

        assertMatchedNumber(game.guess("456"), false, 0, 0);

    }

    @Test
    public void returnUnSolvedResultIfSomeMatchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("120"), false, 2, 0);
        assertMatchedNumber(game.guess("061"), false, 0, 1);
        assertMatchedNumber(game.guess("136"), false, 1, 1);
    }


    private void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
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
