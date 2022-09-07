package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cactus {
    public String getCactus1() {
        return cactus1;
    }

    public String getCactus2() {
        return cactus2;
    }

    public String getCactus3() {
        return cactus3;
    }

    private String cactus1 = "images/cactus01.png";
    private String cactus2 = "images/cactus02.png";
    private String cactus3 = "images/cactus03.png";

}
