package com.file;

import com.imagesFile.LongPNG;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/*
* 获取恐龙的三个图片文件路径
* */
@Getter
@Setter
public class LongFile {

    private LongPNG longPNG = new LongPNG();

    public File getLong1File() {
        return long1File;
    }
    public File getLong2File() {
        return long2File;
    }
    public File getLong3File() {
        return long3File;
    }
    private File long1File = new File(longPNG.getLong1PNG());
    private File long2File = new File(longPNG.getLong2PNG());
    private File long3File = new File(longPNG.getLong3PNG());
}
