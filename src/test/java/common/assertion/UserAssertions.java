package common.assertion;

import common.entity.User;
import common.request.CreateUserRequest;
import common.request.PatchUserRequest;
import io.qameta.allure.Allure;

import static org.junit.Assert.*;

public class UserAssertions {

    public static void validCreation(User user, CreateUserRequest createUserRequest) {
        assertEquals("First name mismatch", createUserRequest.getFirstName(), user.getFirstName());
        assertEquals("Last name mismatch", createUserRequest.getLastName(), user.getLastName());
        assertEquals("Email mismatch", createUserRequest.getEmail(), user.getEmail());
        assertEquals("Age mismatch", createUserRequest.getAge(), user.getAge());
        assertEquals("Phone mismatch", createUserRequest.getPhone(), user.getPhone());
        assertNotNull("User ID is null", user.getId());
        assertNotNull("Registration date is null", user.getRegistrationDate());
        assertNotNull("Last update date is null", user.getLastUpdateDate());
        assertNotNull("Wallet ID is null", user.getWalletId());
        assertNotNull("Full name is null", user.getFullName());
        assertEquals("Registration date and last update date mismatch", user.getRegistrationDate(), user.getLastUpdateDate());
        assertEquals("Full name mismatch", createUserRequest.getFirstName() + " " + createUserRequest.getLastName(), user.getFullName());
        Allure.step("Проверка соответствия запроса и ответа пройдена");
    }

    public static void validUpdate(User user, PatchUserRequest request, User actual) {
        assertEquals("First name mismatch", request.getFirstName(), actual.getFirstName());
        assertEquals("Last name mismatch", request.getLastName(), actual.getLastName());
        assertEquals("Email mismatch", request.getEmail(), actual.getEmail());
        assertEquals("Full name mismatch", actual.getFullName(), request.getFullName());
        assertTrue("Last update date is not updated", actual.getLastUpdateDate().before(user.getLastUpdateDate()));
        Allure.step("Проверка соответствия запроса и ответа пройдена");
    }
}
