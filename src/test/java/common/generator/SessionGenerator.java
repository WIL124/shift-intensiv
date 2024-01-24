package common.generator;

import common.request.LoginRequest;

public class SessionGenerator extends BaseGenerator {
    public static LoginRequest createLoginRequest() {
        return LoginRequest.builder()
                .build();
    }
}
