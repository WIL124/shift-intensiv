package easy;

import common.assertion.WalletAssertion;
import common.entity.User;
import common.generator.UserGenerator;
import common.generator.WalletGenerator;
import common.helpers.UserHelper;
import common.helpers.WalletHelper;
import common.request.HesoyamRequest;
import common.response.HesoyamResponse;
import common.response.WalletBillResponse;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Before;
import org.junit.Test;

@Epic("Wallet Management")
public class WallerEndpointTest extends TestBase {
    private User USER;
    private HesoyamRequest REQUEST;

    @Before
    public void init() {
        USER = UserHelper.createUser(UserGenerator.createUserRequest());
        Allure.step("Пользователь создан");
        REQUEST = WalletGenerator.generateHesoyamRequest(USER.getId());
    }

    @Test
    @Feature("HESOYAM")
    public void hesoyam() {
        HesoyamResponse response = sendHesoyam(REQUEST);
        WalletAssertion.validHesoyam(REQUEST, response);
    }

    @Test
    @Feature("Получение баланса кошелька")
    public void getBill() {
        HesoyamResponse response = sendHesoyam(REQUEST);
        WalletBillResponse walletBillResponse = WalletHelper.getWalletBill(USER.getId());
        Allure.step("Баланс кошелька получен");
        WalletAssertion.validBill(walletBillResponse, response);
    }

    private HesoyamResponse sendHesoyam(HesoyamRequest request) {
        HesoyamResponse response = WalletHelper.hesoyam(request);
        Allure.step("Кошелек пополнен");
        return response;
    }
}
