/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;

/**
 *
 * @author btgage
 */
public class StatusGenerator {
    private IncomingTrainsStatusListener trainListener;
    
    public StatusGenerator(IncomingTrainsStatusListener trainListener){
        this.trainListener = trainListener;
    }
    
    public void getAll(){
        trainListener.getJSON("http://web.socem.plymouth.ac.uk/david/trains.json");
    }
    
    
    
    
    
    public void getAllIncomingTrains(){
        
    }
    
    public void getAllTrainsByPlatform(int platform){
        
    }
    
    public void getAllTrainsByStation(String station){
        
    }
    
    public void getAllOverdueTrains(){
        
    }
    
    public void overdudeTrainsNotice(){
        
    }
}
