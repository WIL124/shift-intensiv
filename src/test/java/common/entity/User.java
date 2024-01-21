package common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String walletId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private long phone;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date registrationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date lastUpdateDate;

    private int age;

}
