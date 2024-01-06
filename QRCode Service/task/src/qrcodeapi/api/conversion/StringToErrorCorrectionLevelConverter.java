package qrcodeapi.api.conversion;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToErrorCorrectionLevelConverter implements Converter<String, ErrorCorrectionLevel> {
    @Override
    public ErrorCorrectionLevel convert(final String source) {
        try {
            return ErrorCorrectionLevel.valueOf(source);
        } catch (Exception e) {
            return null;
        }
    }
}
