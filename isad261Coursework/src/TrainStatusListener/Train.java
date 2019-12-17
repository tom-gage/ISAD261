/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;

import java.util.*;

/**
 *
 * @author Tom
 */
public class Train {
    private String platform, departureTime, expectedDepartureTime;
    private List stops;
    
    public Train(String platform, String departureTime, String expectedDepartureTime, List stops){
        this.platform = platform;
        this.departureTime = departureTime;
        this.expectedDepartureTime = expectedDepartureTime;
        this.stops = stops;
    }
    
    public Train(){
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getExpectedDepartureTime() {
        return expectedDepartureTime;
    }

    public void setExpectedDepartureTime(String expectedDepartureTime) {
        this.expectedDepartureTime = expectedDepartureTime;
    }

    public List getStops() {
        return stops;
    }

    public void setStops(List stops) {
        this.stops = stops;
    }
    
    
}
