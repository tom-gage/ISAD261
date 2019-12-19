/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusListener;

import TrainStatusListener.StatusListener;
import TrainStatusListener.Stop;
import TrainStatusListener.Train;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class readStopsArrayTest {

    private TrainStatusListener.StatusListener mockListener;

    private java.io.File jsonDataA;
    private java.io.File jsonDataB;

    private java.io.InputStream inputA;
    private java.io.InputStream inputB;

    private JsonReader readerA;
    private JsonReader readerB;

    //stops list actual
    private java.util.List actualStopsList;

    //stops list a
    private TrainStatusListener.Stop mockStopA;
    private java.util.List mockStopsAExpected;

    //trainslist b
    private TrainStatusListener.Stop mockStopB;
    private java.util.List mockStopsBExpected;

    public readStopsArrayTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, UnsupportedEncodingException {
        mockListener = new StatusListener();

        actualStopsList = new ArrayList<Train>();

        mockStopA = new Stop("stopNameA", "0000", "1111");
        mockStopsAExpected = new ArrayList<Stop>();
        mockStopsAExpected.add(mockStopA);
        mockStopsAExpected.add(mockStopA);
        mockStopsAExpected.add(mockStopA);

        mockStopB = new Stop("stopNameB", "0000", "1111");
        mockStopsBExpected = new ArrayList<Stop>();
        mockStopsBExpected.add(mockStopB);
        mockStopsBExpected.add(mockStopB);
        mockStopsBExpected.add(mockStopB);

        jsonDataA = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataAStops.json");
        jsonDataB = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataBStops.json");

//        jsonDataA = new File("\\StatusListener\\jsonDataA.json");
//        jsonDataB = new File("\\StatusListener\\jsonDataB.json");
        inputA = new FileInputStream(jsonDataA);
        inputB = new FileInputStream(jsonDataB);

        readerA = new JsonReader(new InputStreamReader(inputA, "UTF-8"));
        readerB = new JsonReader(new InputStreamReader(inputB, "UTF-8"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testReadStopsArrayA() throws IOException {
        actualStopsList = mockListener.readStopsArray(readerA);

        for (int i = 0; i < mockStopsAExpected.size(); i++) {

            Stop stop = (Stop) mockStopsAExpected.get(i);
            Stop stopActual = (Stop) actualStopsList.get(i);

            assertEquals("Fails to return trains list properly", stop.getName(), stopActual.getName());
            assertEquals("Fails to return trains list properly", stop.getArrivalTime(), stopActual.getArrivalTime());
            assertEquals("Fails to return trains list properly", stop.getDepartureTime(), stopActual.getDepartureTime());
        }
    }

    @Test
    public void testReadStopsArrayB() throws IOException {
        actualStopsList = mockListener.readStopsArray(readerB);

        for (int i = 0; i < mockStopsBExpected.size(); i++) {

            Stop stop = (Stop) mockStopsBExpected.get(i);
            Stop stopActual = (Stop) actualStopsList.get(i);

            assertEquals("Fails to return trains list properly", stop.getName(), stopActual.getName());
            assertEquals("Fails to return trains list properly", stop.getArrivalTime(), stopActual.getArrivalTime());
            assertEquals("Fails to return trains list properly", stop.getDepartureTime(), stopActual.getDepartureTime());
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
