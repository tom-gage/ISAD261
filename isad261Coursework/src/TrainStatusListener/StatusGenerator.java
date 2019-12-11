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
    private IncomingTrainsStatusListener trainListener;
    public static Response status;
    
    public StatusGenerator(IncomingTrainsStatusListener trainListener){
        this.trainListener = trainListener;
        Gson g = new Gson();
    }
    
    public void getStatusData() throws Exception{
        status = trainListener.getJSON("http://web.socem.plymouth.ac.uk/david/trains.json");
        System.out.println(status.getData());
    }
    
   public List<Train> readJsonStream(InputStream in) throws IOException {
     JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
     try {
       return readIncomingTrainsArray(reader);
     } finally {
       reader.close();
     }
   }

   public List<Train> readIncomingTrainsArray(JsonReader reader) throws IOException {
     List<Train> trains = new ArrayList<Train>();

     reader.beginArray();
     while (reader.hasNext()) {
       trains.add(constructTrainObject(reader));
     }
     reader.endArray();
     return trains;
   }

   public Train constructTrainObject(JsonReader reader) throws IOException {
     List stops;
     String platform;
     String departureTime;
     String expectedDepartureTime;
     

     reader.beginObject();
     while (reader.hasNext()) {
        String name = reader.nextName();
        if (name.equals("stops")) {
          stops = readStopsArray(reader);
        } else if (name.equals("platform")) {
          platform = reader.nextString();
        } else if (name.equals("departs")){
          departureTime = reader.nextString();
        } else if (name.equals("expected")) {
          expectedDepartureTime = reader.nextString();
        } else {
          reader.skipValue();
        }
     }
     reader.endObject();
     return new Train(stops, platform, departureTime, expectedDepartureTime);
   }

   public List<Double> readDoublesArray(JsonReader reader) throws IOException {
        List<Double> doubles = new ArrayList<Double>();

        reader.beginArray();
        while (reader.hasNext()) {
          doubles.add(reader.nextDouble());
        }
        reader.endArray();
        return doubles;
   }
   
    public List<Stop> readStopsArray(JsonReader reader) throws IOException{
        List<Stop> stops = new ArrayList<Stop>();
        
        reader.beginArray();
        while(reader.hasNext()){
            stops.add(constructStopObject(reader));
        }
        reader.endArray();
        return stops;
    }
    
    public Stop constructStopObject(JsonReader reader) throws IOException{
        String name = null;
        String arrivalTime = null;
        String departureTime = null;
        
        reader.beginObject();
        while(reader.hasNext()){
            String nextName = reader.nextName();
            if(nextName == "name"){
                name = reader.nextString();
            }else if(nextName == "arrives"){
                arrivalTime = reader.nextString();
            }else if(nextName == "departs"){
                departureTime = reader.nextString();
            }else{
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Stop(name, arrivalTime, departureTime);
    }

   public User readUser(JsonReader reader) throws IOException {
     String username = null;
     int followersCount = -1;

     reader.beginObject();
     while (reader.hasNext()) {
       String name = reader.nextName();
       if (name.equals("name")) {
         username = reader.nextString();
       } else if (name.equals("followers_count")) {
         followersCount = reader.nextInt();
       } else {
         reader.skipValue();
       }
     }
     reader.endObject();
     return new User(username, followersCount);
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
