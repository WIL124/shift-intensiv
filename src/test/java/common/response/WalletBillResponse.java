package common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletBillResponse {
    private String id;
    private long amount;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date lastUpdate;
}
