package qrcodeapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.image.BufferedImage;

@Setter
@Accessors(chain = true)
public class QrCodeBuilder {

    private String text;

    private int size;

    public BufferedImage build() {
        final QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new IllegalStateException(e);
        }
    }
}
