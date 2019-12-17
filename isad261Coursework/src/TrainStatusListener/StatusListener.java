/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;

import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 *
 * @author btgage
 */
public class StatusListener {

    public List<Train> getTrainData(String url) throws Exception {
        URL apiURL = new URL(url);
        HttpURLConnection myConnection = (HttpURLConnection) apiURL.openConnection();
        myConnection.setRequestMethod("GET");

        List<Train> trains = new ArrayList<Train>();
        trains = readJsonStream(myConnection.getInputStream());
        return trains;
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
        List stops = null;
        String platform = null;
        String departureTime = null;
        String expectedDepartureTime = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("stops")) {
                stops = readStopsArray(reader);
            } else if (name.equals("platform")) {
                platform = reader.nextString();
            } else if (name.equals("departs")) {
                departureTime = reader.nextString();
            } else if (name.equals("expected")) {
                expectedDepartureTime = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Train(platform, departureTime, expectedDepartureTime, stops);
    }

    public List<Stop> readStopsArray(JsonReader reader) throws IOException {
        List<Stop> stops = new ArrayList<Stop>();

        reader.beginArray();
        while (reader.hasNext()) {
            stops.add(constructStopObject(reader));
        }
        reader.endArray();
        return stops;
    }

    public Stop constructStopObject(JsonReader reader) throws IOException {
        String name = null;
        String arrivalTime = null;
        String departureTime = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName == "name") {
                name = reader.nextString();
            } else if (nextName == "arrives") {
                arrivalTime = reader.nextString();
            } else if (nextName == "departs") {
                departureTime = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Stop(name, arrivalTime, departureTime);
    }
}