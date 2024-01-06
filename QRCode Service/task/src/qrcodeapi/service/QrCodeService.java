package qrcodeapi.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QrCodeService {

    public BufferedImage createQrCode(final int size, final String contents) {
        return new QrCodeBuilder()
                .setSize(size)
                .setText(contents)
                .build();
    }

    public MediaType getMediaType(final String type) {
        return switch (type.toLowerCase()) {
            case "jpeg" -> MediaType.IMAGE_JPEG;
            case "png" -> MediaType.IMAGE_PNG;
            case "gif" -> MediaType.IMAGE_GIF;
            default -> throw new IllegalStateException();
        };
    }
}
