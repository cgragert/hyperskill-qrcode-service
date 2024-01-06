package qrcodeapi.api.impl;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.api.QrCodeRestResource;
import qrcodeapi.service.QrCodeService;
import qrcodeapi.service.QrCodeType;

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
    public ResponseEntity<BufferedImage> getQrCode(final String contents, final int size, final ErrorCorrectionLevel correction, final QrCodeType type) {
        LOG.info("Content: {}, Size: {}, Correction: {}, Type: {}, ", contents, size, correction, type);
        final BufferedImage qrCode = qrCodeService.createQrCode(size, contents, correction);
        return ResponseEntity.ok().contentType(type.getMediaType()).body(qrCode);
    }
}
