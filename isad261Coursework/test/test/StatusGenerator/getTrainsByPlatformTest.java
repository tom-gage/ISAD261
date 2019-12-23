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

    private java.util.List mockTrainsList;
    private java.util.List actualTrainsList;

    private java.util.List expectedTrainsList;

    private TrainStatusGenerator.Stop mockStop;
    private java.util.List mockStops;

    private TrainStatusGenerator.Train mockTrainA;

    private TrainStatusGenerator.Train mockTrainB;

    private TrainStatusGenerator.Train mockTrainC;

    private TrainStatusGenerator.Train mockTrainD;

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

        mockTrainsList = new ArrayList<Train>();
        actualTrainsList = new ArrayList<Train>();
        expectedTrainsList = new ArrayList<Train>();

        mockStops = new ArrayList<Stop>();


        //mock trains
        mockTrainA = new Train("0", "0000", "1111", mockStops);
        mockTrainB = new Train("1", "0000", "1111", mockStops);
        mockTrainC = new Train("99999", "0000", "1111", mockStops);
        mockTrainD = new Train("-99999", "0000", "1111", mockStops);

        for (int i = 0; i < 2; i++) {
            mockTrainsList.add(mockTrainA);
            mockTrainsList.add(mockTrainB);
            mockTrainsList.add(mockTrainC);
            mockTrainsList.add(mockTrainD);
        }

    }

    @After
    public void tearDown() {
        actualTrainsList = null;

        mockStop = null;
        mockStops = null;
        mockTrainA = null;
        mockTrainB = null;
    }

    @Test
    public void platformZero() {
        //platform 0
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(0, mockTrainsList);

        expectedTrainsList.add(mockTrainA);
        expectedTrainsList.add(mockTrainA);

        assertEquals("Fails to return a list of trains", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void platformOne() {
        //platform 2
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(1, mockTrainsList);

        expectedTrainsList.add(mockTrainB);
        expectedTrainsList.add(mockTrainB);

        assertEquals("Fails to return a list of trains", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void platformHigh() {
        //platform 99999
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(99999, mockTrainsList);

        expectedTrainsList.add(mockTrainC);
        expectedTrainsList.add(mockTrainC);

        assertEquals("Fails to return a list of trains", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void platformNegative() {
        //platform -99999 
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(-99999, mockTrainsList);

        expectedTrainsList.add(mockTrainD);
        expectedTrainsList.add(mockTrainD);

        assertEquals("Fails to return a list of trains", expectedTrainsList, actualTrainsList);
    }

    @Test
    public void platformNotFound() {
        //no such platform
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(-1, mockTrainsList);

        assertEquals("Fails to return null", null, actualTrainsList);
    }

    @Test
    public void emptyTrainsList() {
        //no such train
        actualTrainsList = mockGetTrainsByPlatform.getTrainsByPlatform(0, null);

        assertEquals("Fails to return null", null, actualTrainsList);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
