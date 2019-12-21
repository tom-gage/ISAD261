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
public class GetTrainsByPlatform {
    
    public List<Train> getTrainsByPlatform(int platform, List<Train> trainsList) {
        try {
            List<Train> trainsListByPlatform = new ArrayList();

            for (int i = 0; i < trainsList.size(); i++) {
                Train tempTrain = trainsList.get(i);

                if (tempTrain.getPlatform().equals(Integer.toString(platform))) {
                    trainsListByPlatform.add(tempTrain);
                }
            }
            if (trainsListByPlatform.isEmpty()) {
                return null;
            } else {
                return trainsListByPlatform;
            }

        } catch (Exception e) {
            return null;
        }
    }
}
