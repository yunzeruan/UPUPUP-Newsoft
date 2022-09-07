package com.freshthread;

import com.audio.AudioControl;
import com.ganmepanel.GamePanel;
import com.share.Fresh;
import com.share.JOptionPaneFont;
import com.share.TopScore;
import com.start.MainFrme;

import javax.swing.*;
import java.awt.*;
/*
* 线程刷线
* */
public class FreshThread extends Thread {

    AudioControl audioControl = new AudioControl();
    //游戏面板，用于重新绘制该面板
    private GamePanel gamePanel;

    public FreshThread(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

    }

    @Override
    public void run() {

        //判断游戏是否结束
        while (!gamePanel.isFinish()) {

            //重绘图片
            gamePanel.repaint();

            try {

                //休眠刷新时间
                Thread.sleep(Fresh.FRESH);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Container container = gamePanel.getParent();

        //判断是否为启动的主界面
        while(!(container instanceof MainFrme)){

            container=container.getParent();

        }

        MainFrme mainFrme= (MainFrme) container;
        audioControl.hitAudio();

        //提示游戏结束
        String endWord = "<html>" +
                "<h2><font color='#ff0000' style='text-align: center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;游戏结束!</font><br></h2>"+
                "<h4><font color='#90ee90'style='font-family: 'Microsoft YaHei UI''>&nbsp;&nbsp;您当前的分数是： " +
                gamePanel.getScore() +
                "<br>" +
                " &nbsp;&nbsp;最高分是：" +
                TopScore.TOPSCORE+
                "</font>"+
                "</h4>" +
                "</html>";

        JLabel jLabel = new JLabel(endWord);



        ImageIcon icon = new ImageIcon("images/logo.png");

        JOptionPane.showMessageDialog(mainFrme,jLabel,"GAME OVER",JOptionPane.ERROR_MESSAGE,icon);

        audioControl.scoredAudio();
       //JOptionPane.showConfirmDialog(mainFrme, jLabel, "游戏结束！", JOptionPane.YES_NO_CANCEL_OPTION);

        /*
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.setForeground(Color.RED);
        jOptionPane.setFont(new JOptionPaneFont().getFont());
        jOptionPane.showMessageDialog(mainFrme,endWord);
        */

        //复活
        mainFrme.restart();

    }

}



