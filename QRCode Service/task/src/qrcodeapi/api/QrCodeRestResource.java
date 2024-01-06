package qrcodeapi.api;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.BufferedImage;

import static qrcodeapi.api.config.ApiConstant.*;

@RequestMapping(path = "api")
@Validated
public interface QrCodeRestResource {
    @GetMapping(path = "health")
    ResponseEntity<Void> getHealth();

    @GetMapping(path = "qrcode")
    ResponseEntity<BufferedImage> getQrCode(
            @RequestParam @Min(value = 150, message = ERROR_SIZE) @Max(value = 350, message = ERROR_SIZE) final int size,
            @RequestParam @Pattern(regexp = "jpeg|gif|png", message = ERROR_TYPE) final String type,
            @RequestParam @NotBlank(message = ERROR_CONTENTS) final String contents);
}
