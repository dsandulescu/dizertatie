/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambari.interaction;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Vector;

/**
 *
 * @author student
 */
public class NodeController {
    
    public static ArrayList<ComponentInformation>  getListOfNodes() throws Exception
    {
        	String url = "http://127.0.0.1:8080/api/v1/clusters/mycluster/services/HDFS/components/DATANODE?fields=host_components/HostRoles/desired_admin_state,host_components/HostRoles/state";
                String responseJson = HttpURLConnectionExample.sendGet(url);
                System.out.print(responseJson);
                JsonParser jsonParser = new JsonParser();
                JsonElement jsonTree = jsonParser.parse(responseJson);
                ArrayList<ComponentInformation> listOfCompoents  = new ArrayList<ComponentInformation>() ;
                
                if(jsonTree.isJsonObject()){
                    JsonObject jsonObject = jsonTree.getAsJsonObject();                                  
                    JsonElement hostComponents = jsonObject.get("host_components");
                    
                    if(hostComponents.isJsonArray()){
                        JsonArray hostComponentsJsonArray = hostComponents.getAsJsonArray();
                        System.out.println("\nStart");
                        System.out.println(hostComponentsJsonArray);
                        
                        for(int i = 0 ; i < hostComponentsJsonArray.size(); i++)
                        {
                            JsonElement hostComponentsElem = hostComponentsJsonArray.get(i);                          
                                
                            if(hostComponentsElem.isJsonObject())
                            {                              
                                JsonObject jsonObjectElem = hostComponentsElem.getAsJsonObject();
                                JsonElement hostRolesElem = jsonObjectElem.get("HostRoles");
                                
                                if(hostRolesElem.isJsonObject())
                                {
                                    JsonObject hostRolesObjs = hostRolesElem.getAsJsonObject();
                                    JsonElement componentNameElem = hostRolesObjs.get("component_name");
                                    JsonElement hostNameElem = hostRolesObjs.get("host_name");
                                    JsonElement stateElem  = hostRolesObjs.get("state");
                                                              
                                    listOfCompoents.add(new ComponentInformation(
                                            componentNameElem.toString(), hostNameElem.toString(), stateElem.toString()));                                                                  
                                }                                                                                                
                            }
                        }
                    }    
                }
                
                return listOfCompoents;
    }
    
}
