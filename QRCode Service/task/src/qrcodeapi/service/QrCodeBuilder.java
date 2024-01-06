package qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.image.BufferedImage;
import java.util.Map;

@Setter
@Accessors(chain = true)
public class QrCodeBuilder {

    private String text;

    private int size;

    private ErrorCorrectionLevel errorCorrectionLevel;

    public BufferedImage build() {
        final QRCodeWriter writer = new QRCodeWriter();
        final Map<EncodeHintType, ErrorCorrectionLevel> hints = Map.of(
                EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel
        );
        try {
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new IllegalStateException(e);
        }
    }
}
