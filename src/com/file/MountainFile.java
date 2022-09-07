package com.file;
import com.imagesFile.Mountain;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class MountainFile {
    private Mountain mountain = new Mountain();

    public File getMountainFile() {
        return mountainFile;
    }

    private File mountainFile = new File(mountain.getMountain());

}
