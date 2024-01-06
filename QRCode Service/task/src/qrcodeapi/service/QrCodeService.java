package qrcodeapi.service;

import org.springframework.stereotype.Service;

@Service
public class QrCodeService {

    public QrCode getQrCode() {
        return new QrCode();
    }
}
