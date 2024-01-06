package qrcodeapi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "api")
public interface QrCodeRestResource {

    @GetMapping(path = "health")
    ResponseEntity<Void> getHealth();

    @GetMapping(path = "qrcode")
    ResponseEntity<Void> getQrCode();
}
