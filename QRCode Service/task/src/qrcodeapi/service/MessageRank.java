package qrcodeapi.service;

import lombok.Getter;
import qrcodeapi.api.config.ApiConstant;

import java.util.Arrays;

@Getter
public enum MessageRank {

    CONTENTS(3, ApiConstant.ERROR_CONTENTS),
    SIZE(2, ApiConstant.ERROR_SIZE),
    CORRECTION(1, ApiConstant.ERROR_CORRECTION),
    TYPE(0, ApiConstant.ERROR_TYPE);

    private final int rank;
    private final String message;

    MessageRank(final int rank, final String message) {
        this.rank = rank;
        this.message = message;
    }

    public static MessageRank getMinRank() {
        return TYPE;
    }

    public static MessageRank getByMessage(String message) {
        return Arrays.stream(values()).filter(e -> e.getMessage().equals(message)).findFirst().orElseThrow();
    }

    public boolean isMax() {
        return this == CONTENTS;
    }
}
