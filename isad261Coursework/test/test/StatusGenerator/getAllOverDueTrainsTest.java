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
import com.sun.javafx.scene.control.skin.VirtualFlow;
import test.StatusGenerator.MockData;

/**
 *
 * @author Tom
 */
public class getAllOverDueTrainsTest {

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

    public getAllOverDueTrainsTest() {
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
        mockTrainsListAExpected = null;
        
        

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
    public void testGetAllOverdueTrainsA() {
        actualTrainsList = mockGenerator.getAllOverdueTrains(mockTrainsListA);

        System.err.println("TEST BEGIN");
        System.err.println(actualTrainsList);
        System.err.println(mockTrainsListAExpected);
        System.err.println(mockTrainsListA);

        assertEquals("Fails to return a list of overdue trains", actualTrainsList, mockTrainsListAExpected);
    }

    @Test
    public void testGetAllOverdueTrainsB() {
        actualTrainsList = mockGenerator.getAllOverdueTrains(mockTrainsListB);

        System.err.println("TEST BEGIN");
        System.err.println(actualTrainsList);
        System.err.println(mockTrainsListBExpected);
        System.err.println(mockTrainsListB);

        assertEquals("Fails to return a list of overdue trains", actualTrainsList, mockTrainsListBExpected);
    }    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
