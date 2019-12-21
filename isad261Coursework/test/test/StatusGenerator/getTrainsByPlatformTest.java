/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusGenerator;

import TrainStatusGenerator.Stop;
import TrainStatusGenerator.Train;
import TrainStatusGenerator.GetTrainsByPlatform;
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
public class getTrainsByPlatformTest {
    private TrainStatusGenerator.GetTrainsByPlatform mockGetTrainsByPlatform;

    private java.util.List actualTrainsList;

    private TrainStatusGenerator.Stop mockStopA;
    private java.util.List mockStopsA;

    private TrainStatusGenerator.Train mockTrainA;
    private java.util.List mockTrainsListA;

    private java.util.List mockTrainsListAExpected;

    private TrainStatusGenerator.Stop mockStopB;
    private java.util.List mockStopsB;

    private TrainStatusGenerator.Train mockTrainB;
    private java.util.List mockTrainsListB;

    private java.util.List mockTrainsListBExpected;

    public getTrainsByPlatformTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mockGetTrainsByPlatform = new GetTrainsByPlatform();

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

        mockTrainB = new Train("1", "0000", "1111", "finalStopNameB", mockStopsB);
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
    public void testGetTrainsByPlatformValidPlatformA() {
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(0, mockTrainsListA);

        assertEquals("Fails to return a list of trains", mockTrainsListAExpected, actualTrainsList);
    }

    @Test
    public void testGetTrainsByPlatformValidPlatformB() {
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(1, mockTrainsListB);

        assertEquals("Fails to return a list of trains", mockTrainsListBExpected, actualTrainsList);
    }

    @Test
    public void testGetTrainsByPlatformInvalidPlatform() {
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(-1, mockTrainsListA);

        assertEquals("Fails to return a list of trains", null, actualTrainsList);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
