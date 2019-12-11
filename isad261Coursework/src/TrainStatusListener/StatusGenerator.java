/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;

import com.google.gson.Gson; 
import java.util.List;
import java.io.InputStreamReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
       return readMessagesArray(reader);
     } finally {
       reader.close();
     }
   }

   public List<Message> readMessagesArray(JsonReader reader) throws IOException {
     List<Message> messages = new ArrayList<Message>();

     reader.beginArray();
     while (reader.hasNext()) {
       messages.add(readMessage(reader));
     }
     reader.endArray();
     return messages;
   }

   public Message readMessage(JsonReader reader) throws IOException {
     long id = -1;
     String text = null;
     User user = null;
     List<Double> geo = null;

     reader.beginObject();
     while (reader.hasNext()) {
       String name = reader.nextName();
       if (name.equals("id")) {
         id = reader.nextLong();
       } else if (name.equals("text")) {
         text = reader.nextString();
       } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
         geo = readDoublesArray(reader);
       } else if (name.equals("user")) {
         user = readUser(reader);
       } else {
         reader.skipValue();
       }
     }
     reader.endObject();
     return new Message(id, text, user, geo);
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
