package baseball;

public class Game {
    public String question;

    private void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        int strikes = 0;
        int balls = 0;
        Result result = getResult(guessNumber, strikes, balls);
        return new GuessResult(result.strikes == 3, result.strikes, result.balls);
    }

    private Result getResult(String guessNumber, int strikes, int balls) {
        for (int i = 0; i < guessNumber.length(); i++) {
            int index = question.indexOf(guessNumber.charAt(i));
            if (index == i) strikes++;
            else if (index > -1) balls++;
        }
        Result result = new Result(strikes, balls);
        return result;
    }

    private static class Result {
        public final int strikes;
        public final int balls;

        public Result(int strikes, int balls) {
            this.strikes = strikes;
            this.balls = balls;
        }
    }
}
