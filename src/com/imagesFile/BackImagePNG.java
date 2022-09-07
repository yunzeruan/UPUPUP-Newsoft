package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

/*
*背景图片文件地址
* */
@Setter
@Getter
public class BackImagePNG {

    public String getBackImagePNG() {
        return backImagePNG;
    }

    private String backImagePNG = "images/map.png";

}
