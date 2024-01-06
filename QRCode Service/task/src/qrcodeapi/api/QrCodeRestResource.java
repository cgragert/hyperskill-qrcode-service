package qrcodeapi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;

@RequestMapping(path = "api")
public interface QrCodeRestResource {

    @GetMapping(path = "health")
    ResponseEntity<Void> getHealth();

    @GetMapping(path = "qrcode")
    ResponseEntity<BufferedImage> getQrCode();
}
