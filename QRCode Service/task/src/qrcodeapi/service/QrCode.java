package qrcodeapi.service;

import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
public class QrCode {

    private final BufferedImage image;

    public QrCode() {
        final int edge = 250;
        this.image = new BufferedImage(edge, edge, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, edge, edge);
    }

}
