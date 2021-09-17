package api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.equalTo;

public class CommonResponseSpecification {

    public static ResponseSpecification statusCodeSpec(int statusCode) {
        ResponseSpecification spec = new ResponseSpecBuilder().expectStatusCode(statusCode)
                .build();
        return spec;
    }

    public static ResponseSpecification bodyEqualSpec(String gsonPath, String value) {
        ResponseSpecification spec = new ResponseSpecBuilder().expectBody(gsonPath, equalTo(value))
                .build();
        return spec;
    }


}
