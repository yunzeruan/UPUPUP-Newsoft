package com.obstacle;

import com.dionsaur.Dionsaur;
import com.file.MountainFile;
import com.file.BirdFile;
import com.file.CactusFile;
import com.share.Fresh;
import com.share.Speed;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*
* 障碍物
* */
@Setter
@Getter
public class Obstacle {

    //坐标
    private Integer x;
    private Integer y;

    //判断是否还跳跃
    public boolean judge=false;

    private BufferedImage image;
    private BufferedImage cactus01, cactus02, cactus03;
    private BufferedImage bird1, bird2;
    private BufferedImage mountain;

    private Integer temp = new Random().nextInt(5) + 1;//1-2-3-4
    //山
    private MountainFile mountainFile;
    //小鸟图片
    private BirdFile birdFile;

    //仙人掌图片
    private CactusFile cactusFile;

    //小恐龙
    private Dionsaur dionsaur = new Dionsaur();

    public BufferedImage getImage() {
        return image;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Obstacle() {

        x = 800;
        y = 209;

        //读取图片
        try {
          mountainFile=new MountainFile();
            birdFile = new BirdFile();

            cactusFile = new CactusFile();
            mountain = ImageIO.read(mountainFile.getMountainFile());
            cactus01 = ImageIO.read(cactusFile.getCactus1File());
            cactus02 = ImageIO.read(cactusFile.getCactus2File());
            cactus03 = ImageIO.read(cactusFile.getCactus3File());

            bird1= ImageIO.read(birdFile.getBird1File());
            bird2= ImageIO.read(birdFile.getBird2File());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //随机输出障碍物
        switch (temp) {

            case 1:
                image = cactus01;
                break;
            case 2:
                image = cactus02;
                break;
            case 3:
                image = cactus03;
                y = 200;
                break;
            case 4:
                image = mountain;
                break;
            default:
                judge=true;
        }


    }

    //鸟的运动
    public void bridMove() {
        if (judge){

            int tmp = dionsaur.getStepTime() / 100 % 2;

            if (tmp != 0) {

                image = bird1;

            } else {
                image = bird2;
                y=150;
            }

            dionsaur.setStepTime(dionsaur.getStepTime() + Fresh.FRESH);
        }
    }

    //滚动
    public void move() {
        x -= Speed.SPEED;
        x -= Speed.SPEED;


    }


    //死亡区域
    public Rectangle rectangle() {
        return new Rectangle(x,y+2,image.getWidth()-2,image.getHeight()-10);
    }

}
