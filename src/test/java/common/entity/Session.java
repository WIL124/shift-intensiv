package common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Session {
    private String id;
    private String userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expirationTime;

    private boolean active;
}