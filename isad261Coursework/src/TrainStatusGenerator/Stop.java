/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusGenerator;

/**
 *
 * @author Tom
 */
public class Stop {

    private String name, arrives, departs;

    public Stop(String name, String arrivalTime, String departureTime) {
        this.name = name;
        this.arrives = arrivalTime;
        this.departs = departureTime;
    }

    public Stop() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArrives() {
        return arrives;
    }

    public void setArrives(String arrives) {
        this.arrives = arrives;
    }

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }

}
