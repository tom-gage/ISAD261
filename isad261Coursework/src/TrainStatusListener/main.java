/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrainStatusListener;

/**
 *
 * @author Tom
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        IncomingTrainsStatusListener myListener = new IncomingTrainsStatusListener();
        StatusGenerator myGenerator = new StatusGenerator(myListener);
        
        System.out.println("PROGRAM START");
        myGenerator.getStatusData();
    }
    
}
