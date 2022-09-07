package com.file;
import com.imagesFile.FlightPNG;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
/*
 * 飞机图片文件路径
 * */
@Setter
@Getter
public class FlightFile {

    private FlightPNG flightPNG=new FlightPNG();

    public File getFlightFile() {
        return flightFile;
    }

    public File getFlightFile1() {
        return flightFile1;
    }
    public File getFlightFile2() {
        return flightFile2;
    }
    public File getFlightFile3() {
        return flightFile3;
    }

    private  File flightFile1=new File(flightPNG.getFlightPNG1());

    private  File flightFile =new File(flightPNG.getFlightPNG());

    private  File flightFile2=new File(flightPNG.getFlightPNG2());

    private  File flightFile3 =new File(flightPNG.getFlightPNG3());
}
