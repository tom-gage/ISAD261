/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusGenerator;

import java.util.*;
import java.io.*;
import TrainStatusListener.*;
import com.google.gson.*;

/**
 *
 * @author Tom
 */
public class MockData {

    public static List<Train> getTrainsListA() {
        Stop mockStop = new Stop("stopNameA", "0000", "1111");
        List<Stop> mockStops = new ArrayList<Stop>();
        mockStops.add(mockStop);
        mockStops.add(mockStop);
        mockStops.add(mockStop);

        Train mockTrainX = new Train("0", "0000", "1111", "finalStopNameA", mockStops);
        Train mockTrainY = new Train("0", "0000", "1111", "finalStopNameA", mockStops);
        List<Train> mockTrainsList = new ArrayList<Train>();
        mockTrainsList.add(mockTrainX);
        mockTrainsList.add(mockTrainY);
        mockTrainsList.add(mockTrainX);

        return mockTrainsList;
    }

    public static List<Train> getTrainsListB() {
        Stop mockStop = new Stop("stopNameB", "2222", "3333");
        List<Stop> mockStops = new ArrayList<Stop>();
        mockStops.add(mockStop);
        mockStops.add(mockStop);
        mockStops.add(mockStop);

        Train mockTrainX = new Train("1", "0000", "1111", "finalStopNameB", mockStops);
        Train mockTrainY = new Train("1", "0000", null, "finalStopNameB", mockStops);
        List<Train> mockTrainsList = new ArrayList<Train>();
        mockTrainsList.add(mockTrainY);
        mockTrainsList.add(mockTrainX);
        mockTrainsList.add(mockTrainY);

        return mockTrainsList;
    }

    public static List<Train> getTrainsListC() {
        Stop mockStop = new Stop("stopNameB", "2222", "3333");
        List<Stop> mockStops = new ArrayList<Stop>();
        mockStops.add(mockStop);
        mockStops.add(mockStop);
        mockStops.add(mockStop);

        Train mockTrainX = new Train("2", "0000", null, "finalStopNameB", mockStops);
        Train mockTrainY = new Train("2", "0000", null, "finalStopNameB", mockStops);
        List<Train> mockTrainsList = new ArrayList<Train>();
        mockTrainsList.add(mockTrainY);
        mockTrainsList.add(mockTrainX);
        mockTrainsList.add(mockTrainY);

        return mockTrainsList;
    }

    public static List<Train> getOverdueTrainsListA() {
        Stop mockStop = new Stop("stopNameA", "0000", "1111");
        List<Stop> mockStops = new ArrayList<Stop>();
        mockStops.add(mockStop);
        mockStops.add(mockStop);
        mockStops.add(mockStop);

        Train mockTrainX = new Train("0", "0000", "1111", "finalStopNameA", mockStops);
        Train mockTrainY = new Train("0", "0000", "1111", "finalStopNameA", mockStops);
        List<Train> mockTrainsList = new ArrayList<Train>();
        mockTrainsList.add(mockTrainX);
        mockTrainsList.add(mockTrainY);
        mockTrainsList.add(mockTrainX);

        return mockTrainsList;
    }

    public static List<Train> getOverdueTrainsListB() {
        Stop mockStop = new Stop("stopNameB", "2222", "3333");
        List<Stop> mockStops = new ArrayList<Stop>();
        mockStops.add(mockStop);
        mockStops.add(mockStop);
        mockStops.add(mockStop);

        Train mockTrainX = new Train("1", "0000", "1111", "finalStopNameB", mockStops);
        List<Train> mockTrainsList = new ArrayList<Train>();
        mockTrainsList.add(mockTrainX);

        return mockTrainsList;
    }

    public static List<Train> getOverdueTrainsListC() {
        return null;
    }

    public static String getTrainsListAAsJson() {
        Gson gson = new Gson();
        String json = gson.toJson(MockData.getTrainsListA());
        return json;
    }

    public static String getTrainsListBAsJson() {
        Gson gson = new Gson();
        String json = gson.toJson(MockData.getTrainsListB());
        return json;
    }

    public static InputStream getJsonInputStream(String jsonString) {
        InputStream jsonStream = new ByteArrayInputStream(jsonString.getBytes());
        return jsonStream;
    }

    public static StatusListener getStatusListener() {
        return new StatusListener();
    }

    public static StatusGenerator getStatusGenerator() {
        StatusListener listener = new StatusListener();
        return new StatusGenerator(listener);
    }

    public static String getValidApiUrl() {
        String apiUrl = "http://web.socem.plymouth.ac.uk/david/trains.json";
        return apiUrl;
    }

    public static String getInvalidApiUrl() {
        String apiUrl = "abc";
        return apiUrl;
    }
}
