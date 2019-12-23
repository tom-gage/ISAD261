/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusGenerator;

import TrainStatusGenerator.Stop;
import TrainStatusGenerator.Train;
import TrainStatusGenerator.GetTrainsByStation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import TrainStatusListener.*;

/**
 *
 * @author Tom
 */
public class getTrainsByStationTest {

    private TrainStatusGenerator.GetTrainsByStation mockGetTrainsByStation;

    private java.util.List mockTrainsList;
    private java.util.List actualTrainsList;
    private java.util.List expectedTrainsList;

    private TrainStatusGenerator.Stop mockStopA;
    private TrainStatusGenerator.Stop mockStopB;
    private TrainStatusGenerator.Stop mockStopC;
    private TrainStatusGenerator.Stop mockStopD;

    private java.util.List mockStopsA;
    private java.util.List mockStopsB;
    private java.util.List mockStopsC;
    private java.util.List mockStopsD;

    private TrainStatusGenerator.Train mockTrainA;
    private TrainStatusGenerator.Train mockTrainB;
    private TrainStatusGenerator.Train mockTrainC;
    private TrainStatusGenerator.Train mockTrainD;

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
        mockGetTrainsByStation = new GetTrainsByStation();

        expectedTrainsList = new ArrayList<Train>();
        actualTrainsList = new ArrayList<Train>();

        mockStopA = new Stop("London", "0000", "1111");
        mockStopB = new Stop("Plymouth", "0000", "1111");
        mockStopC = new Stop("Exeter", "0000", "1111");

        //train a, has london, plymouth and exeter
        mockStopsA = new ArrayList<Stop>();
        mockStopsA.add(mockStopA);
        mockStopsA.add(mockStopB);
        mockStopsA.add(mockStopC);

        mockTrainA = new Train("0", "0000", null, mockStopsA);

        //train b, has plymouth
        mockStopsB = new ArrayList<Stop>();
        mockStopsB.add(mockStopB);

        mockTrainB = new Train("0", "0000", null, mockStopsB);

        //train c, has lots of exeter
        mockStopsC = new ArrayList<Stop>();

        mockTrainC = new Train("0", "0000", null, mockStopsC);
        mockStopsC.add(mockStopC);
        mockStopsC.add(mockStopC);
        mockStopsC.add(mockStopC);
        mockStopsC.add(mockStopC);
        mockStopsC.add(mockStopC);

        //train d, has nothing
        mockStopsD = new ArrayList<Stop>();

        mockTrainD = new Train("0", "0000", null, mockStopsD);

        mockTrainsList = new ArrayList<Train>();
        mockTrainsList.add(mockTrainA);
        mockTrainsList.add(mockTrainB);
        mockTrainsList.add(mockTrainC);
        mockTrainsList.add(mockTrainD);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void stationLondon() {
        actualTrainsList = mockGetTrainsByStation.getTrainsByStation("London", mockTrainsList);

        expectedTrainsList.add(mockTrainA);

        assertEquals("Fails to return trains by station name", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void stationPlymouth() {
        actualTrainsList = mockGetTrainsByStation.getTrainsByStation("Plymouth", mockTrainsList);

        expectedTrainsList.add(mockTrainA);
        expectedTrainsList.add(mockTrainB);

        assertEquals("Fails to return trains by station name", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void stationExeter() {
        actualTrainsList = mockGetTrainsByStation.getTrainsByStation("Exeter", mockTrainsList);

        expectedTrainsList.add(mockTrainA);
        expectedTrainsList.add(mockTrainC);

        assertEquals("Fails to return trains by station name", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void stationNotFound() {
        actualTrainsList = mockGetTrainsByStation.getTrainsByStation("Invalid", mockTrainsList);

        expectedTrainsList = null;

        assertEquals("Fails to return null", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void stationNull() {
        actualTrainsList = mockGetTrainsByStation.getTrainsByStation(null, mockTrainsList);

        expectedTrainsList = null;

        assertEquals("Fails to return null", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void trainsListNull() {
        actualTrainsList = mockGetTrainsByStation.getTrainsByStation("London", null);

        expectedTrainsList = null;

        assertEquals("Fails to return null", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void trainsListEmpty() {
        mockTrainsList = new ArrayList<Train>();
        actualTrainsList = mockGetTrainsByStation.getTrainsByStation("London", mockTrainsList);

        expectedTrainsList = null;

        assertEquals("Fails to return null", expectedTrainsList, actualTrainsList);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
