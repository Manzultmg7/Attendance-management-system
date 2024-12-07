package com.qrGenerator.qrGenerator.controller;

import com.qrGenerator.qrGenerator.model.GenerateQr;
import com.qrGenerator.util.QrGeneratorUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/qr")
public class QrGeneratorController {

    @GetMapping("/generateQr")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String userId) {
        try {
            String qrContent = "http://localhost:8080/attendance?userId=" + userId;
            GenerateQr qr = new GenerateQr(qrContent, 300, 300);
            byte[] qrCode = QrGeneratorUtil.generateQRCode(qr);


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return ResponseEntity.ok().headers(headers).body(qrCode);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/attendance")
    public String markAttendance(@RequestParam String userId) {
        return "Attendance marked for user: " + userId;
    }
}
