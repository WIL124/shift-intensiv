package common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceInfoResponse {
    private String id;
    private String type;
    private long amount;
    private long maintenanceNumber;
    private String status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date transactionDate;
}
