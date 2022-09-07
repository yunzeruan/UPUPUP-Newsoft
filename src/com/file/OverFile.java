package com.file;

import com.imagesFile.OverPNG;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/*
* 获取覆盖图片文件路径
* */
@Setter
@Getter
public class OverFile {

    private OverPNG overPNG = new OverPNG();

    public File getOverFile() {
        return overFile;
    }

    private File overFile = new File(overPNG.getOverPNG());

}
