package easy;

import common.assertion.CashOperationAssertions;
import common.entity.User;
import common.generator.UserGenerator;
import common.generator.WalletGenerator;
import common.helpers.CashOperationsHelper;
import common.helpers.UserHelper;
import common.helpers.WalletHelper;
import common.request.CreateUserRequest;
import common.request.HesoyamRequest;
import common.request.HistoryRequestType;
import common.request.WalletHistoryRequest;
import common.response.HesoyamResponse;
import common.response.WalletHistoryResponse;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Epic("Cash Operation Management")
public class CashOperationEndpoint extends TestBase {

    private static User CREATED_USER;
    private static HesoyamResponse HESOYAM_RESPONSE;
    private static final CreateUserRequest createUserRequest = UserGenerator.createUserRequest();

    @Before
    public void createUser() {
        CREATED_USER = UserHelper.createUser(createUserRequest);
        Allure.step("Пользователь создан");
        HesoyamRequest hesoyamRequest = WalletGenerator.generateHesoyamRequest(CREATED_USER.getId());
        HESOYAM_RESPONSE = refill(hesoyamRequest);
    }

    @Test
    public void testGetOnceRefilled() {
        List<WalletHistoryResponse> response = CashOperationsHelper.getWalletHistory(WalletHistoryRequest.builder()
                .userId(CREATED_USER.getId())
                .type(HistoryRequestType.REFILL)
                .build()
        );
        Allure.step("История операций получена");
        assertEquals("Found more then 1 operations", 1, response.size());
        CashOperationAssertions.validRefill(response.get(0), HESOYAM_RESPONSE);
    }

    @Test
    public void testGetDoubleRefilled() {
        HesoyamResponse secondRefill = refill(WalletGenerator.generateHesoyamRequest(CREATED_USER.getId()));
        List<WalletHistoryResponse> response = CashOperationsHelper.getWalletHistory(WalletHistoryRequest.builder()
                .userId(CREATED_USER.getId())
                .type(HistoryRequestType.REFILL)
                .build()
        );
        Allure.step("История операций получена");
        assertEquals("Found not 2 operations", 2, response.size());
        CashOperationAssertions.validRefill(response.get(0), HESOYAM_RESPONSE);
        CashOperationAssertions.validRefill(response.get(1), secondRefill);
    }

    private HesoyamResponse refill(HesoyamRequest request) {
        HesoyamResponse response = WalletHelper.hesoyam(request);
        Allure.step("Кошелек пополнен");
        return response;
    }
}
