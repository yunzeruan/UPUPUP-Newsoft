package com.file;

import com.imagesFile.GameOver;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/*
* 程序结束按钮图片文件路径
* */
@Setter
@Getter
public class GameOverFile {

    private GameOver gameOver = new GameOver();

    public File getGameOverFile() {
        return gameOverFile;
    }

    private File gameOverFile = new File(gameOver.getGameOver());
}
