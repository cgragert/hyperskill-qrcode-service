package qrcodeapi.api.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import qrcodeapi.service.QrCodeType;

@Component
public class StringToQrCodeTypeConverter implements Converter<String, QrCodeType> {
    @Override
    public QrCodeType convert(final String type) {
        return switch (type) {
            case "jpeg" -> QrCodeType.JPEG;
            case "png" -> QrCodeType.PNG;
            case "gif" -> QrCodeType.GIF;
            default -> null;
        };
    }
}
