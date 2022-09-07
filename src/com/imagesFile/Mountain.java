package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Mountain {
    public String getMountain() {
        return mountain;
    }

    private String mountain="images/mountain.png";
}
