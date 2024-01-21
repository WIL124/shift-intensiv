package common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletHistoryResponse {
    private String id;
    private String userId;
    private long amount;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date transactionDate;

    private String type;
    private Long receiverPhone; // optional. Used for type = transfer
    private Long maintenanceNumber; // optional. Used for type = payment
    private String status;
}
