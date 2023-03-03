package CodingChallenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(regExp("aa", ".*"));
    }

    public static boolean regExp(String s, String p) {
        Matcher matcher;
        Pattern pattern = Pattern.compile(p);

        matcher = pattern.matcher(s);

        return matcher.matches();
    }

    public static boolean customRegExp(String s, String p) {
        return false;
    }
}
