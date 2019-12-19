/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusListener;

import TrainStatusListener.*;
import java.util.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.StatusGenerator.MockData;

/**
 *
 * @author Tom
 */
public class readJsonStreamTest {

    private TrainStatusListener.StatusListener mockListener;

    private java.io.File jsonDataA;
    private java.io.File jsonDataB;

    private java.io.InputStream inputA;
    private java.io.InputStream inputB;

    private java.util.List actualTrainsList;

    //trainslist a
    private TrainStatusListener.Stop mockStopA;
    private java.util.List mockStopsA;
    private TrainStatusListener.Train mockTrainA;
    private java.util.List mockTrainsListA;

    private java.util.List mockTrainsListAExpected;

    //trainslist b
    private TrainStatusListener.Stop mockStopB;
    private java.util.List mockStopsB;
    private TrainStatusListener.Train mockTrainB;
    private java.util.List mockTrainsListB;

    private java.util.List mockTrainsListBExpected;

    public readJsonStreamTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        mockListener = new StatusListener();

        actualTrainsList = new ArrayList<Train>();

        mockStopA = new Stop("stopNameA", "0000", "1111");
        mockStopsA = new ArrayList<Stop>();
        mockStopsA.add(mockStopA);
        mockStopsA.add(mockStopA);
        mockStopsA.add(mockStopA);

        mockTrainA = new Train("0", "0000", null, mockStopsA);
        mockTrainsListA = new ArrayList<Train>();
        mockTrainsListA.add(mockTrainA); 
        mockTrainsListA.add(mockTrainA);
        mockTrainsListA.add(mockTrainA);

        mockTrainsListAExpected = new ArrayList<Train>();
        mockTrainsListAExpected.add(mockTrainA);
        mockTrainsListAExpected.add(mockTrainA);
        mockTrainsListAExpected.add(mockTrainA);

        
        
        mockStopB = new Stop("stopNameB", "0000", "1111");
        mockStopsB = new ArrayList<Stop>();
        mockStopsB.add(mockStopB);
        mockStopsB.add(mockStopB);
        mockStopsB.add(mockStopB);

        mockTrainB = new Train("1", "0000", "1111", mockStopsB);
        mockTrainsListB = new ArrayList<Train>();
        mockTrainsListB.add(mockTrainB);
        mockTrainsListB.add(mockTrainB);
        mockTrainsListB.add(mockTrainB);

        mockTrainsListBExpected = new ArrayList<Train>();
        mockTrainsListBExpected.add(mockTrainB);
        mockTrainsListBExpected.add(mockTrainB);
        mockTrainsListBExpected.add(mockTrainB);

        Gson gson = new Gson();

        jsonDataA = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataA.json");
        jsonDataB = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataB.json");

        inputA = new FileInputStream(jsonDataA);
        inputB = new FileInputStream(jsonDataB);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testReadJsonStream_validInputStreamA() throws IOException {
        actualTrainsList = mockListener.readJsonStream(inputA);

        for (int i = 0; i < mockTrainsListAExpected.size(); i++) {
            Train train = (Train) mockTrainsListAExpected.get(i);
            Train trainActual = (Train) actualTrainsList.get(i);

            assertEquals("Fails to return trains list properly", train.getPlatform(), trainActual.getPlatform());
            assertEquals("Fails to return trains list properly", train.getDepartureTime(), trainActual.getDepartureTime());
            assertEquals("Fails to return trains list properly", train.getExpectedDepartureTime(), trainActual.getExpectedDepartureTime());

            List<Stop> stopsList = train.getStops();
            List<Stop> stopsListActual = trainActual.getStops();

            for (int x = 0; x < stopsList.size(); x++) {
                Stop stop = stopsList.get(x);
                Stop stopActual = stopsListActual.get(x);

                assertEquals("Fails to return trains list properly", stop.getName(), stopActual.getName());
                assertEquals("Fails to return trains list properly", stop.getArrivalTime(), stopActual.getArrivalTime());
                assertEquals("Fails to return trains list properly", stop.getDepartureTime(), stopActual.getDepartureTime());
            }

        }
        //due to the incredibly frustrating way that assertEquals works the test below does not pass despite the lists having identical contents, hence the jank  
//        assertEquals("Fails to return trains list properly", mockTrainsListAExpected, actualTrainsList);
    }

    @Test
    public void testReadJsonStream_validInputStreamB() throws IOException {
        actualTrainsList = mockListener.readJsonStream(inputB);

        for (int i = 0; i < mockTrainsListBExpected.size(); i++) {
            Train train = (Train) mockTrainsListBExpected.get(i);
            Train trainActual = (Train) actualTrainsList.get(i);

            assertEquals("Fails to return trains list properly", train.getPlatform(), trainActual.getPlatform());
            assertEquals("Fails to return trains list properly", train.getDepartureTime(), trainActual.getDepartureTime());
            assertEquals("Fails to return trains list properly", train.getExpectedDepartureTime(), trainActual.getExpectedDepartureTime());

            List<Stop> stopsList = train.getStops();
            List<Stop> stopsListActual = trainActual.getStops();

            for (int x = 0; x < stopsList.size(); x++) {
                Stop stop = stopsList.get(x);
                Stop stopActual = stopsListActual.get(x);

                assertEquals("Fails to return trains list properly", stop.getName(), stopActual.getName());
                assertEquals("Fails to return trains list properly", stop.getArrivalTime(), stopActual.getArrivalTime());
                assertEquals("Fails to return trains list properly", stop.getDepartureTime(), stopActual.getDepartureTime());
            }
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
