package com.backgroundImage;

import com.dionsaur.Dionsaur;
import com.file.FlightFile;
import com.file.GameOverFile;
import com.file.MapFile;
import com.file.YunFile;
import com.imagesFile.FlightPNG;
import com.share.Speed;
import com.ganmepanel.GamePanel;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/*
* 背景图生成
* */
@Getter
@Setter
public class BackgroundImage {

    //主图片
    private BufferedImage image;

    //滚动图片
    private BufferedImage image1, image2;
    private BufferedImage image_over;
    private BufferedImage image_yun;
    private  BufferedImage image_flight;
    private  BufferedImage image_flight1;
    private BufferedImage image_flight2;
    private  BufferedImage image_flight3;

    //画板
    private Graphics2D graphics2D;

    //两个图片的坐标
    private Integer x;
    private Integer y;

    private Integer x_yun=800;
    private Integer y_yun=50;

    private Integer x_over=240;
    private Integer y_over=50;

    private  Integer x_flight=500;
    private  Integer y_flight=80;

    private  Integer x_flight1=600;
    private Integer y_flight1=50;

    private  Integer x_flight2=300;
    private  Integer y_flight2=50;

    private Integer x_flight3=200;
    private  Integer  y_flight3=50;


    //背景图片文件
    private MapFile mapFile;

    //游戏结束图片文件
    private GameOverFile gameOverFile;

    //飞机图片文件
    private FlightFile flightFile;
    private  FlightFile flightFile1;
    private  FlightFile flightFile2;
    private  FlightFile flightFile3 ;

     //云图片文件
    private YunFile yunFile;

    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage getImage_yun() {
        return image_yun;
    }

    public BufferedImage getImage_over() {
        return image_over;
    }

    public Integer getX_flight() {
        return x_flight;
    }

    public Integer getX_over() {
        return x_over;
    }

    public Integer getX_yun() {
        return x_yun;
    }

    public Integer getY_flight() {
        return y_flight;
    }

    public Integer getY_yun() {
        return y_yun;
    }

    public Integer getY_over() {
        return y_over;
    }

    public BufferedImage getImage_flight() {
        return image_flight;
    }

    public BufferedImage getImage_flight1() {
        return image_flight1;
    }

    public BufferedImage getImage_flight2() {
        return image_flight2;
    }

    public BufferedImage getImage_flight3() {
        return image_flight3;
    }

    public Integer getX_flight1() {
        return x_flight1;
    }

    public Integer getX_flight2() {
        return x_flight2;
    }

    public Integer getX_flight3() {
        return x_flight3;
    }

    public Integer getY_flight1() {
        return y_flight1;
    }

    public Integer getY_flight2() {
        return y_flight2;
    }

    public Integer getY_flight3() {
        return y_flight3;
    }

    public BackgroundImage() {

        //设置坐标
        x = 0;
        y = 734;

        try {

            mapFile = new MapFile();

            gameOverFile = new GameOverFile();

            yunFile = new YunFile();

            flightFile=new FlightFile();



            image1 = ImageIO.read(mapFile.getMap());
            image2 = ImageIO.read(mapFile.getMap1());

            image_over = ImageIO.read(gameOverFile.getGameOverFile());

            image_yun = ImageIO.read(yunFile.getYunFile());



            image_flight=ImageIO.read(flightFile.getFlightFile());

            image_flight1=ImageIO.read(flightFile.getFlightFile1());

          image_flight2=ImageIO.read(flightFile.getFlightFile2());

            image_flight3=ImageIO.read(flightFile.getFlightFile3());
        } catch (Exception e) {
            e.printStackTrace();
        }

        image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_BGR);

        //创建绘画
        graphics2D = image.createGraphics();

        graphics2D.drawImage(image1, x, 0, null);
        graphics2D.drawImage(image2, y, 0, null);

    }

    //背景滚动
    public void roll() {

        x -= Speed.SPEED;
        y -= Speed.SPEED;

        if (x <= -734) {
            x = 734;
        }
        if (y <= -734) {
            y = 734;
        }

        graphics2D.drawImage(image1, x, 0, null);
        graphics2D.drawImage(image2, y, 0, null);

        x_yun -= 1;

        if (x_yun <= 0){

            graphics2D.drawImage(image_yun, x_yun, y_yun, null);

            x_yun = 750;

            if ( (y_yun+=26) < 80 ){
                y_yun += 26;
            }

        }




        x_flight-=1;
        if (x_flight<=0){
            graphics2D.drawImage(image_flight,x_flight,y_flight,null);

            x_flight=650;
            if ((y_flight+=25)<90){
                y_flight+=25;
            }
        }

        x_flight1-=1;
        if (x_flight1<=0){
            graphics2D.drawImage(image_flight1,x_flight1,y_flight1,null);
            x_flight1=550;

            if ((y_flight1+=25)<70){
                y_flight1+=25;
            }
        }
        x_flight2-=1;
        if (x_flight2<=0){
            graphics2D.drawImage(image_flight2,x_flight2,y_flight2,null);
            x_flight2=750;

            if ((y_flight1+=26)<90){
                y_flight1+=26;}
        }

        x_flight3-=1;
        if (x_flight3<=0){
            graphics2D.drawImage(image_flight3,x_flight3,y_flight3,null);
            x_flight1=750;

            if ((y_flight1+=27)<90) {
                y_flight1 += 27;
            }}


    }


}
