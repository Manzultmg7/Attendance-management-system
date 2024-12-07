package com.qrGenerator.qrGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class GenerateQr {
    public String content;
    public int width;
    public int height;
}
