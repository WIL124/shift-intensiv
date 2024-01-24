package common.generator;

import common.request.HesoyamRequest;

public class WalletGenerator extends BaseGenerator {
    public static HesoyamRequest generateHesoyamRequest(String userId){
        return HesoyamRequest.builder()
                .userId(userId)
                .amount(RANDOM.nextInt())
                .build();
    }
}
