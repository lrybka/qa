package com.jsystem.qa.qaapi.service;

import com.jsystem.qa.qaapi.User;
import io.restassured.RestAssured;

import java.util.List;

public class UserService {

    public static List<User> getUsers() {
        return RestAssured
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
