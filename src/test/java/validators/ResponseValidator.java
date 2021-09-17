package validators;

import io.restassured.response.ValidatableResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.*;

public class ResponseValidator {

    public static void verifyResponseFieldEqualTo(ValidatableResponse resp, String path, String value) {
        resp.body(path, equalTo(value));
    }

    public static void verifyResponseFieldStartWith(ValidatableResponse resp, String path, String starts) {
        resp.body(path, startsWith(starts)).log().body();;
    }
    public static void verifyResponseFieldMatch(ValidatableResponse resp, String path, String regex) {
        Pattern stringPattern = Pattern.compile(regex);
        resp.body(path, matchesRegex(stringPattern)).log().body();
    }

    public static void verifyStatusCode(ValidatableResponse resp, int expected) {
        resp.statusCode(expected).log().body();
    }
}
