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
     */
    public static void main(String[] args) throws Exception {
        StatusListener myListener = new StatusListener();
        StatusGenerator myGenerator = new StatusGenerator(myListener);
        
        System.out.println("PROGRAM START");
        List<Train> trains = myListener.getTrainData("http://web.socem.plymouth.ac.uk/david/trains.json");
        
        Train testTrain = trains.get(0);
        List<Train> trainsByPlatform = myGenerator.getTrainsByPlatform(1);
        System.out.println(trainsByPlatform);
    }
    
}
