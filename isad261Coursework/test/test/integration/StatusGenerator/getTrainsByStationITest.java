/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.integration.StatusGenerator;

import TrainStatusListener.StatusListener;
import com.google.gson.Gson;
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
public class getTrainsByStationITest {

    private TrainStatusListener.StatusListener listener;
    private TrainStatusGenerator.GetTrainsByStation getTrainsByStation;
    private String apiUrl;

    private Gson gson;

    private java.util.List trainsListActual;
    private java.util.List trainsListExpectedA;
    private java.util.List trainsListExpectedB;

    private String jsonActual;
    private String jsonExpectedA;
    private String jsonExpectedB;

    private String stationA;
    private String stationB;

    public getTrainsByStationITest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        listener = new StatusListener();
        getTrainsByStation = new TrainStatusGenerator.GetTrainsByStation();
        apiUrl = "http://web.socem.plymouth.ac.uk/david/trains.json";
        trainsListActual = new ArrayList();

        jsonActual = new String();
        jsonExpectedA
                = "[{\"platform\":\"2\",\"departs\":\"0947\",\"stops\":[{\"name\":\"Totnes\",\"arrives\":\"0959\",\"departs\":\"1000\"},{\"name\":\"Ivybridge\",\"arrives\":\"1016\",\"departs\":\"1016\"},{\"name\":\"Plymouth\",\"arrives\":\"1029\",\"departs\":\"1033\"},{\"name\":\"Saltash\",\"arrives\":\"1041\",\"departs\":\"1042\"},{\"name\":\"St Germans\",\"arrives\":\"1048\",\"departs\":\"1049\"},{\"name\":\"Liskeard\",\"arrives\":\"1100\",\"departs\":\"1101\"},{\"name\":\"Bodmin Parkway\",\"arrives\":\"1115\",\"departs\":\"1117\"},{\"name\":\"Par\",\"arrives\":\"1127\",\"departs\":\"1128\"},{\"name\":\"St Austell\",\"arrives\":\"1135\",\"departs\":\"1136\"},{\"name\":\"Truro\",\"arrives\":\"1152\",\"departs\":\"1153\"},{\"name\":\"Redruth\",\"arrives\":\"1206\",\"departs\":\"1207\"},{\"name\":\"Camborne\",\"arrives\":\"1212\",\"departs\":\"1213\"},{\"name\":\"Hayle\",\"arrives\":\"1220\",\"departs\":\"1220\"},{\"name\":\"St Erth\",\"arrives\":\"1224\",\"departs\":\"1225\"},{\"name\":\"Penzance\",\"arrives\":\"1234\"}]},{\"platform\":\"2\",\"departs\":\"1004\",\"stops\":[{\"name\":\"Totnes\",\"arrives\":\"1015\",\"departs\":\"1016\"},{\"name\":\"Plymouth\",\"arrives\":\"1042\"}]},{\"platform\":\"2\",\"departs\":\"1032\",\"stops\":[{\"name\":\"Totnes\",\"arrives\":\"1043\",\"departs\":\"1044\"},{\"name\":\"Plymouth\",\"arrives\":\"1110\",\"departs\":\"1119\"},{\"name\":\"Liskeard\",\"arrives\":\"1142\",\"departs\":\"1144\"},{\"name\":\"Bodmin Parkway\",\"arrives\":\"1155\",\"departs\":\"1157\"},{\"name\":\"Par\",\"arrives\":\"1206\",\"departs\":\"1208\"},{\"name\":\"St Austell\",\"arrives\":\"1214\",\"departs\":\"1215\"},{\"name\":\"Truro\",\"arrives\":\"1231\",\"departs\":\"1233\"},{\"name\":\"Redruth\",\"arrives\":\"1244\",\"departs\":\"1246\"},{\"name\":\"Camborne\",\"arrives\":\"1251\",\"departs\":\"1253\"},{\"name\":\"St Erth\",\"arrives\":\"1302\",\"departs\":\"1303\"},{\"name\":\"Penzance\",\"arrives\":\"1313\"}]},{\"platform\":\"2\",\"departs\":\"1105\",\"stops\":[{\"name\":\"Totnes\",\"arrives\":\"1200\",\"departs\":\"1201\"},{\"name\":\"Plymouth\",\"arrives\":\"1226\"}]},{\"platform\":\"2\",\"departs\":\"1140\",\"stops\":[{\"name\":\"Totnes\",\"arrives\":\"1152\",\"departs\":\"1153\"},{\"name\":\"Plymouth\",\"arrives\":\"1220\"}]}]";
        jsonExpectedB
                = "[{\"platform\":\"2\",\"departs\":\"0953\",\"stops\":[{\"name\":\"Torquay\",\"arrives\":\"1003\",\"departs\":\"1005\"},{\"name\":\"Paignton\",\"arrives\":\"1011\"}]},{\"platform\":\"1\",\"departs\":\"1007\",\"expected\":\"1015\",\"stops\":[{\"name\":\"Torre\",\"arrives\":\"1015\",\"departs\":\"1015\"},{\"name\":\"Torquay\",\"arrives\":\"1018\",\"departs\":\"1018\"},{\"name\":\"Paignton\",\"arrives\":\"1025\"}]},{\"platform\":\"1\",\"departs\":\"1041\",\"stops\":[{\"name\":\"Torre\",\"arrives\":\"1049\",\"departs\":\"1049\"},{\"name\":\"Torquay\",\"arrives\":\"1052\",\"departs\":\"1052\"},{\"name\":\"Paignton\",\"arrives\":\"1059\"}]},{\"platform\":\"1\",\"departs\":\"1101\",\"stops\":[{\"name\":\"Torre\",\"arrives\":\"1109\",\"departs\":\"1110\"},{\"name\":\"Torquay\",\"arrives\":\"1112\",\"departs\":\"1113\"},{\"name\":\"Paignton\",\"arrives\":\"1120\"}]},{\"platform\":\"2\",\"departs\":\"1132\",\"stops\":[{\"name\":\"Torre\",\"arrives\":\"1140\",\"departs\":\"1140\"},{\"name\":\"Torquay\",\"arrives\":\"1143\",\"departs\":\"1143\"},{\"name\":\"Paignton\",\"arrives\":\"1150\"}]}]";

        gson = new Gson();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void integrationTestGetTrainsByPlatformA() throws Exception {
        trainsListActual = getTrainsByStation.getTrainsByStation("Plymouth", listener.getTrainData(apiUrl));

        jsonActual = gson.toJson(trainsListActual);

        assertEquals("Failed to return trains by platform properly", jsonExpectedA, jsonActual);
    }

    @Test
    public void integrationTestGetTrainsByPlatformB() throws Exception {
        trainsListActual = getTrainsByStation.getTrainsByStation("Paignton", listener.getTrainData(apiUrl));

        jsonActual = gson.toJson(trainsListActual);

        assertEquals("Failed to return trains by platform properly", jsonExpectedB, jsonActual);
    }
    
        @Test
    public void platformNotFound() throws Exception {
        trainsListActual = getTrainsByStation.getTrainsByStation("invalid", listener.getTrainData(apiUrl));


        assertEquals("Failed to return null", null, trainsListActual);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
