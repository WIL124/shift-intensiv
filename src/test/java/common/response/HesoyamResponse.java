package common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HesoyamResponse {
    private String userId;
    private String billId;
    private long amount;
}
