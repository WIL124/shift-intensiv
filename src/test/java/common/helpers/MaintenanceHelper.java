package common.helpers;

import common.request.MaintenanceCreationRequest;
import common.request.MaintenanceInfoRequest;
import common.response.MaintenanceCreationResponse;
import common.response.MaintenanceInfoResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public class MaintenanceHelper {

    public static List<MaintenanceInfoResponse> getMaintenanceInfo(MaintenanceInfoRequest infoRequest) {
        return given()
                .pathParam("userId", infoRequest.getUserId())
                .queryParam("type", infoRequest.getType())
                .when()
                .get("/maintenance/{userId}")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList(".", MaintenanceInfoResponse.class);
    }

    public static MaintenanceCreationResponse createMaintenance(MaintenanceCreationRequest request) {
        return given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/maintenance")
                .then()
                .statusCode(200)
                .extract().as(MaintenanceCreationResponse.class);
    }
}
