package qrcodeapi.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;

@Getter
@RequiredArgsConstructor
public enum QrCodeType {

    JPEG(MediaType.IMAGE_JPEG),
    PNG(MediaType.IMAGE_PNG),
    GIF(MediaType.IMAGE_GIF);

    private final MediaType mediaType;

}
