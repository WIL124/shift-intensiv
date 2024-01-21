package common.helpers;

import common.entity.LoginSession;
import common.entity.Session;
import common.request.LoginRequest;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;

public class SessionHelper {

    public static List<Session> getUserSessions(String userId) {
        return given()
                .pathParam("userId", userId)
                .when()
                .get("/users/{userId}/sessions")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList(".", Session.class);
    }

    public static Session getCurrentUserSession(String userId) {
        return given()
                .pathParam("userId", userId)
                .when()
                .get("/users/{userId}/sessions/current")
                .then()
                .statusCode(200)
                .extract().as(Session.class);
    }

    public static LoginSession loginUser(LoginRequest loginRequest) {
        return given()
                .contentType("application/json")
                .body(loginRequest)
                .when()
                .post("/users/sessions")
                .then()
                .statusCode(200)
                .extract().as(LoginSession.class);
    }

    public static void deleteSession(String sessionId) {
        given()
                .pathParam("id", sessionId)
                .when()
                .delete("/users/sessions/{id}")
                .then()
                .statusCode(200)
                .body(is(emptyString()));
    }
}