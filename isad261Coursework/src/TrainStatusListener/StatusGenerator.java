/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;

import com.google.gson.Gson;
import com.google.gson.stream.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author btgage
 */
public class StatusGenerator {

    private StatusListener listener;
    private List<Train> trainsList;
    private String api = "http://web.socem.plymouth.ac.uk/david/trains.json";

    public StatusGenerator(StatusListener listener) {
        this.listener = listener;
    }

    public StatusGenerator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Train> getTrainsList(String apiURL) {
        try {
            return trainsList = listener.getTrainData(apiURL);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Train> getTrainsByPlatform(int platform, List<Train> trainsList) {
        try {
            List<Train> trainsListByPlatform = new ArrayList();
            
            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);

                if (tempTrain.getPlatform().equals(Integer.toString(platform))) {
                    trainsListByPlatform.add(tempTrain);
                }
            }
            if(trainsListByPlatform.isEmpty()){
                return null;
            }else{
                return trainsListByPlatform;
            }
            
        } catch (Exception e) {
            return null;
        }
    }

    public List<Train> getTrainsByStation(String station, List<Train> trainsList) {
        try {
            List<Train> trainsListByStation = new ArrayList();

            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);
                List<Stop> tempStops = tempTrain.getStops();

                for (int x = 0; x < tempStops.size(); x++) {
                    Stop tempStop = tempStops.get(x);

                    if (tempStop.getName().equals(station)) {
                        trainsListByStation.add(tempTrain);
                        x = tempStops.size();
                    }
                }
            }
            if(trainsListByStation.isEmpty()){
                return null;
            }else{
                return trainsListByStation;
            }
            
        } catch (Exception e) {
            return null;
        }
    }

    public List<Train> getAllOverdueTrains(List<Train> trainsList) {
        try {
            List<Train> overdueTrainsList = new ArrayList();
            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);
                if (tempTrain.getExpectedDepartureTime() != null) {
                    overdueTrainsList.add(tempTrain);
                }
            }
            if(overdueTrainsList.isEmpty()){
                return null;
            }else{
                return overdueTrainsList;
            }
            
        } catch (Exception e) {
            return null;
        }
    }

    public void printOverdudeTrainsNotice(List<Train> overdueTrainsList) {
        try {
            if (!overdueTrainsList.isEmpty()) {
                System.out.println("The following trains are delayed: ");
                for (int i = 0; i < overdueTrainsList.size(); i++) {
                    Train tempTrain = overdueTrainsList.get(i);
                    
                    System.out.println(
                            "The " + tempTrain.getDepartureTime()+ " train to "
                            + tempTrain.getDestinationName() + " is delayed and will depart at "
                            + tempTrain.getExpectedDepartureTime() + "."
                    );
                }
            }

        } catch (Exception e) {

        }
    }

}
