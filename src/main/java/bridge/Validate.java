package bridge;

public class Validate {
    private final String ERROR_MASSAGE = "[ERROR] ";
    private static final String UP = "U";
    private static final String DOWN = "D";

    public void validateNumberRange(String input, int min, int max) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MASSAGE + "숫자만 입력 가능합니다.");
        }
        int num = Integer.parseInt(input);
        if (num < min || num > max) {
            throw new IllegalArgumentException(ERROR_MASSAGE + min + "이상 " + max + "이하의 숫자만 입력 가능합니다.");
        }
    }

    public void validateContainWord(String input) {
        if (!input.equals(UP) || !input.equals(DOWN)) {
            throw new IllegalArgumentException(ERROR_MASSAGE + UP + "또는" + DOWN + "만 입력 가능합니다");
        }
    }
}
