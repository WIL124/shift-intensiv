package common.helpers;

import common.request.HesoyamRequest;
import common.response.HesoyamResponse;
import common.response.WalletBillResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class WalletHelper {

    public static WalletBillResponse getWalletBill(String userId) {
        Response response = given()
                .pathParam("userId", userId)
                .when()
                .get("/wallet/bill/{userId}");

        return response.then()
                .statusCode(200)
                .extract().as(WalletBillResponse.class);
    }

    public static HesoyamResponse hesoyam(HesoyamRequest hesoyamRequest) {
        return given()
                .contentType("application/json")
                .body(hesoyamRequest)
                .when()
                .post("/hesoyam")
                .then()
                .statusCode(200)
                .extract().as(HesoyamResponse.class);
    }

}
