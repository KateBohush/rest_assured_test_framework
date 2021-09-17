package api.client;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static api.spec.CommonRequestSpecification.getSpecWithPathParam;
import static api.spec.CommonRequestSpecification.getSpecWithQueryParam;
import static io.restassured.RestAssured.given;

public class GetRequests {

    public ValidatableResponse getRequest(String resourcePath, HashMap<String, String> pathParam) {
        return  given().spec(getSpecWithPathParam(resourcePath, pathParam))
                .log().uri()
                .when()
                .get()
                .then();
    }
    public ValidatableResponse getWithQueryParamRequest(String resourcePath, HashMap<String, String> pathParam) {
        return  given().spec(getSpecWithQueryParam(resourcePath, pathParam))
                .log().uri()
                .when()
                .get()
                .then();
    }
}
