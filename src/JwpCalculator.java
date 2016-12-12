import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YG-MAC on 2016. 12. 12..
 */
public class JwpCalculator {

    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public int add(String t) {
        int result = 0;
        if (t == null || t.isEmpty()) {
            return result;
        }
        for (String r : splitJwp(t)) {
            result += checkMinus(Integer.parseInt(r));
        }
        return result;
    }

    private int checkMinus(int r) {
        if (r < 0) {
            throw new RuntimeException();
        }
        return r;
    }

    private String[] splitJwp(String text) {
        Matcher m = pattern.matcher(text);
        String defaultDelimiters = ",|:";
        if (m.find()) {
            return m.group(2).split(defaultDelimiters + "|" + m.group(1));
        }
        return text.split(defaultDelimiters);
    }
}
