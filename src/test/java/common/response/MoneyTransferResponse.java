package common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoneyTransferResponse {
    private String id;
    private String userId;
    private Wallet wallet;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Wallet {
        private String id;
        private Long amount;
    }
}
