package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BirdPNG {
    public String getBird1PNG() {
        return bird1PNG;
    }

    public String getBird2PNG() {
        return bird2PNG;
    }

    private String bird1PNG = "images/bird1.png";
    private String bird2PNG = "images/bird2.png";

}
