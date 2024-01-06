package qrcodeapi.service;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QrCodeService {

    public BufferedImage createQrCode(
            final int size,
            @NotNull final String contents,
            @NotNull final ErrorCorrectionLevel errorCorrectionLevel) {
        return new QrCodeBuilder()
                .setSize(size)
                .setText(contents)
                .setErrorCorrectionLevel(errorCorrectionLevel)
                .build();
    }
}
