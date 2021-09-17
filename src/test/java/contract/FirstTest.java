package contract;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class FirstTest {

    @Test
    public void restGetAll() {
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
    public void restGetSingle() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .basePath("/api/users/{id}")
                .pathParam("id", 2)
                .log().body()
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
    public void restPut() {
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
//                  PUT created user id here
                .basePath("/api/users/{id}}")
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
