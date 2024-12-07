package com.qrGenerator.util;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.qrGenerator.qrGenerator.model.GenerateQr;

import java.io.ByteArrayOutputStream;
public class QrGeneratorUtil {

    public static byte[] generateQRCode(GenerateQr qr) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qr.getContent(),
                BarcodeFormat.QR_CODE, qr.getWidth(), qr.getHeight());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        return outputStream.toByteArray();
    }
}
