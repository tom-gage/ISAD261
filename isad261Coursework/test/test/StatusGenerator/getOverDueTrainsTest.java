/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusGenerator;

import TrainStatusGenerator.Stop;
import TrainStatusGenerator.Train;
import TrainStatusGenerator.GetOverDueTrains;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import TrainStatusListener.*;
import com.sun.javafx.scene.control.skin.VirtualFlow;

/**
 *
 * @author Tom
 */
public class getOverDueTrainsTest {

    private TrainStatusGenerator.GetOverDueTrains mockGetOverdueTrains;

    private String actualNotice;

    private String expectedNoticeA;
    private String expectedNoticeB;

    private TrainStatusGenerator.Stop mockStopA;
    private java.util.List mockStopsA;

    private TrainStatusGenerator.Train mockTrainA;
    private java.util.List mockTrainsListA;

    private TrainStatusGenerator.Stop mockStopB;
    private java.util.List mockStopsB;

    private TrainStatusGenerator.Train mockTrainB;
    private java.util.List mockTrainsListB;

    public getOverDueTrainsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mockGetOverdueTrains = new GetOverDueTrains();


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


        actualNotice = new String();

        expectedNoticeA = null;
        expectedNoticeB = "The following trains are delayed: \n"
                + "The 0000 train to stopNameB is delayed and will depart at 1111. \n"
                + "The 0000 train to stopNameB is delayed and will depart at 1111. \n"
                + "The 0000 train to stopNameB is delayed and will depart at 1111. \n";
    }

    @After
    public void tearDown() {
        mockStopA = null;
        mockStopsA = null;
        mockTrainA = null;
        mockTrainsListA = null;

        mockStopB = null;
        mockStopsB = null;
        mockTrainB = null;
        mockTrainsListB = null;
    }


    @Test
    public void testGetOverdueTrainsNoticeA() {
        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsListA);

        assertEquals("Fails to return null", expectedNoticeA, actualNotice);
    }

    @Test
    public void testGetOverdueTrainsNoticeB() {
        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsListB);

        assertEquals("Fails to return overdue notice properly", expectedNoticeB, actualNotice);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
