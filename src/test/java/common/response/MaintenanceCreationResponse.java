package common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceCreationResponse {
    private String id;
    private Long maintenanceNumber;
    private String status;
}
