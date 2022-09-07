package com.ganmepanel;

import com.backgroundImage.BackgroundImage;
import com.dionsaur.Dionsaur;
import com.freshthread.FreshThread;
import com.obstacle.Obstacle;
import com.share.Fresh;
import com.share.TopScore;
import lombok.Getter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/*
* 绘制游戏面板窗口
* */
public class GamePanel extends JPanel implements KeyListener {

    //主图片
    private BufferedImage image;

    //绘图
    private Graphics2D graphics2D;

    //恐龙
    private Dionsaur dionsaur;

    //记录游戏是否结束
    boolean finish = false;//游戏结束

    //背景
    private BackgroundImage background;

    //障碍物集合
    private List<Obstacle> list = new ArrayList<Obstacle>();

    //障碍物
    private Obstacle obstacle;

    private Integer addObjectTimer = 0;
    @Getter
    private Integer score=0;
    private Integer addScoreTimer=0;

    //用于获取键盘按下去的字符编码
    private Integer code;

    public Integer getScore() {
        return score;
    }

    //构造方法
    public GamePanel() {

        obstacle = new Obstacle();

        image = new BufferedImage(734, 286, BufferedImage.TYPE_INT_BGR);

        graphics2D = image.createGraphics();

        dionsaur = new Dionsaur();

        background = new BackgroundImage();

        list.add(new Obstacle());

        //刷新线程
        FreshThread freshThread = new FreshThread(this);
        freshThread.start();

    }

    //绘制图片
    private void painImage() {

        //小恐龙移动
        dionsaur.move();

        //背景图片滚动
        background.roll();

        graphics2D.drawImage(background.getImage(), 0, 0, this);

        graphics2D.drawImage(background.getImage_yun(), background.getX_yun(),background.getY_yun(), this);



        graphics2D.drawImage(background.getImage_flight(),background.getX_flight(),background.getY_flight(),this);

        graphics2D.drawImage(background.getImage_flight1(),background.getX_flight1(),background.getY_flight1(),this);

        graphics2D.drawImage(background.getImage_flight2(),background.getX_flight2(),background.getY_flight2(),this);

        graphics2D.drawImage(background.getImage_flight3(),background.getX_flight3(),background.getY_flight3(),this);

        graphics2D.drawImage(dionsaur.getImage(), dionsaur.x, dionsaur.y, this);

        //计算分数时间判断
        if (addObjectTimer >= 1400) {

            list.add(new Obstacle());


            addObjectTimer = 0;

        }

        //循环出现障碍物
        for (Integer i = 0; i < list.size(); i++) {

            Obstacle obstacle1 = list.get(i);

            obstacle1.move();
            obstacle1.bridMove();

            graphics2D.drawImage(obstacle1.getImage(), obstacle1.getX(), obstacle1.getY(), this);

            //判断障碍物是否和头、脚相撞
            if (obstacle1.rectangle().intersects(dionsaur.rectangle1()) || obstacle1.rectangle().intersects(dionsaur.rectangle2())
            ||obstacle1.rectangle().intersects(dionsaur.rectangle3())) {

                //游戏结束
                gameOver();

            }
        }

        //分数++
        if (addObjectTimer >= 50){

            score += 1;
            addScoreTimer = 0;

        }

        //分数显示代码---"%05d"---代表分数以五位数显示
        graphics2D.drawString(String.format("%05d",score),600,35 );
        graphics2D.drawString("记录：",520,34 );
        graphics2D.drawString(String.format("%05d",+TopScore.TOPSCORE),550,35 );


        addObjectTimer += Fresh.FRESH;
        addScoreTimer += Fresh.FRESH;

    }


    //游戏结束
    public void gameOver(){

        finish=true;

        graphics2D.drawImage(background.getImage_over(),background.getX_over(),background.getY_over(),null);

        //判断最高分
        if (score > TopScore.TOPSCORE){

            TopScore.TOPSCORE = score;

        }

    }

    @Override
    public void paint(Graphics graphics) {
        painImage();
        graphics.drawImage(image, 0, 0, this);
    }


    public boolean isFinish() {
        return finish;
    }

    //键盘监听,按键类型
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按键按下,获取按下的编码
    @Override
    public void keyPressed(KeyEvent e) {

        code = e.getKeyCode();

        if (code == KeyEvent.VK_SPACE) {

            dionsaur.jump();

        }
        if(code == KeyEvent.VK_A){

            dionsaur.left();

        }
        if(code == KeyEvent.VK_D){

            dionsaur.right();

        }
        if(code == KeyEvent.VK_W){

            dionsaur.fly();

        }
        if(code == KeyEvent.VK_S){

            dionsaur.down();

        }if(code == KeyEvent.VK_ALT){

            System.exit(0);

        }

    }


    //按键抬起
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
