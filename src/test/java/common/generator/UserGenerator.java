package common.generator;

import common.request.CreateUserRequest;
import common.request.PatchUserRequest;

public class UserGenerator extends BaseGenerator {

    public static CreateUserRequest createUserRequest() {
        return CreateUserRequest.builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .age(25)
                .phone(79997290001L)
                .email("ivanov@mail.ru")
                .build();
    }

    public static PatchUserRequest createPatchRequest() {
        return PatchUserRequest.builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .email("sidorov@mail.ru")
                .build();
    }
}
