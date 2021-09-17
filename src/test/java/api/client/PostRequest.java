package api.client;

import io.restassured.response.ValidatableResponse;

import static api.spec.CommonRequestSpecification.getCommonSpec;
import static io.restassured.RestAssured.given;

public class PostRequest {

    public ValidatableResponse postRequest(String resourcePath, String body) {
        return given().spec(getCommonSpec(resourcePath))
                .when()
                .body(body)
                .log().body()
                .post()
                .then();
    }
}
