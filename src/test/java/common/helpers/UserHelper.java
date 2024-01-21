package common.helpers;

import common.request.CreateUserRequest;
import common.request.PatchUserRequest;
import common.entity.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserHelper {

    public static User createUser(CreateUserRequest request) {
        Response response = given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/users");

        return response.then()
                .statusCode(200)
                .extract().as(User.class);
    }

    public static User getUserById(String userId) {
        return given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .extract().as(User.class);
    }

    public static User patchUser(PatchUserRequest request) {
        return given()
                .contentType("application/json")
                .body(request)
                .when()
                .patch("/users")
                .then()
                .statusCode(200)
                .extract().as(User.class);
    }
}