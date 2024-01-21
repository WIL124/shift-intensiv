package common.assertion;

import common.entity.User;
import common.request.CreateUserRequest;
import common.request.PatchUserRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAssertions {
    public static void validCreation(User user, CreateUserRequest createUserRequest){
        assertAll(
                () -> assertEquals(createUserRequest.getFirstName(), user.getFirstName()),
                () -> assertEquals(createUserRequest.getLastName(), user.getLastName()),
                () -> assertEquals(createUserRequest.getEmail(), user.getEmail()),
                () -> assertEquals(createUserRequest.getAge(), user.getAge()),
                () -> assertEquals(createUserRequest.getPhone(), user.getPhone()),
                () -> assertEquals(createUserRequest.getFirstName(), user.getFirstName()),
                () -> assertNotNull(user.getId()),
                () -> assertNotNull(user.getRegistrationDate()),
                () -> assertNotNull(user.getLastUpdateDate()),
                () -> assertNotNull(user.getWalletId()),
                () -> assertNotNull(user.getFullName()),
                () -> assertEquals(user.getRegistrationDate(), user.getLastUpdateDate()),
                () -> assertEquals(createUserRequest.getFirstName() + " " + createUserRequest.getLastName(), user.getFullName())
        );
    }

    public static void validUpdate(User user, PatchUserRequest request, User actual) {
        assertAll(
                () -> assertEquals(request.getFirstName(), actual.getFirstName()),
                () -> assertEquals(request.getLastName(), actual.getLastName()),
                () -> assertEquals(request.getEmail(), actual.getEmail()),
                () -> assertEquals(actual.getFullName(), request.getFullName()),
                () -> assertTrue(actual.getLastUpdateDate().before(user.getLastUpdateDate()))
        );
    }
}
