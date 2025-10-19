package calculator.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterUtils {
    private String input;
	private static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)"); // ex) //?\\n, //;\\n


	public DelimiterUtils(String input) {
		this.input = input;
	}

	static private String getDefaultDelimiters() {
		return ",:";
	}

	public String getDelimiters() {
		String delimiters = getDefaultDelimiters();

		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(this.input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			delimiters += customDelimiter;
		}

		return delimiters;
	}

	public String getInputExceptCustomDelimiter() {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(this.input);
		if (matcher.find()) {
			return matcher.group(2);
		} else {
			return this.input;
		}
	}

}
