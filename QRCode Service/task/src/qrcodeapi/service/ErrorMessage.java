package qrcodeapi.service;

public record ErrorMessage(String error) {

    public static final ErrorMessage ERROR_SIZE = new ErrorMessage("Image size must be between 150 and 350 pixels");
    public static final ErrorMessage ERROR_TYPE = new ErrorMessage("Only png, jpeg and gif image types are supported");
}
