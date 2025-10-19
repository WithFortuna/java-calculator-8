package calculator.summarize;

import java.util.StringTokenizer;

public class StringSummarizer {
	public static int sum(String numberString, String delimiters) {
		int sum = 0;
		StringTokenizer tokens = new StringTokenizer(numberString, delimiters);
		while (tokens.hasMoreTokens()) {
			Integer tokenInteger = Integer.valueOf(tokens.nextToken());
			sum += tokenInteger;
		}

		return sum;
	}
}
