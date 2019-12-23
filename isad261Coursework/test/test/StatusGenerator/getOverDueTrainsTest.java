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
    private java.util.List mockTrainsList;

    private TrainStatusGenerator.Train mockTrainB;


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

        //mock train a
        mockTrainA = new Train("0", "0000", null, mockStopsList);
        //mock train b
        mockTrainB = new Train("0", "0000", "1111", mockStopsList);

        mockTrainsList = new ArrayList<Train>();

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
    public void noTrainsOverdue() {
        //no trains overdue
        mockTrainsList.add(mockTrainA);
        mockTrainsList.add(mockTrainA);
        mockTrainsList.add(mockTrainA);
        
        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsList);

        assertEquals("Fails to return null", expectedNoticeA, actualNotice);
    }

    @Test
    public void allTrainsOverdue() {
        //all trains overdue
        mockTrainsList.add(mockTrainB);
        mockTrainsList.add(mockTrainB);
        mockTrainsList.add(mockTrainB);
        
        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsList);

        assertEquals("Fails to return overdue notice properly", expectedNoticeB, actualNotice);
    }

    @Test
    public void emptyTrainsArray() {
        //no trains
        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsList);

        assertEquals("Fails to return overdue notice properly", expectedNoticeC, actualNotice);
    }

    @Test
    public void someTrainsOverdue() {
        //mixed trains
        mockTrainsList.add(mockTrainB);
        mockTrainsList.add(mockTrainA);
        mockTrainsList.add(mockTrainB);

        actualNotice = mockGetOverdueTrains.getOverdueTrainsNotice(mockTrainsList);

        assertEquals("Fails to return overdue notice properly", expectedNoticeD, actualNotice);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
