package com.audio;


import javax.swing.*;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AudioControl extends Thread {
    public AudioClip loadSound(String filename){
        URL url = null;
        try {
            url = new URL("file:"+filename);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return JApplet.newAudioClip(url);
    }

//    AudioClip jump = loadSound(AudioControl.class.getResource("/audios/jump.wav").getPath());
//    AudioClip scored = loadSound(AudioControl.class.getResource("/audios/scored.wav").getPath());
//    AudioClip hit = loadSound(AudioControl.class.getResource("/audios/hit.wav").getPath());
    AudioClip jump = loadSound(new File("audios/jump.wav").getAbsolutePath());
    AudioClip scored = loadSound(new File("audios/scored.wav").getAbsolutePath());
    AudioClip hit = loadSound(new File("audios/hit.wav").getAbsolutePath());

    public void hitAudio(){
        hit.play();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hit.stop();
    }

    public void jumpAudio(){
        jump.stop();
        jump.play();
    }
    public void scoredAudio(){
        scored.stop();
        scored.play();
    }

}
