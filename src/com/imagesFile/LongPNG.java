package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

/*
*三个小恐龙图片文件地址
* */
@Setter
@Getter
public class LongPNG {

    public String getLong1PNG() {
        return long1PNG;
    }

    public String getLong2PNG() {
        return long2PNG;
    }

    public String getLong3PNG() {
        return long3PNG;
    }

    private String long1PNG = "images/long1.png";
    private String long2PNG = "images/long2.png";
    private String long3PNG = "images/long3.png";

}
