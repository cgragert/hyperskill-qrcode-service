package qrcodeapi.api.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiConstant {
    public static final String ERROR_SIZE = "Image size must be between 150 and 350 pixels";
    public static final String ERROR_CONTENTS = "Contents cannot be null or blank";
    public static final String ERROR_TYPE = "Only png, jpeg and gif image types are supported";
    public static final String ERROR_CORRECTION = "Permitted error correction levels are L, M, Q, H";
}
