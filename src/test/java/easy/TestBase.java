package easy;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = Constants.LOCALHOST_URL;
    }
}
