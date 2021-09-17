package config;

import io.restassured.RestAssured;

public class Configuration {

    static {
        RestAssured.baseURI ="";
        RestAssured.proxy("10.11.2112.55");
        RestAssured.basic("username", "password");
        RestAssured.certificate(".mycertificates", "passwordForCertificate");
    }
}
