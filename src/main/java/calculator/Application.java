package calculator;

import calculator.delimiter.DelimiterUtils;
import calculator.input.ConsoleUserInputStrategy;
import calculator.input.UserInputStrategy;
import calculator.summarize.StringSummarizer;

public class Application {
    public static void main(String[] args) {
        String input;
        String delimiters;

        // 사용자 입력
        input = getUserInput();

        // delimiter 구성하기
        DelimiterUtils delimiterUtils = new DelimiterUtils(input);
        delimiters = getDelimiters(delimiterUtils);
        input = extractInputIfCustomDelimiterExists(delimiterUtils);

        // 문자열 덧셈 구하기
        int result = StringSummarizer.sum(input, delimiters);

        System.out.println("결과 : " + result);
    }

    private static String getUserInput() {
        UserInputStrategy userInputStrategy = new ConsoleUserInputStrategy();
        String input = userInputStrategy.getUserInput();
        return input;
    }

    private static String getDelimiters(DelimiterUtils delimiterUtils) {
        return delimiterUtils.getDelimiters();
    }

    private static String extractInputIfCustomDelimiterExists(DelimiterUtils delimiterUtils) {
        return delimiterUtils.getInputExceptCustomDelimiter();
    }

}
