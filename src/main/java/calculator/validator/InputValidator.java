package calculator.validator;

public class InputValidator {
    public static void validate(String input, String delimiters) {
        if (isEmptyOrNull(input)) {
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!isValidCharacter(delimiters, c)) {
                throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다: " + c);
            }
        }
    }

    private static boolean isValidCharacter(String delimiters, char c) {
        return Character.isDigit(c) || isDelimiter(delimiters, c);
    }

    private static boolean isDelimiter(String delimiters, char c) {
        return delimiters.indexOf(c) != -1;
    }

    private static boolean isEmptyOrNull(String input) {
        return input == null || input.isEmpty();
    }
}
