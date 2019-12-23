/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.integration.StatusGenerator;

import TrainStatusGenerator.GetOverDueTrains;
import TrainStatusGenerator.Stop;
import TrainStatusGenerator.Train;
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
public class getOverDueTrainsITest {

    private TrainStatusListener.StatusListener listener;
    private TrainStatusGenerator.GetOverDueTrains getOverdueTrains;
    private java.util.List trainsList;

    private String apiUrl;
    private String actualNotice;

    private String expectedNotice;

    public getOverDueTrainsITest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        getOverdueTrains = new GetOverDueTrains();
        listener = new TrainStatusListener.StatusListener();
        trainsList = new ArrayList<Train>();
        

        apiUrl = "http://web.socem.plymouth.ac.uk/david/trains.json";
        actualNotice = new String();

        expectedNotice = "The following trains are delayed: \n"
                + "The 1007 train to Paignton is delayed and will depart at 1015. \n"
                + "The 1150 train to London Paddington is delayed and will depart at 1159. \n";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void integrationTestGetOverdueTrainsNotice() throws Exception {
        trainsList = listener.getTrainData(apiUrl);
        actualNotice = getOverdueTrains.getOverdueTrainsNotice(trainsList);
        
        assertEquals("Fails to return overdue trains notice", expectedNotice, actualNotice);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
