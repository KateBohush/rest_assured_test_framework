package validators;

import io.restassured.response.ValidatableResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.*;

public class ResponseValidator {

    public void verifyResponseFieldEqualTo(ValidatableResponse resp, String path, String value) {
        resp.body(path, equalTo(value));
    }

    public void verifyResponseFieldStartWith(ValidatableResponse resp, String path, String starts) {
        resp.body(path, startsWith(starts));
    }
    public void verifyResponseFieldMatch(ValidatableResponse resp, String path, String regex) {
        Pattern stringPattern = Pattern.compile(regex);
        resp.body(path, matchesRegex(stringPattern));
    }

    public void verifyStatusCode(ValidatableResponse resp, int expected) {
        resp.statusCode(expected);
    }
}
