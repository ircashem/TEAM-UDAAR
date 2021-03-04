/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickupmanager;

import postneedmanager.Need;

/**
 *
 * @author ircashem
 */public class Consignment {
    private Need nd = null ;
    
    public void setConsignment(Need nd){
        this.nd = nd;
    }
    
    public Need getConsignment(){
        return this.nd;
    }
    
    public String toString(){
        return this.nd.getName() + "|" + this.nd.getAddress() + "|" + this.nd.getCategory() + "|" + this.nd.getTopWear() + "|" + this.nd.getBottomWear()
        + "|" + this.nd.getWinterWear() + "|" +  this.nd.getFootWear() + "\n";
    }
}
