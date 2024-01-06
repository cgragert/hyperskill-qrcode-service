package qrcodeapi.api.impl;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.api.QrCodeRestResource;
import qrcodeapi.service.QrCodeService;

import java.awt.image.BufferedImage;

@RestController
@RequiredArgsConstructor
public class QrCodeRestResourceBean implements QrCodeRestResource {

    private final QrCodeService qrCodeService;
    private static final Logger LOG = LoggerFactory.getLogger(QrCodeRestResource.class);

    @Override
    public ResponseEntity<Void> getHealth() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BufferedImage> getQrCode(final @Min(150) @Max(350) int size, final String type) {
        LOG.info("Size: {}, Type: {}", size, type);
        final MediaType mediaType = qrCodeService.getMediaType(type);
        final BufferedImage qrCode = qrCodeService.createQrCode(size);
        return ResponseEntity.ok().contentType(mediaType).body(qrCode);
    }
}
