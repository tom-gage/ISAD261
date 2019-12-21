/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tom
 */
public class GetTrainsByStation {

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
            if (trainsListByStation.isEmpty()) {
                return null;
            } else {
                return trainsListByStation;
            }

        } catch (Exception e) {
            return null;
        }
    }
}
