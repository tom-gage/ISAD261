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
public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        StatusListener myListener = new StatusListener();
        StatusGenerator myGenerator = new StatusGenerator(myListener);
        
        System.out.println("PROGRAM START");
        List<Train> trains = myGenerator.getTrainsList("http://web.socem.plymouth.ac.uk/david/trains.json");
        List<Train> overdueTrains = myGenerator.getAllOverdueTrains(trains);
        
        Train train = trains.get(0);
        Train overdueTrain = overdueTrains.get(0);
        
        List<Stop> trainStops = train.getStops();
        List<Stop> overdueTrainStops = overdueTrain.getStops();
        
        Stop stop = trainStops.get(0);
//        System.out.println(stop.getDepartureTime()); 
        
        myGenerator.printOverdudeTrainsNotice(overdueTrains);
        
        
    }
    
}
