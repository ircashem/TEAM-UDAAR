/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickupmanager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import postneedmanager.Need;
/**
 *
 * @author ircashem
 */
public class PickupManager {
    
    private String fileName = "./consignDb.txt";
    private List<Consignment> consignList;
    
    public PickupManager(){
        this.consignList = new ArrayList<Consignment>();
    }
    
    public boolean init(String fileName){
        boolean res = false;
        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader(fileName));
            bufReader.readLine();
            String oneLine = bufReader.readLine();
            Need myNeed = null;
            while(oneLine != null){
                StringTokenizer st = new StringTokenizer(oneLine, "|");
                myNeed = new Need();
                myNeed.setName(st.nextToken());
                myNeed.setAddress(st.nextToken());
                myNeed.setCategory(st.nextToken());
                myNeed.setTopWear(Integer.parseInt(st.nextToken()));
                myNeed.setBottomWear(Integer.parseInt(st.nextToken()));
                myNeed.setWinterWear(Integer.parseInt(st.nextToken()));
                myNeed.setFootWear(Integer.parseInt(st.nextToken()));
                Consignment myConsign = new Consignment();
                myConsign.setConsignment(myNeed);
                this.consignList.add(myConsign);
                oneLine = bufReader.readLine();
            }
            bufReader.close();
            res = true;
            
        } catch (FileNotFoundException e) {
                //do something clever with the exception
                System.out.println("File Not Found");
        } catch (IOException e) {
                //do something clever with the exception
                System.out.println("IO Exception");              
        }
       
    return res;
    }
    
    public boolean write(String fileName){
        boolean flag = false;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("name|address|Category|top_wear|bottom_wear|winter_wear|foot_wear\n");
            for(int i=0;i<this.consignList.size();i++){
                // bw.write(this.needList.get(i).toString());
                bw.write(this.consignList.get(i).toString());
            }
            flag = true;
            bw.close();
        } catch (IOException e) {
            System.out.println("Error Occurred." + e);
        }
        return flag;
    }
    
    
    public boolean addConsignment(Consignment nd){
        this.consignList.clear();
        this.init(fileName);
        boolean flag = false;
        try{
            this.consignList.add(nd);
            write(this.fileName);
        }
        finally{
            flag = true;
        }
        return flag;
    }
    
    public boolean deleteConsignment(Need nd){
        this.consignList.clear();
        this.init(fileName);
        boolean flag = false;
        for (int i=0;i<this.consignList.size();i++){
            if (this.consignList.get(i).getConsignment().getName().equals(nd.getName())){
                this.consignList.remove(i);
                write(this.fileName);
                flag = true;
                break;
            }
        }
        return flag;
    }
    
//     public static void main(String[] args){
//         Consignment c = new Consignment();
//         PickupManager pMgr = new PickupManager();
//         pMgr.init("/home/ircashem/Desktop/consignDb.txt");
//
//     }
}
