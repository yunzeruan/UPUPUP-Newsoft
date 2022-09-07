package com.dionsaur;

import com.audio.AudioControl;
import com.file.LongFile;
import com.file.OverFile;
import com.share.Fresh;
import com.share.Speed;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
* 恐龙运动生成
* */
@Setter
@Getter
public class Dionsaur {

    AudioControl audioControl = new AudioControl();
    //坐标
    public Integer x;
    public Integer y;

    //图片
    private BufferedImage image;
    private BufferedImage image1, image2, image3;
    private BufferedImage image_over;

    //计时器
    private Integer stepTime = 0;

    private boolean jumpState = false;//跳跃的状态
    private Integer jumpHeight = 100;//跳跃高度
    private final Integer LOWEST_Y = 200;//最低坐标
    private Integer jumpValue = 5;//跳跃的增变量

    //恐龙图片文件
    private LongFile longFile;

    //恐龙图片覆盖
    private OverFile overFile;

    public BufferedImage getImage() {
        return image;
    }

    public Integer getStepTime() {
        return stepTime;
    }

    public void setStepTime(Integer stepTime) {
        this.stepTime = stepTime;
    }

    public Dionsaur() {

        //设置坐标
        x = 50;
        y = 200;

        try {

            longFile = new LongFile();

            overFile = new OverFile();

            image1 = ImageIO.read(longFile.getLong1File());
            image2 = ImageIO.read(longFile.getLong2File());
            image3 = ImageIO.read(longFile.getLong3File());

            image_over = ImageIO.read(overFile.getOverFile());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //移动
    public void move() {

        //踏步
        step();

        if (jumpState) {
            if (y >= 200) {
                jumpValue = -4;
            }

            if ( y <= (200-jumpHeight) ) {
                jumpValue = 4;
            }

            y += jumpValue;

            image = image3;

            if (y >= 200) {
                jumpState = false;
            }

        }

    }
    //魔改版
    //控制恐龙左移
    public void left(){
        x -= 50;
        if(x<0){
            x = 734;
        }
    }
    //控制恐龙右移
    public void right(){
        x += 50;
        if(x>734){
            x = 0;
        }
    }
    //恐龙飞天
    public void fly(){
        y -= 50;
        if(y<0){
            y = 320;
        }
    }
    //恐龙遁地
    public void down(){
        y += 50;
        if(y>320){
            y = 0;
        }
    }


    //踏步
    public void step() {

        Integer tmp = stepTime / 100 % 2;

        //判断奇偶数
        if (tmp != 0) {

            image = image2;

        } else {

            image = image1;

        }

        stepTime += Fresh.FRESH;

    }


    //跳跃
    public void jump() {
        jumpState = true;
        audioControl.jumpAudio();

    }

    //接触死亡区域1
    public Rectangle rectangle1(){

        return new Rectangle(x+20,y,20,10);
    }

    //接触死亡区域2
    public Rectangle rectangle2(){
        return new Rectangle(x+5,y+35,20,10);
    }
    //接触死亡区域3
    public Rectangle rectangle3(){
        return new Rectangle(x+10,y+10,20,10);
    }


}
