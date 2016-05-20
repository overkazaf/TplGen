import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
	public static void main (String[] args) {
		String pattern = "(.*?)(\\d+)(.*?)"; // ¿¡∂Ë∆•≈‰
		String words = "Hello kitty, I'am John Doe, born at 20150242, LOL";
		Pattern r = Pattern.compile(pattern);
		Matcher matcher = r.matcher(words);
		
		//System.out.println(matcher.matches());
		
		if (matcher.find(0)) {
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
		} else {
			System.out.println("Not found");
		}
	}
}
