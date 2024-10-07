package org.hoover;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HooverIntegrationTest {
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void shouldCleanTheRoom(){
        given().contentType(ContentType.JSON)
                .body("""
                    {
                         "roomSize" : [5, 5],
                         "coords" : [1, 2],
                         "patches" : [
                         [1, 0],
                         [2, 2],
                         [2, 3]
                         ],
                         "instructions" : "NNESEESWNWW"
                    }
                """)
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .body("coords", containsInRelativeOrder(1,3))
                .body("patches", equalTo(1));
    }

}
