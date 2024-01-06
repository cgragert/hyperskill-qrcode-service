package qrcodeapi.api.impl;

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
    private static final Logger LOG = LoggerFactory.getLogger(QrCodeRestResourceBean.class);

    @Override
    public ResponseEntity<Void> getHealth() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BufferedImage> getQrCode(final int size, final String type, final String contents) {
        LOG.info("Size: {}, Type: {}, Content: {}", size, type, contents);
        final MediaType mediaType = qrCodeService.getMediaType(type);
        final BufferedImage qrCode = qrCodeService.createQrCode(size, contents);
        return ResponseEntity.ok().contentType(mediaType).body(qrCode);
    }
}
