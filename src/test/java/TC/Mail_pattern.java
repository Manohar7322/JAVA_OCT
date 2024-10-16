package TC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail_pattern {
    public static void main(String[] args) {
        String mail = "manohar_nalluri24@gmail.com";
        Pattern mailPattern = Pattern.compile("^\\w+([._]\\w+)*@[\\w]+\\.[\\w]{2,6}$");
        Matcher matcher = mailPattern.matcher(mail);

        if (matcher.matches()) {
            System.out.println("Valid mail");
        } else {
            System.out.println("Invalid mail");
        }
    }
}
