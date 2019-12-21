/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;
import TrainStatusGenerator.GetOverDueTrains;
import TrainStatusGenerator.GetTrainsByPlatform;
import TrainStatusGenerator.GetTrainsByStation;
import TrainStatusGenerator.Stop;
import TrainStatusGenerator.Train;
import com.google.gson.Gson;
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
        
        System.out.println("PROGRAM START");
        List<Train> trains = myListener.getTrainData("http://web.socem.plymouth.ac.uk/david/trains.json");
        GetOverDueTrains test = new GetOverDueTrains();
        GetTrainsByStation trainsByStation = new GetTrainsByStation();
        
        Gson gson = new Gson();
        GetTrainsByPlatform getByPlatform  = new GetTrainsByPlatform();
        
        Train tempTrain = trains.get(0);
        
        List<Stop> stops = tempTrain.getStops();
        
        Stop tempStop = stops.get(0);
        
        System.out.println(tempStop.getName());
        
        String trainsJson = gson.toJson(trains);
        
//        System.out.println(getByPlatform.getTrainsByPlatform(2, trains));
//        
        //System.out.println(trainsJson);
    }
    
}
