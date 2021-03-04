/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donatemanager;

import categorizemanager.CategorizeManager;
import java.util.*;
import java.io.*;

/**
 *
 * @author ircashem
 */
public class DonationManager {
    private String fileName = "./donateDb.txt";
    private List<Donate> donateList;

    public DonationManager(){
        this.donateList = new ArrayList<Donate>();
//        init(this.fileName);
    }

    public List<Donate> getDonates() {
//        List<Donate> result = null;
//        result = Collections.unmodifiableList(this.donateList);
        return this.donateList;
    }

    public boolean init(String fileName) {
        
        boolean result = false;
        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader(fileName));
            bufReader.readLine();
            String oneLine = bufReader.readLine();
            Donate myDonate = null;
            while(oneLine != null){
                StringTokenizer st = new StringTokenizer(oneLine, "|");
                myDonate = new Donate();
                myDonate.setName(st.nextToken());
                myDonate.setAddress(st.nextToken());
                myDonate.setCategory(st.nextToken());
                myDonate.setTopWear(Integer.parseInt(st.nextToken()));
                myDonate.setBottomWear(Integer.parseInt(st.nextToken()));
                myDonate.setWinterWear(Integer.parseInt(st.nextToken()));
                myDonate.setFootWear(Integer.parseInt(st.nextToken()));
                this.donateList.add(myDonate);
                oneLine = bufReader.readLine();
            }
            bufReader.close();
            result = true;
            
        } catch (FileNotFoundException e) {
                //do something clever with the exception
                System.out.println("File Not Found");
        } catch (IOException e) {
                //do something clever with the exception
                System.out.println("IO Exception");              
        }
        return result;
    }
    
    public boolean write(String fileName){
        boolean flag = false;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("name|address|Category|top_wear|bottom_wear|winter_wear|foot_wear\n");
            for(int i=0;i<this.donateList.size();i++){
                // bw.write(this.donateList.get(i).toString());
                bw.write(this.donateList.get(i).toString());
            }
            flag = true;
            bw.close();
        } catch (IOException e) {
            System.out.println("Error Occurred." + e);
        }
        return flag;
    }

    public boolean addDonate(Donate dn){
        boolean flag = false;
        try{
            this.donateList.add(dn);
            write(this.fileName);
        }
        finally{
            flag = true;
        }
        return flag;
    }    
    
    public String displayDonate(Donate dn){
        this.donateList.clear();
        this.init(fileName);
        for (int i=0;i<this.donateList.size();i++){
            
            if (this.donateList.get(i).getName().equals(dn.getName())){
                return this.donateList.get(i).displayString();
            }
        }
        return "You havn't donated yet.";
    }
    
    public Donate getDonor(Donate dn){
//        this.donateList.clear();
//        this.init(fileName);
        for (int i=0;i<this.donateList.size();i++){
            if (this.donateList.get(i).getName().equals(dn.getName())){
                System.out.println("Here");
                return this.donateList.get(i);
            }
        }
        return dn;
    }

    public boolean updateDonate(Donate dn){
        this.donateList.clear();
        this.init(fileName);
        boolean flag = false;
        for (int i=0;i<this.donateList.size();i++){
            
            if (this.donateList.get(i).getName().equals(dn.getName())){

                this.donateList.get(i).setAddress(dn.getAddress());
                this.donateList.get(i).setCategory(dn.getCategory());
                this.donateList.get(i).setTopWear(dn.getTopWear());
                this.donateList.get(i).setBottomWear(dn.getBottomWear());
                this.donateList.get(i).setWinterWear(dn.getWinterWear());
                this.donateList.get(i).setFootWear(dn.getFootWear());
                write(this.fileName);
                flag = true;
                break;
            }
        }

        return flag;
    }

    public boolean deleteDonate(Donate dn, CategorizeManager cMgr){
        this.donateList.clear();
        this.init(fileName);
        boolean flag = false;
        for (int i=0;i<this.donateList.size();i++){
            if (this.donateList.get(i).getName().equals(dn.getName())){
                cMgr.updateStockAfterDeletingDonate(this.donateList.get(i));
                this.donateList.remove(i);
                write(this.fileName);
                flag = true;
                break;
            }
        }
        return flag;
    }


//    public static void main(String[] args) throws IOException {
//
//        // Instantiation of Donate Manager
//        DonateManager DM = new DonateManager();
//
//        // Initialization of Donate Manager ,i.e load data to the arrayList
//        // DM.init(DM.fileName);
//
//        // Unit Testing
//        // assert(DM.getDonates().size()==2);
//        // assert(DM.donateList.get(0).getName().equals("Rahul"));
//        
//        // Write to the file from ArrayList 
//        // DM.write(DM.fileName);
//
//        // Add Donate of a user
//        //  dn = new Donate();
//        // dn.setName("User10");
//        // dn.setAddress("Manali");
//        // dn.setCategory("M");
//        // dn.setTopWear(2);
//        // dn.setBottomWear(2);
//        // dn.setWinterWear(2);
//        // dn.setBottomWear(2);
//        // DM.addDonate(dn);
//
//        // Display Donate of a user
//        // Donate dn = new Donate();
//        // dn.setName("User9");
//        // System.out.println(DM.displayDonate(dn));
//
//        // Update Donate of a user
//        // Donate dn = new Donate();
//        // dn.setName("User2");
//        // dn.setAddress("Himachal");
//        // dn.setCategory("M");
//        // dn.setTopWear(3);
//        // dn.setBottomWear(2);
//        // dn.setWinterWear(8);
//        // dn.setFootWear(0);
//        // DM.updateDonate(dn);
//
//        // Delete Donate of a user
//        // Donate dn = new Donate();
//        // dn.setName("User1");
//        // DM.deleteDonate(dn);
//
//    }

    
}
