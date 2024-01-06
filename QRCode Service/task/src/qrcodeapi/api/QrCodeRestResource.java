package qrcodeapi.api;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qrcodeapi.api.validation.EnumValue;
import qrcodeapi.service.QrCodeType;

import java.awt.image.BufferedImage;

import static qrcodeapi.api.config.ApiConstant.*;

@RequestMapping(path = "api")
@Validated
public interface QrCodeRestResource {
    @GetMapping(path = "health")
    ResponseEntity<Void> getHealth();

    @GetMapping(path = "qrcode")
    ResponseEntity<BufferedImage> getQrCode(
            @RequestParam @NotBlank(message = ERROR_CONTENTS) final String contents,
            @RequestParam(required = false, defaultValue = "250") @Range(min = 150, max = 350, message = ERROR_SIZE) final int size,
            @RequestParam(required = false, defaultValue = "L") @EnumValue(enumClass = ErrorCorrectionLevel.class, message = ERROR_CORRECTION) final ErrorCorrectionLevel correction,
            @RequestParam(required = false, defaultValue = "png") @EnumValue(enumClass = QrCodeType.class, message = ERROR_TYPE) final QrCodeType type);
}
