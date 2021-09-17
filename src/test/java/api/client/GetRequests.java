package api.client;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static api.spec.CommonRequestSpecification.getSpecWithParam;
import static io.restassured.RestAssured.given;

public class GetRequests {

    public ValidatableResponse getRequest(String resourcePath, HashMap<String, String> pathParam) {
        return  given().spec(getSpecWithParam(resourcePath, pathParam))
                .log().uri()
                .when()
                .get()
                .then();
    }
}
