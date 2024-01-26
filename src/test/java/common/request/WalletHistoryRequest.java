package common.request;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletHistoryRequest {
    private String userId;
    @Nullable
    private HistoryRequestType type;
}
