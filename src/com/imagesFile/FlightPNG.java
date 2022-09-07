package com.imagesFile;
import lombok.Getter;
import lombok.Setter;
/*
 * 飞机图片路径
 * */
@Getter
@Setter
public class FlightPNG {
    public String getFlightPNG() {
        return flightPNG;
    }
    public String getFlightPNG1() {
        return flightPNG1;
    }
    public String getFlightPNG2() {
        return flightPNG2;
    }
    public String getFlightPNG3() {
        return flightPNG3;
    }

    private String flightPNG = "images/flight.png";
    private String flightPNG1 = "images/flight1.png";
    private  String flightPNG2="images/flight2.png";
    private  String flightPNG3="images/flight3.png";
}
