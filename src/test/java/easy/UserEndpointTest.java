package easy;

import common.assertion.UserAssertions;
import common.entity.User;
import common.generator.UserGenerator;
import common.helpers.UserHelper;
import common.request.CreateUserRequest;
import common.request.PatchUserRequest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Epic("User Management")
public class UserEndpointTest extends TestBase {

    protected static User CREATED_USER;
    private static final CreateUserRequest createUserRequest = UserGenerator.createUserRequest();

    @Before
    public void createUser() {
        CREATED_USER = UserHelper.createUser(createUserRequest);
        Allure.step("Пользователь создан");
    }

    @Test
    @Feature("Создание пользователя")
    @Description("Test to verify successful user creation")
    public void successCreateUser() {
        UserAssertions.validCreation(CREATED_USER, createUserRequest);
    }

    @Test
    @Feature("Получение пользователя по id")
    @Description("Test to verify successful retrieval of user")
    public void successGetUser() {
        User actual = UserHelper.getUserById(CREATED_USER.getId());
        assertEquals(CREATED_USER, actual);
        Allure.step("Пользователь получен");
    }

    @Test
    @Feature("Обновление пользователя")
    @Description("Test to verify successful patching of user")
    public void successPatchUser() {
        PatchUserRequest request = UserGenerator.createPatchRequest();
        User actual = UserHelper.patchUser(request);
        UserAssertions.validUpdate(CREATED_USER, request, actual);
    }
}
