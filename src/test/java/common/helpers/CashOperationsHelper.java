package common.helpers;

import common.request.MoneyTransferRequest;
import common.request.WalletHistoryRequest;
import common.response.MoneyTransferResponse;
import common.response.WalletHistoryResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CashOperationsHelper {
    public static List<WalletHistoryResponse> getWalletHistory(WalletHistoryRequest historyRequest) {
        return given()
                .pathParam("userId", historyRequest.getUserId())
                .queryParam("type", historyRequest.getType().getValue())
                .when()
                .get("/history/{userId}")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList(".", WalletHistoryResponse.class);
    }

    public static MoneyTransferResponse transferMoney(MoneyTransferRequest transferRequest) {
        return given()
                .contentType("application/json")
                .body(transferRequest)
                .when()
                .post("/transfers")
                .then()
                .statusCode(200)
                .extract().as(MoneyTransferResponse.class);
    }
}
