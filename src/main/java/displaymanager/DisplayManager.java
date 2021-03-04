/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displaymanager;

import donatemanager.AddDonationUI;
import donatemanager.ManageDonationUI;
import donatemanager.UpdateDonationUI;
import donatemanager.DisplayDonationUI;
import donatemanager.RemoveDonationUI;
import donatemanager.DonationManager;
import postneedmanager.UpdateNeedUI;
import postneedmanager.DisplayNeedUI;
import postneedmanager.ManageNeedUI;
import postneedmanager.AddNeedUI;
import postneedmanager.NeedManager;
import postneedmanager.DeleteNeedUI;
import categorizemanager.CategorizeManager;
import categorizemanager.CategorizeManagerUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pickupmanager.PickupManager;

/**
 *
 * @author ircashem
 */
public class DisplayManager {
    
    private NeedManager needMgr;
    private DonationManager donationMgr;
    private CategorizeManager cMgr;
    private PickupManager pMgr;
    private UdaarUI udaarUI;
    
    // Need
    private ManageNeedUI manageNeedUI;
    private AddNeedUI addNeedUI;
    private DisplayNeedUI displayNeedUI;
    private DeleteNeedUI deleteNeedUI;
    private UpdateNeedUI updateNeedUI;
    
    // Donate
    private ManageDonationUI manageDonationUI;
    private AddDonationUI addDonationUI;
    private DisplayDonationUI displayDonationUI;
    private RemoveDonationUI deleteDonationUI;
    private UpdateDonationUI updateDonationUI;
    
    private CategorizeManagerUI categorizeManagerUI;
    
    public boolean init(){
        boolean res = false;
        needMgr = new NeedManager();
        donationMgr = new DonationManager();
        cMgr = new CategorizeManager();
        pMgr = new PickupManager();
        res = needMgr.init("./needDb.txt");
        res = donationMgr.init("./donateDb.txt");
        res = cMgr.init("./stockDb.txt");
        res = pMgr.init("./consignDb.txt");
        return res;
    }
    
    public void createScreens(){
        
        this.udaarUI = new UdaarUI(this);
        this.manageNeedUI = new ManageNeedUI(this);
        this.addNeedUI = new AddNeedUI(this, this.needMgr);
        this.displayNeedUI = new DisplayNeedUI(this, this.needMgr);
        this.deleteNeedUI = new DeleteNeedUI(this, this.needMgr);
        this.updateNeedUI = new UpdateNeedUI(this, this.needMgr);
        
        this.manageDonationUI = new ManageDonationUI(this);
        this.addDonationUI = new AddDonationUI(this, this.donationMgr, this.cMgr);
        this.displayDonationUI = new DisplayDonationUI(this, this.donationMgr);
        this.deleteDonationUI = new RemoveDonationUI(this, this.donationMgr, this.cMgr);
        this.updateDonationUI = new UpdateDonationUI(this, this.donationMgr, this.cMgr);
        
        this.categorizeManagerUI = new CategorizeManagerUI(this,this.needMgr,this.cMgr, this.pMgr);
    }
    
    public void showUdaarUI(){
        this.udaarUI.setLocationRelativeTo(null);
        this.manageDonationUI.setVisible(false);
        this.manageNeedUI.setVisible(false);
        this.categorizeManagerUI.setVisible(false);
        
        this.udaarUI.setVisible(true);
    }
    
    public void showManageNeedUI(){
        this.udaarUI.setVisible(false);
        this.addNeedUI.setVisible(false);
        this.displayNeedUI.setVisible(false);
        this.updateNeedUI.setVisible(false);
        this.deleteNeedUI.setVisible(false);
        this.manageNeedUI.setLocationRelativeTo(null);
        this.manageNeedUI.setVisible(true);
    }
    
    public void showManageDonationUI(){
        this.udaarUI.setVisible(false);
        this.addDonationUI.setVisible(false);
        this.displayDonationUI.setVisible(false);
        this.updateDonationUI.setVisible(false);
        this.deleteDonationUI.setVisible(false);
        this.manageDonationUI.setLocationRelativeTo(null);
        this.manageDonationUI.setVisible(true);
    }
    
    public void showCategorizeManagerUI(){
        this.udaarUI.setVisible(false);
        this.manageDonationUI.setVisible(false);
        this.manageNeedUI.setVisible(false);
        this.categorizeManagerUI.setLocationRelativeTo(null);
        this.categorizeManagerUI.setVisible(true);
    }
    
    public void showAddNeedUI(){
        
        this.manageNeedUI.setVisible(false);
        this.addNeedUI.setLocationRelativeTo(null);
        this.addNeedUI.setVisible(true);
    }
    
    public void showAddDonationUI(){
        this.manageDonationUI.setVisible(false);
        this.addDonationUI.setLocationRelativeTo(null);
        this.addDonationUI.setVisible(true);
    }
    
    public void showDisplayNeedUI(){
        this.manageNeedUI.setVisible(false);
        this.displayNeedUI.setLocationRelativeTo(null);
        this.displayNeedUI.setVisible(true);
    }
    
    public void showDisplayDonationUI(){
        this.manageDonationUI.setVisible(false);
        this.displayDonationUI.setLocationRelativeTo(null);
        this.displayDonationUI.setVisible(true);
    }
    
    public void showUpdateNeedUI(){
        this.manageNeedUI.setVisible(false);
        this.updateNeedUI.setLocationRelativeTo(null);
        this.updateNeedUI.setVisible(true);
    }
    
    public void showUpdateDonationUI(){
        this.manageDonationUI.setVisible(false);
        this.updateDonationUI.setLocationRelativeTo(null);
        this.updateDonationUI.setVisible(true);
    }
    
    public void showDeleteNeedUI(){
        this.manageNeedUI.setVisible(false);
        this.deleteNeedUI.setLocationRelativeTo(null);
        this.deleteNeedUI.setVisible(true);
    }
    
    public void showDeleteDonationUI(){
        this.manageDonationUI.setVisible(false);
        this.deleteDonationUI.setLocationRelativeTo(null);
        this.deleteDonationUI.setVisible(true);
    }
    
    
    
    public void run(){
        this.createScreens();
        this.showUdaarUI();
    }
    
    public static void main(String[] args){
        DisplayManager mgr = new DisplayManager();
        if (mgr.init()){
            mgr.run();
        }
        else{
            System.out.println("Error Occured");
        }

        
    }

    
    
}
