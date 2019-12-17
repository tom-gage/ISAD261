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

    public List<Train> getStatusData(String apiURL) throws Exception {
        return listener.getTrainData(apiURL);
    }

    public List<Train> getAllIncomingTrains() {
        try {
            return trainsList = getStatusData(api);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Train> getTrainsByPlatform(int platform) {
        try {
            List<Train> trainsListByPlatform = new ArrayList();
            trainsList = getStatusData(api);
            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);
                
                if(tempTrain.getPlatform().equals(Integer.toString(platform))){
                    trainsListByPlatform.add(tempTrain);
                }
            }
            
            return trainsListByPlatform;
            
        } catch (Exception e) {
            return null;
        }
    }

    public List<Train> getTrainsByStation(String station) {
        try {
            List<Train> trainsListByStation = new ArrayList();
            trainsList = getStatusData(api);
            
            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);
                List<Stop> tempStops = tempTrain.getStops();
                
                for (int x = 0; x < tempStops.size(); x++){
                    Stop tempStop = tempStops.get(x);
                    
                    if(tempStop.getName().equals(station)){
                        trainsListByStation.add(tempTrain);
                    }
                }
            }
            
            return trainsListByStation;
            
        } catch (Exception e) {
            return null;
        }
    }

    public List<Train> getAllOverdueTrains() {
        try {
            List<Train> overdueTrainsList = new ArrayList();
            trainsList = getStatusData(api);
            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);
                if(tempTrain.getExpectedDepartureTime() == null){
                    overdueTrainsList.add(tempTrain);
                }
            }
            
            return overdueTrainsList;
            
        } catch (Exception e) {
            return null;
        }
    }

    public void overdudeTrainsNotice() {

    }
}
