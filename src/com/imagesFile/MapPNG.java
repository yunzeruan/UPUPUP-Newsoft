package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

/*
* 背景图片路径
* */
@Getter
@Setter
public class MapPNG {

    public String getMap() {
        return map;
    }

    public String getMap1() {
        return map1;
    }

    private String map = "images/map.png";
    private String map1 = "images/map1.png";
}
