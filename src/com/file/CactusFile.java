package com.file;

import com.imagesFile.Cactus;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class CactusFile {

    private Cactus cactus = new Cactus();

    public File getCactus1File() {
        return cactus1File;
    }

    public File getCactus2File() {
        return cactus2File;
    }

    public File getCactus3File() {
        return cactus3File;
    }

    private File cactus1File = new File(cactus.getCactus1());
    private File cactus2File = new File(cactus.getCactus2());
    private File cactus3File = new File(cactus.getCactus3());
}
