package qrcodeapi.api.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.api.QrCodeRestResource;
import qrcodeapi.service.QrCode;
import qrcodeapi.service.QrCodeService;

import java.awt.image.BufferedImage;

@RestController
@RequiredArgsConstructor
public class QrCodeRestResourceBean implements QrCodeRestResource {

    private final QrCodeService qrCodeService;

    @Override
    public ResponseEntity<Void> getHealth() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BufferedImage> getQrCode() {
        final QrCode qrCode = qrCodeService.getQrCode();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode.getImage());
    }
}
