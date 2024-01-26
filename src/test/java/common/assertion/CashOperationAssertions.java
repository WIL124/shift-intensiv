package common.assertion;

import common.request.HistoryRequestType;
import common.response.HesoyamResponse;
import common.response.WalletHistoryResponse;
import io.qameta.allure.Allure;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CashOperationAssertions {

    public static void validRefill(WalletHistoryResponse walletHistoryResponse, HesoyamResponse hesoyamResponse) {
        assertEquals("User id mismatch", walletHistoryResponse.getId(), hesoyamResponse.getUserId());
        assertEquals("Amount mismatch", walletHistoryResponse.getAmount(), hesoyamResponse.getAmount());
        assertEquals("Transaction type mismatch", walletHistoryResponse.getType(), HistoryRequestType.REFILL.getValue());
        assertEquals("Transaction date is not now", walletHistoryResponse.getTransactionDate(), new Date());
        assertNull("Maintenance number is not null for refill", walletHistoryResponse.getMaintenanceNumber());
        assertNull("Receiver phone is not null for refill", walletHistoryResponse.getReceiverPhone());
        assertEquals("Status is not 'success'", "success", walletHistoryResponse.getStatus());
        Allure.step("Проверка соответствия запроса и ответа пройдена");
    }
}
