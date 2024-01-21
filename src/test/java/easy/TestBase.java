package easy;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = Constants.LOCALHOST_URL;
    }
}
