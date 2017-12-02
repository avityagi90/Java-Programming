
public class FindOccurence {

	private static int glyphLength;
	private static int textLength;

	private static String glyphPattern;
	private static String glypthText;

	public static int appearanceCount(int patternLength, int textLength, String pattern, String text) {
		int count = 0;
		// Array to keep track of the character with index

		glyphLength = patternLength;
		textLength = textLength;

		glyphPattern = pattern;
		glypthText = text;

		for (int i = 0; i < textLength - glyphLength + 1; i++) {
			if (matchFound(glypthText.substring(i, i + glyphLength), glyphPattern)) {
				count++;
			}
		}
		return count;
		// Write code here
	}

	private static boolean matchFound(String substring, String glyphPattern2) {
		char[] charArray = glyphPattern2.toCharArray();
		boolean[] boolArray = new boolean[charArray.length];
		for (int i = 0; i < boolArray.length; i++) {
			boolArray[i] = false;
		}
		for (int i = 0; i < substring.length(); i++) {
			char ch = substring.charAt(i);
			boolean code = true;
			for (int j = 0; j < charArray.length; j++) {
				if (ch == charArray[j] && boolArray[j] == false) {
					boolArray[j] = true;
					code = false;
					break;
				}
			}
			if (code) {
				return false;
			}
		}
		return true;
	}

}
