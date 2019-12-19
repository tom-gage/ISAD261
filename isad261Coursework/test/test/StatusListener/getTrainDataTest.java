/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.StatusListener;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import TrainStatusListener.*;
import test.StatusGenerator.MockData;
import java.util.*;

/**
 *
 * @author Tom
 */
public class getTrainDataTest {

    private TrainStatusListener.StatusListener mockListener;
    private String validApiUrl;
    private String invalidApiUrl;

    private java.util.List expected;
    private java.util.List actual;

    public getTrainDataTest() {
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
        validApiUrl = "http://web.socem.plymouth.ac.uk/david/trains.json";
        invalidApiUrl = "abc";

        expected = new ArrayList<Train>();
        actual = new ArrayList<Train>();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetTrainDataValidUrl() throws Exception {
        actual = mockListener.getTrainData(validApiUrl);

        assertEquals("Fails to return a list of Trains", actual.getClass(), expected.getClass());
        assertFalse("List returned is empty", actual.isEmpty());
    }

    @Test
    public void testGetTrainDataInvalidUrl() throws Exception {
        actual = mockListener.getTrainData(invalidApiUrl);

        assertEquals("Fails to return null", actual, null);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
