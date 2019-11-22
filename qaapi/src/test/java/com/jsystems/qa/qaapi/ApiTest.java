package com.jsystems.qa.qaapi;

import com.jsystems.qa.qaapi.database.UserDao;
import com.jsystems.qa.qaapi.model.azure.author.AzureAuthor;
import com.jsystems.qa.qaapi.model.azure.book.Book;
import com.jsystems.qa.qaapi.model.device.User;
import com.jsystems.qa.qaapi.model.error.ErrorResponse;
import com.jsystems.qa.qaapi.model.user.MyUser;
import com.jsystems.qa.qaapi.model.user.UserAzure;
import com.jsystems.qa.qaapi.model.user.UserDb;
import com.jsystems.qa.qaapi.service.api.ApiService;
import com.jsystems.qa.qaapi.service.azure.AuthorService;
import com.jsystems.qa.qaapi.service.azure.BookService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("ApiTest")
@DisplayName("Api test")
public class ApiTest {

    @Test
    @DisplayName("First api test")
    public void firstApiTest() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));
    }

    @Test
    @DisplayName("Should returns correctly list of users")
    public void shouldReturnsListOfUsers() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", notNullValue())
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko",notNullValue())
                .body("[0].nazwisko",equalTo("Kowalski"))
//                .body("[0].device[0].device.model.produce", equalTo("dell"))
        ;
    }

    @Test
    @DisplayName("Should returns correctly list of users using jsonPath mapping")
    public void jsonPathTest() {
        List<User> users = ApiService.getUsers();

        assertTrue(users.get(0).imie.equals("Piotr"));
        assertTrue(users.get(0).nazwisko.equals("Kowalski"));
        assertTrue(users.get(0).device.get(0).type.equals("computer"));
        assertTrue(users.get(0).device.get(0).deviceModel.get(0).screenSize == 17);
        assertTrue(users.size() > 0);
    }

    @Test
    @DisplayName("Test with mapped of MyUser")
    public void myUserJsonPath() {
        MyUser myUserWithQuery = ApiService.getUserWithQueryParam("Piotr",  "Kowalski");
        MyUser myUserWitrhPathVariable = ApiService.getUserWithPathVariable(2L,  5);
        MyUser myUser = ApiService.getUser();

        assertThat(myUser.name).isEqualTo("Piotr");
        assertThat(myUser.surname).isEqualTo("Kowalski");

        assertThat(myUserWithQuery.name).isEqualTo("Piotr");
    }

    @Test
    @DisplayName("Post test")
    public void postTest() {
        String[] strings = ApiService.postMyUser(new MyUser("Piotr", "Kowalski"));
        assertThat(strings).isEmpty();
    }

    @Test
    @DisplayName("Error response")
    public void errorResponse() {
        ErrorResponse errorResponse = ApiService.getErrorResponse();

        assertThat(errorResponse.error.errorCode).isEqualTo(400);
        assertThat(errorResponse.error.validationError).isEqualTo("invalid_email");
        assertThat(errorResponse.error.message).isEqualTo("your email is invalid");
    }

    @Test
    public void azureUser(){

        UserAzure userAzure = ApiService.getUserAzureById(1);

        assertThat(userAzure.id).isEqualTo(1);
        assertThat(userAzure.userName).isEqualTo("User 1");
        assertThat(userAzure.password).isEqualTo("Password1");
    }

    @Test
    @Disabled
    public void dbTest() {


        UserDb userDb = UserDao.getOneById(1L);
        assertThat(userDb.getName()).isEqualTo("Piotr");

            System.out.println(UserDao.getOneById(1L).getId() + ": " + UserDao.getOneById(1L).getName() + "." + UserDao.getOneById(1L).getSurname());
            System.out.println(UserDao.getOneById(2L).getId() + ": " + UserDao.getOneById(2L).getName() + "." + UserDao.getOneById(2L).getSurname());
            System.out.println(UserDao.getOneById(3L).getId() + ": " + UserDao.getOneById(3L).getName() + "." + UserDao.getOneById(3L).getSurname());

        }

    @Test
    @DisplayName("Get azure authors")
    public void shouldReturnAllAzureAuthorsLst(){
        List<AzureAuthor> azureAuthors = AuthorService.getAzureAuthors();

        assertThat(azureAuthors.size()).isGreaterThan(0);


        for (AzureAuthor azureAuthor : azureAuthors) {
            int firstNameId = Integer.parseInt(azureAuthor.firstName.replace("First Name ", ""));
            assertThat(azureAuthor.firstName).contains("First Name ");
            assertThat(azureAuthor.firstName).matches("First Name \\d*");
            assertTrue(azureAuthor.id == firstNameId);
        }

    }

    @Test
    @DisplayName("POST Book test")
    public void postBookTest(){

        Book book = new Book(1,"Jsystems", "Szkolenia", 382, "en", "2019-11-22T09:41:54.400Z");
        BookService.postBook(book, 200);

    }


    @Test
    @DisplayName("Get all users")
    public void getAllUserDb(){
        List<UserDb> userDbs = UserDao.getAllUsers();
        System.out.println(userDbs);

    }

    @Test
    @DisplayName("Save user DB")
    public void saveUserDb(){
        UserDb userDb = new UserDb(6L, "Arnold", "Kowalski");
        UserDao.SaveUser(userDb);

        UserDb userdb_1 = UserDao.getOneById(6L);

        assertTrue(userdb_1.getId() == userDb.getId());
        assertTrue(userdb_1.getName().equals(userDb.getName()));
        assertTrue(userdb_1.getSurname().equals(userDb.getSurname()));

        UserDao.deleteUser(userdb_1.getId());

    }
}