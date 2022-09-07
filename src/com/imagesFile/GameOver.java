package com.imagesFile;

import lombok.Getter;
import lombok.Setter;

/*
* 游戏结束按钮图片路径
* */
@Getter
@Setter
public class GameOver {

    public String getGameOver() {
        return gameOver;
    }

    private String gameOver = "images/game_over.png";
}
