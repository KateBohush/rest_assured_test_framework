package contract;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class FirstTest {

    @Test
    public void restGet() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .basePath("/api/users")
                .param("page", 2)
                .log().body()
                .when()
                .get()
                .then()
                .statusCode(200)
                .time(lessThan(5000L))
                .log()
                .body();

    }

    @Test
    public void restPost() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .basePath("/api/users")
                .log().body()
                .when()
                .body("{\"name\": \"morpheus\",\"job\": \"leader\"}")
                .post()
                .then()
                .statusCode(201)
                .log()
                .body();

    }
    @Test
    public void restDelete() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
//                PUT created user id here
                .basePath("/api/users/268")
                .log().body()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .log()
                .body();

    }
}
