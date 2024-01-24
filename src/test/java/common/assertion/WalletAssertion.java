package common.assertion;

import common.request.HesoyamRequest;
import common.response.HesoyamResponse;
import common.response.WalletBillResponse;
import io.qameta.allure.Allure;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WalletAssertion {
    public static void validHesoyam(HesoyamRequest request, HesoyamResponse response) {
        assertEquals("User id mismatch", request.getUserId(), response.getUserId());
        assertEquals("Last name mismatch", request.getAmount(), response.getAmount());
        assertNotNull("Bill id is null", response.getBillId());
        Allure.step("Проверка соответствия запроса и ответа пройдена");
    }

    public static void validBill(WalletBillResponse walletBillResponse, HesoyamResponse response) {
        assertEquals("Update date not now", walletBillResponse.getLastUpdate(), new Date());
        assertEquals("Amount mismatch", walletBillResponse.getAmount(), response.getAmount());
        assertNotNull("Id is null", walletBillResponse.getId());
        Allure.step("Баланс кошелька совпадает с пополнением");
    }
}
