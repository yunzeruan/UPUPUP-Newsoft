package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

/*
* 覆盖小恐龙图片路径
* */
@Getter
@Setter
public class OverPNG {

    public String getOverPNG() {
        return overPNG;
    }

    private String overPNG = "images/over.png";
}
