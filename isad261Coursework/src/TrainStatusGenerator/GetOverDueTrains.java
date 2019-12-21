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
public class GetOverDueTrains {

    public String getOverdueTrainsNotice(List<Train> trainsList) {
        try {
            List<Train> overdueTrainsList = new ArrayList();
            String overdueTrainsNotice;

            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);
                if (tempTrain.getExpected() != null) {
                    overdueTrainsList.add(tempTrain);
                }
            }
            if (!overdueTrainsList.isEmpty()) {
                overdueTrainsNotice = "The following trains are delayed: \n";
                for (int i = 0; i < overdueTrainsList.size(); i++) {
                    Train tempTrain = overdueTrainsList.get(i);
                    List<Stop> tempStops = tempTrain.getStops();
                    Stop finalStop = tempStops.get(tempStops.size()-1);
                    
                    overdueTrainsNotice += "The " + tempTrain.getDeparts() + " train to "
                            + finalStop.getName() + " is delayed and will depart at "
                            + tempTrain.getExpected() + ". \n";
                }
                return overdueTrainsNotice;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

}
