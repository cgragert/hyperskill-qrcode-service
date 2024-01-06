package qrcodeapi.api.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.api.QrCodeRestResource;

@RestController
public class QrCodeRestResourceBean implements QrCodeRestResource {

    @Override
    public ResponseEntity<Void> getHealth() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> getQrCode() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
