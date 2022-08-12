package br.com.bb.bb;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class HelloWorldResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/v1/hello")
                .then()
                .statusCode(200)
                .body(containsString("hello world!") );
    }

//    @Test
//    public void testHelloNameEndpoint() {
//        given()
//                .when().get("/api/v1/hello/{name}")
//                .then()
//                .statusCode(200)
//                .body(containsString("hello world! ") );
//    }

}