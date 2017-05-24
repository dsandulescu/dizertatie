/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scalability;
import ambari.interaction.ComponentInformation;
import ambari.interaction.NodeController;
import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Scalability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //Curl.run();
        ArrayList<ComponentInformation> listOfComp =  NodeController.getListOfNodes();
    }
    
}
