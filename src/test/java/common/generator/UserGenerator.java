package common.generator;

import common.request.CreateUserRequest;
import common.request.PatchUserRequest;

public class UserGenerator {

    public static CreateUserRequest createUserRequest() {
        return CreateUserRequest.builder()
                .firstName("Иван")
                .lastName("Иванов")
                .age(25)
                .phone(79997290001L)
                .email("ivanov@mail.ru")
                .build();
    }

    public static PatchUserRequest createPatchRequest() {
        return PatchUserRequest.builder()
                .firstName("Сидор")
                .lastName("Сидоров")
                .email("sidorov@mail.ru")
                .build();
    }
}
