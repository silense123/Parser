import java.util.regex.Pattern;

public class Regular {
    public static Pattern PATTERN = Pattern.compile(
            "(\\w*)" + //appName
                    "\\s*\\|\\s*" +
                    "(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})" + //requestDate
                    "\\s*\\[" +
                    "(\\w*)" + //requestId
                    "\\]\\s*" +
                    "(\\w*)" + //logLevel
                    ":\\s*" +
                    "(" +    //IP
                    "(?>2[0-5][0-9]|1[0-9][0-9]|[1-9]?[0-9])" + //num 1
                    "\\." +
                    "(?>2[0-5][0-9]|1[0-9][0-9]|[1-9]?[0-9])" + //num 2
                    "\\." +
                    "(?>2[0-5][0-9]|1[0-9][0-9]|[1-9]?[0-9])" + //num 3
                    "\\." +
                    "(?>2[0-5][0-9]|1[0-9][0-9]|[1-9]?[0-9])" + //num 4
                    ")" +
                    "\\s+" +
                    //URL:
                    "(?>" +
                    "(\\w*)" + //protocol
                    ":\\/\\/" +
                    "([\\w\\.]*)" + //hostName
                    "\\/" +
                    "(?>" +
                    "(?>cart\\?)(.*))?" + // put good in cart (result would be like: goods_id=8&amount=1&cart_id=8642)
                    "(?>(?>pay\\?)(.*))?" + // pay cart (result would be like: user_id=81270149216&cart_id=8642)
                    "(?>(?>success_pay_)(\\d*)(?>\\/))?" + // successful payment (result would be like: "8642" - is a cart_id)
                    "(?>(\\w*)(?>\\/))?" + //category (example: frozen_fish)
                    "(?>(\\w*)(?>\\/))?)"  //good     (example: shark)
    );

}