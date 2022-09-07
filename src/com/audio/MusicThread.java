package com.audio;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MusicThread extends Thread{
	File file = new File("audio/MySoul.wav");

	@Override
	public void run() {
		//声音IO流
		AudioInputStream audioIn;
		BufferedInputStream bufIn;
		try {
			bufIn = new BufferedInputStream(new FileInputStream(file));
			audioIn = AudioSystem.getAudioInputStream(bufIn);

			AudioFormat format = audioIn.getFormat();
			//输出设备
			SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(format);
			sourceDataLine.open();
			sourceDataLine.start();
			int len;
			byte[] buf = new byte[512];
			while (true) {
				len = audioIn.read(buf);

				//循环播放 重新读写音频流
				if (len == -1){
					buf = new byte[512];
					bufIn = new BufferedInputStream(new FileInputStream(file));
					audioIn = AudioSystem.getAudioInputStream(bufIn);
					len = audioIn.read(buf);
				}
				sourceDataLine.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
