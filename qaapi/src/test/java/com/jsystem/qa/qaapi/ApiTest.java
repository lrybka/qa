package com.jsystem.qa.qaapi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Tag("ApiTest")
@DisplayName("Api test")
public class ApiTest {

    @Test
    @DisplayName("First api test")
    public void firstApiTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name",equalTo("Piotr"))
                .body("surname",equalTo("Kowalski"));
    }


    @Test
    @DisplayName("Should returns correctly list of users")
    public void shouldReturnListOfUsers(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie",notNullValue())
                .body("[0].imie",equalTo("Piotr"))
                .body("[0].nazwisko",notNullValue())
                .body("[0].nazwisko",equalTo("Kowalski"))
//                .body("[0].device[0].device.model.produce",equalTo("dell"))
                ;
    }

    @Test
    @DisplayName("Should returns correctly list of users using jsonPath mapping")
    public void jsonPathTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class);

    }

}
