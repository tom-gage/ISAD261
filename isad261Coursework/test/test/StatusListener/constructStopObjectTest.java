/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusListener;

import TrainStatusListener.StatusListener;
import TrainStatusListener.Stop;
import TrainStatusListener.Train;
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
public class constructStopObjectTest {

    private TrainStatusListener.StatusListener mockListener;

    private java.io.File jsonDataA;
    private java.io.File jsonDataB;

    private java.io.InputStream inputA;
    private java.io.InputStream inputB;

    private JsonReader readerA;
    private JsonReader readerB;

    //stop actual
    private TrainStatusListener.Stop actualStop;

    //stop a
    private TrainStatusListener.Stop mockStopAExpected;

    //Stop b
    private TrainStatusListener.Stop mockStopBExpected;

    public constructStopObjectTest() {
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

        actualStop = new Stop();

        mockStopAExpected = new Stop("stopNameA", "0000", "1111");

        mockStopBExpected = new Stop("stopNameB", "9999", "1111");

        jsonDataA = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataAStop.json");
        jsonDataB = new File("C:\\Users\\Tom\\Documents\\ISAD261\\isad261Coursework\\test\\test\\StatusListener\\jsonDataBStop.json");

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
    public void testConstructStopObjectA() throws IOException {
        actualStop = mockListener.constructStopObject(readerA);

        assertEquals("Failed to return proper Stop", mockStopAExpected.getName(), actualStop.getName());
        assertEquals("Failed to return proper Stop", mockStopAExpected.getArrivalTime(), actualStop.getArrivalTime());
        assertEquals("Failed to return proper Stop", mockStopAExpected.getDepartureTime(), actualStop.getDepartureTime());

    }

    @Test
    public void testConstructStopObjectB() throws IOException {
        actualStop = mockListener.constructStopObject(readerB);

        assertEquals("Failed to return proper Stop", mockStopBExpected.getName(), actualStop.getName());
        assertEquals("Failed to return proper Stop", mockStopBExpected.getArrivalTime(), actualStop.getArrivalTime());
        assertEquals("Failed to return proper Stop", mockStopBExpected.getDepartureTime(), actualStop.getDepartureTime());

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
