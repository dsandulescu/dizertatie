/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambari.interaction;

/**
 *
 * @author student
 */
public class ComponentInformation {
    private String component_name, host_name, state;
    ComponentInformation(String component_name, String host_name, String state)
    {
        this.component_name = component_name;
        this.host_name = host_name;
        this.state = state;
    }
    
}
