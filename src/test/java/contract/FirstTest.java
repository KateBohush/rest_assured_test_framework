package contract;

import api.client.GetRequests;
import api.client.PostRequest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.User;
import org.testng.annotations.Test;

import java.util.HashMap;

import static api.spec.CommonRequestSpecification.getSpecWithPathParam;
import static api.spec.CommonResponseSpecification.bodyEqualSpec;
import static api.spec.CommonResponseSpecification.statusCodeSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static validators.ResponseValidator.validateJsonSchema;
import static validators.ResponseValidator.verifyResponseFieldEqualTo;

public class FirstTest {

    @Test
    public void restGetAll() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .basePath("/api/users")
                .param("page", 2)
                .log().uri()
                .when()
                .get()
                .then()
                .statusCode(200)
                .time(lessThan(5000L))
                .log()
                .body();

    }

    @Test
    public void contractTesting() {
        HashMap queryParam = new HashMap<String, String>() {{
            put("page", "2");
        }};
        ValidatableResponse resp = new GetRequests().getWithQueryParamRequest("/api/users", queryParam);
        validateJsonSchema(resp, "usersResponseSchema.json");
    }

    @Test
    public void restPost() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .basePath("/api/users")
                .log().uri()
                .when()
                .body("{\"name\": \"morpheus\",\"job\": \"leader\"}")
                .post()
                .then()
                .statusCode(201)
                .log()
                .body();

    }

    @Test
    public void restPostWithModel() {
        User user = User.builder().name("Kateryna").job("Tester").build();
        ValidatableResponse resp = new PostRequest().postRequestWithObject("/api/users", user);
        verifyResponseFieldEqualTo(resp, "name", "Kateryna");
    }

    @Test
    public void restGetSingle() {
        given().spec(getSpecWithPathParam("/api/users/{id}", new HashMap<String, String>() {{
            put("id", "2");
        }}))
                .log().uri()
                .when()
                .get()
                .then()
                .spec(statusCodeSpec(200))
                .spec(bodyEqualSpec("data.first_name", "Janet"))
                .log()
                .body();

    }

    @Test
    public void restGetSingleRefactored() {
        HashMap pathParam = new HashMap<String, String>() {{
            put("id", "2");
        }};
        ValidatableResponse resp = new GetRequests().getRequest("/api/users/{id}", pathParam);
        verifyResponseFieldEqualTo(resp, "data.first_name", "Janet");
    }

    @Test
    public void restPut() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
//                  PUT created user id here
                .basePath("/api/users/{id}")
                .pathParam("id", 98)
                .log().body()
                .when()
                .body("{\"name\": \"Jessica\",\"job\": \"Tester\"}")
                .put()
                .then()
                .statusCode(200)
                .log()
                .body();

    }

    @Test
    public void restDelete() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
//                PUT created user id here
                .basePath("/api/users/{id}")
                .pathParam("id", 98)
                .log().body()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .log()
                .body();

    }
}
