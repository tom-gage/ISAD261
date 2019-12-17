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

    public List<Train> getAllTrainsByPlatform(int platform) {
        try {
            trainsList = getStatusData(api);
            for (int i = 0; i < trainsList.size(); i++) {
            
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void getAllTrainsByStation(String station) {

    }

    public void getAllOverdueTrains() {

    }

    public void overdudeTrainsNotice() {

    }
}
