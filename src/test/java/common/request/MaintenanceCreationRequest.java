package common.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenanceCreationRequest {
    private String userId;
    private Long phone;
    private Long amount;
    private String comment;
}
