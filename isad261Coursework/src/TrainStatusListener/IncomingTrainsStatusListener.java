/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author btgage
 */
public class IncomingTrainsStatusListener {
    
    public Response getJSON(String url) throws Exception{
        URL apiURL = new URL(url);
        HttpURLConnection myConnection = (HttpURLConnection) apiURL.openConnection();
        myConnection.setRequestMethod("GET");
        int code = myConnection.getResponseCode();
        
        if(code != 200){
            return new Response(code, null);
            
        }else{
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
                String data = reader.readLine();

                reader.close();
                return new Response(code, data);
            }
            catch(Exception e){
                System.out.println("An error occured");
                return new Response(code, null);
            }

        }
    }
}
