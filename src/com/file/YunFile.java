package com.file;

import com.imagesFile.YunPNG;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/*
* 云图片文件路径
* */
@Setter
@Getter
public class YunFile {

    private YunPNG yunPNG = new YunPNG();

    public File getYunFile() {
        return yunFile;
    }

    private File yunFile = new File(yunPNG.getYunPNG());


}
