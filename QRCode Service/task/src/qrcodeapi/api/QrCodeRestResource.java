package qrcodeapi.api;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.BufferedImage;

@RequestMapping(path = "api")
@Validated
public interface QrCodeRestResource {

    @GetMapping(path = "health")
    ResponseEntity<Void> getHealth();

    @GetMapping(path = "qrcode")
    ResponseEntity<BufferedImage> getQrCode(
            @RequestParam @Min(150) @Max(350) final int size,
            @RequestParam final String type);
}
