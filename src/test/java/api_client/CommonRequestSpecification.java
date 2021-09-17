package api_client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonRequestSpecification {
    private final static String URI = "https://reqres.in";

    public static RequestSpecification getCommonSpec(String path) {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri(URI)
                .setContentType(ContentType.JSON)
                .setBasePath(path)
                .build();
        return spec;
    }


}
