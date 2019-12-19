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
public class constructTrainObjectTest {

    private TrainStatusListener.StatusListener mockListener;

    private java.io.File jsonDataA;
    private java.io.File jsonDataB;

    private java.io.InputStream inputA;
    private java.io.InputStream inputB;

    private JsonReader readerA;
    private JsonReader readerB;

    //train actual
    private TrainStatusListener.Train actualTrain;

    //train a
    private TrainStatusListener.Stop mockStopA;
    private java.util.List mockStopsA;
    private TrainStatusListener.Train mockTrainAExpected;

    //train b
    private TrainStatusListener.Stop mockStopB;
    private java.util.List mockStopsB;
    private TrainStatusListener.Train mockTrainBExpected;

    public constructTrainObjectTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws UnsupportedEncodingException, FileNotFoundException {
        mockListener = new StatusListener();

        actualTrain = new Train();

        mockStopA = new Stop("stopNameA", "0000", "1111");
        mockStopsA = new ArrayList<Stop>();
        mockStopsA.add(mockStopA);
        mockStopsA.add(mockStopA);
        mockStopsA.add(mockStopA);

        mockTrainAExpected = new Train("0", "0000", null, mockStopsA);

        mockStopB = new Stop("stopNameB", "0000", "1111");
        mockStopsB = new ArrayList<Stop>();
        mockStopsB.add(mockStopB);
        mockStopsB.add(mockStopB);
        mockStopsB.add(mockStopB);

        mockTrainBExpected = new Train("1", "0000", "1111", mockStopsB);

        jsonDataA = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataATrain.json");
        jsonDataB = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataBTrain.json");

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
    public void testConstructTrainObjectA() throws IOException {
        actualTrain = mockListener.constructTrainObject(readerA);

        assertEquals("Fails to return train properly", actualTrain.getPlatform(), mockTrainAExpected.getPlatform());
        assertEquals("Fails to return train properly", actualTrain.getDepartureTime(), mockTrainAExpected.getDepartureTime());
        assertEquals("Fails to return train properly", actualTrain.getExpectedDepartureTime(), mockTrainAExpected.getExpectedDepartureTime());
        assertEquals("Fails to return train properly", actualTrain.getStops().getClass(), mockTrainAExpected.getStops().getClass());

    }

    @Test
    public void testConstructTrainObjectB() throws IOException {
        actualTrain = mockListener.constructTrainObject(readerB);

        assertEquals("Fails to return train properly, platform", actualTrain.getPlatform(), mockTrainBExpected.getPlatform());
        assertEquals("Fails to return train properly, depart", actualTrain.getDepartureTime(), mockTrainBExpected.getDepartureTime());
        assertEquals("Fails to return train properly, expected", actualTrain.getExpectedDepartureTime(), mockTrainBExpected.getExpectedDepartureTime());
        assertEquals("Fails to return train properly, stops", actualTrain.getStops().getClass(), mockTrainBExpected.getStops().getClass());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
