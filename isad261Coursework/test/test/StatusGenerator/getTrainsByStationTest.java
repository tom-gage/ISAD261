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
public class getTrainsByStationTest {

    private TrainStatusListener.StatusListener mockListener;
    private TrainStatusListener.StatusGenerator mockGenerator;

    private java.util.List actualTrainsList;

    private TrainStatusListener.Stop mockStopA;
    private java.util.List mockStopsA;

    private TrainStatusListener.Train mockTrainA;
    private java.util.List mockTrainsListA;

    private java.util.List mockTrainsListAExpected;

    private TrainStatusListener.Stop mockStopB;
    private java.util.List mockStopsB;

    private TrainStatusListener.Train mockTrainB;
    private java.util.List mockTrainsListB;

    private java.util.List mockTrainsListBExpected;

    public getTrainsByStationTest() {
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

        mockTrainsListAExpected = new ArrayList<Train>();
        mockTrainsListAExpected.add(mockTrainA);
        mockTrainsListAExpected.add(mockTrainA);
        mockTrainsListAExpected.add(mockTrainA);
        
        

        mockStopB = new Stop("stopNameB", "0000", "1111");
        mockStopsB = new ArrayList<Stop>();
        mockStopsB.add(mockStopB);
        mockStopsB.add(mockStopB);
        mockStopsB.add(mockStopB);

        mockTrainB = new Train("0", "0000", "1111", "finalStopNameB", mockStopsB);
        mockTrainsListB = new ArrayList<Train>();
        mockTrainsListB.add(mockTrainB);
        mockTrainsListB.add(mockTrainB);
        mockTrainsListB.add(mockTrainB);

        mockTrainsListBExpected = new ArrayList<Train>();
        mockTrainsListBExpected.add(mockTrainB);
        mockTrainsListBExpected.add(mockTrainB);
        mockTrainsListBExpected.add(mockTrainB);
    }

    @After
    public void tearDown() {
        actualTrainsList = null;

        mockStopA = null;
        mockStopsA = null;
        mockTrainA = null;
        mockTrainsListA = null;
        mockTrainsListAExpected = null;

        mockStopB = null;
        mockStopsB = null;
        mockTrainB = null;
        mockTrainsListB = null;
        mockTrainsListBExpected = null;
    }

    @Test
    public void testGetTrainsByStation_ValidStationA() {
        actualTrainsList = mockGenerator.getTrainsByStation("stopNameA", mockTrainsListA);
        
        System.err.println("A TEST");
        System.err.println(mockTrainsListA);
        System.err.println(actualTrainsList);
        System.err.println(mockTrainsListAExpected);

        assertEquals("Fails to return trains by station name", actualTrainsList, mockTrainsListAExpected);
    }

    @Test
    public void testGetTrainsByStation_ValidStationB() {
        actualTrainsList = mockGenerator.getTrainsByStation("stopNameB", mockTrainsListB);

        System.err.println("B TEST");
        System.err.println(mockTrainsListB);
        System.err.println(actualTrainsList);
        System.err.println(mockTrainsListBExpected);

        assertEquals("Fails to return trains by station name", actualTrainsList, mockTrainsListBExpected);
    }

    @Test
    public void testGetTrainsByStation_InvalidStation() {
        actualTrainsList = mockGenerator.getTrainsByStation("---", mockTrainsListA);

        assertEquals("Fails to return null", actualTrainsList, null);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
