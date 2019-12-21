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
    private String expectedNoticeC;
    private String expectedNoticeD;

    private TrainStatusGenerator.Stop mockStop;
    private java.util.List mockStopsList;

    private TrainStatusGenerator.Train mockTrainA;
    private java.util.List mockTrainsListA;

    private TrainStatusGenerator.Stop mockStopB;
    private java.util.List mockStopsB;

    private TrainStatusGenerator.Train mockTrainB;
    private java.util.List mockTrainsListB;

    private TrainStatusGenerator.Stop mockStopC;
    private java.util.List mockStopsC;

    private TrainStatusGenerator.Train mockTrainC;
    private java.util.List mockTrainsListC;

    private TrainStatusGenerator.Stop mockStopD;
    private java.util.List mockStopsD;

    private TrainStatusGenerator.Train mockTrainD;
    private java.util.List mockTrainsListD;

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

        //mock stops
        mockStop = new Stop("stopName", "0000", "1111");
        mockStopsList = new ArrayList<Stop>();
        mockStopsList.add(mockStop);
        mockStopsList.add(mockStop);
        mockStopsList.add(mockStop);

        //no trains overdue
        mockTrainA = new Train("0", "0000", null, mockStopsList);
        mockTrainsListA = new ArrayList<Train>();
        mockTrainsListA.add(mockTrainA);
        mockTrainsListA.add(mockTrainA);
        mockTrainsListA.add(mockTrainA);

        //all trains overdue
        mockTrainB = new Train("0", "0000", "1111", mockStopsList);
        mockTrainsListB = new ArrayList<Train>();
        mockTrainsListB.add(mockTrainB);
        mockTrainsListB.add(mockTrainB);
        mockTrainsListB.add(mockTrainB);

        //trains list empty
        mockTrainC = new Train("0", "0000", "1111", mockStopsList);
        mockTrainsListC = new ArrayList<Train>();

        //some trains overdue
        mockTrainD = new Train("0", "0000", "1111", mockStopsList);
        mockTrainsListD = new ArrayList<Train>();
        mockTrainsListD.add(mockTrainB);
        mockTrainsListD.add(mockTrainA);
        mockTrainsListD.add(mockTrainB);

        actualNotice = new String();

        expectedNoticeA = null;
        expectedNoticeB = "The following trains are delayed: \n"
                + "The 0000 train to stopName is delayed and will depart at 1111. \n"
                + "The 0000 train to stopName is delayed and will depart at 1111. \n"
                + "The 0000 train to stopName is delayed and will depart at 1111. \n";
        expectedNoticeC = null;
        expectedNoticeD = "The following trains are delayed: \n"
                + "The 0000 train to stopName is delayed and will depart at 1111. \n"
                + "The 0000 train to stopName is delayed and will depart at 1111. \n";
    }

    @After
    public void tearDown() {
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

    @Test
    public void testGetOverdueTrainsNoticeC() {
        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsListC);

        assertEquals("Fails to return overdue notice properly", expectedNoticeC, actualNotice);
    }

    @Test
    public void testGetOverdueTrainsNoticeD() {
        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsListD);

        assertEquals("Fails to return overdue notice properly", expectedNoticeD, actualNotice);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
