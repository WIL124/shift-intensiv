package easy;

import common.assertion.UserAssertions;
import common.entity.User;
import common.generator.UserGenerator;
import common.helpers.UserHelper;
import common.request.CreateUserRequest;
import common.request.PatchUserRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserEndpointTest extends TestBase {

    private static User user;
    private static final CreateUserRequest createUserRequest = UserGenerator.createUserRequest();

    @BeforeAll
    static void createUser() {
        user = UserHelper.createUser(createUserRequest);
    }

    @Test
    public void successCreateUser() {
        UserAssertions.validCreation(user, createUserRequest);
    }

    @Test
    public void successGetUser() {
        User actual = UserHelper.getUserById(user.getId());
        assertEquals(user, actual);
    }

    @Test
    public void successPatchUser() {
        PatchUserRequest request = UserGenerator.createPatchRequest();
        User actual = UserHelper.patchUser(request);
        UserAssertions.validUpdate(user, request, actual);
    }
}
