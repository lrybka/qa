package com.jsystems.qa.qaapi.service.azure;

import com.jsystems.qa.qaapi.model.azure.book.Book;
import com.jsystems.qa.qaapi.specification.Specification;
import io.restassured.RestAssured;

public class BookService {

    public static void postBook(Book book, int statusCode) {
        RestAssured.given()
                .spec(Specification.fakeAzureSpecBuilder())
                .when()
                .body(book)
                .post("api/Books")
                .then()
                .assertThat()
                .statusCode(statusCode)

                ;
    }

}
