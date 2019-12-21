/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusGenerator;

import java.util.*;

/**
 *
 * @author Tom
 */
public class Train {

    private String platform, departs, expected;
    private String destinationName = null;
    private List<Stop> stops;

    public Train(String platform, String departureTime, String expectedDepartureTime, String destinationName, List stops) {
        this.platform = platform;
        this.departs = departureTime;
        this.expected = expectedDepartureTime;
        this.destinationName = destinationName;
        this.stops = stops;

    }

    public Train(String platform, String departureTime, String expectedDepartureTime, List stops) {
        this.platform = platform;
        this.departs = departureTime;
        this.expected = expectedDepartureTime;
        this.stops = stops;

    }

    public Train() {
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public List getStops() {
        return stops;
    }

    public void setStops(List stops) {
        this.stops = stops;
    }

    public String getDestinationName() {
        return destinationName;
    }


    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

}
