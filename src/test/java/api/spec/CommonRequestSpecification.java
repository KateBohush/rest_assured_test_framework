package api.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

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

    public static RequestSpecification getSpecWithPathParam(String path, Map<String, String> pathParam) {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri(URI)
                .setContentType(ContentType.JSON)
                .setBasePath(path)
                .build();
        pathParam.forEach((k, v) -> spec.pathParam(k, v));
        return spec;
    }
    public static RequestSpecification getSpecWithQueryParam(String path, Map<String, String> pathParam) {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri(URI)
                .setContentType(ContentType.JSON)
                .setBasePath(path)
                .build();
        pathParam.forEach((k, v) -> spec.queryParam(k, v));
        return spec;
    }


}
