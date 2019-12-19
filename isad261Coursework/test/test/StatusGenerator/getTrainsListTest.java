/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusGenerator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import TrainStatusListener.*;
import test.StatusGenerator.MockData;

/**
 *
 * @author Tom
 */
public class getTrainsListTest {

    private TrainStatusListener.StatusListener mockListener;
    private TrainStatusListener.StatusGenerator mockGenerator;

    private String validApiUrl;
    private String invalidApiUrl;

    private java.util.List actualTrainsList;

    private TrainStatusListener.Stop mockStopA;
    private java.util.List mockStopsA;

    private TrainStatusListener.Train mockTrainA;
    private java.util.List mockTrainsListA;

    public getTrainsListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mockListener = new StatusListener();
        mockGenerator = new StatusGenerator(mockListener);

        validApiUrl = "http://web.socem.plymouth.ac.uk/david/trains.json";
        invalidApiUrl = "abc";

        actualTrainsList = new ArrayList<Train>();

        mockStopA = new Stop("stopNameA", "0000", "1111");
        mockStopsA = new ArrayList<Stop>();
        mockStopsA.add(mockStopA);
        mockStopsA.add(mockStopA);
        mockStopsA.add(mockStopA);

        mockTrainA = new Train("0", "0000", null, "finalStopNameA", mockStopsA);
        mockTrainsListA = new ArrayList<Train>();
        mockTrainsListA.add(mockTrainA);
        mockTrainsListA.add(mockTrainA);
        mockTrainsListA.add(mockTrainA);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetTrainsListValidAPI() {

        actualTrainsList = mockGenerator.getTrainsList(validApiUrl);

        assertEquals("Fails to return a list of Trains", actualTrainsList.getClass(), mockTrainsListA.getClass());
        assertFalse("List returned is empty", actualTrainsList.isEmpty());
    }

    @Test
    public void testGetTrainsListInvalidAPI() {
        actualTrainsList = mockGenerator.getTrainsList(invalidApiUrl);
        
        assertEquals("Fails to return null", actualTrainsList, null);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
