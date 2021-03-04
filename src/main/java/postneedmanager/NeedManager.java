/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postneedmanager;

import java.io.*;
import java.util.*;

/**
 *
 * @author ircashem
 */
public class NeedManager {
    private String fileName = "./needDb.txt";
    private List<Need> needList;

    public NeedManager(){
        this.needList = new ArrayList<Need>();
    }

    public List<Need> getNeeds() {
//        List<Need> result = null;
//        result = Collections.unmodifiableList(this.needList);
        return this.needList;
    }

    public boolean init(String fileName) {
        boolean result = false;
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
                this.needList.add(myNeed);
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
            for(int i=0;i<this.needList.size();i++){
                // bw.write(this.needList.get(i).toString());
                bw.write(this.needList.get(i).toString());
            }
            flag = true;
            bw.close();
        } catch (IOException e) {
            System.out.println("Error Occurred." + e);
        }
        return flag;
    }

    public boolean addNeed(Need nd){
        this.needList.clear();
        this.init(fileName);
        boolean flag = false;
        try{
            this.needList.add(nd);
            write(this.fileName);
        }
        finally{
            flag = true;
        }
        return flag;
    }    
    
    public String displayNeed(Need nd){
        this.needList.clear();
        this.init(fileName);
        for (int i=0;i<this.needList.size();i++){
            if (this.needList.get(i).getName().equals(nd.getName())){
                return this.needList.get(i).displayString();
            }
        }
        return "You havn't posted any need yet.";
    }
    
    public Need getNeedObject(String name){
        this.needList.clear();
        this.init(fileName);
        for (int i=0;i<this.needList.size();i++){
            if (this.needList.get(i).getName().equals(name)){
                return this.needList.get(i);
            }
        }
        return null;
    
    }

    public boolean updateNeed(Need nd){
        this.needList.clear();
        this.init(fileName);
        boolean flag = false;
        for (int i=0;i<this.needList.size();i++){
            
            if (this.needList.get(i).getName().equals(nd.getName())){

                this.needList.get(i).setAddress(nd.getAddress());
                this.needList.get(i).setCategory(nd.getCategory());
                this.needList.get(i).setTopWear(nd.getTopWear());
                this.needList.get(i).setBottomWear(nd.getBottomWear());
                this.needList.get(i).setWinterWear(nd.getWinterWear());
                this.needList.get(i).setFootWear(nd.getFootWear());
                write(this.fileName);
                flag = true;
                break;
            }
        }

        return flag;
    }

    public boolean deleteNeed(Need nd){
        this.needList.clear();
        this.init(fileName);
        boolean flag = false;
        for (int i=0;i<this.needList.size();i++){
            if (this.needList.get(i).getName().equals(nd.getName())){
                this.needList.remove(i);
                write(this.fileName);
                flag = true;
                break;
            }
        }
        return flag;
    }


//    public static void main(String[] args){

        // Instantiation of Need Manager
//        NeedManager NM = new NeedManager();

        // Initialization of Need Manager ,i.e load data to the arrayList
//        NM.init(NM.fileName);

        // Unit Testing
//         assert(NM.getNeeds().size()==4);
//         assert(NM.needList.get(0).getName().equals("Rahul"));
        
        // Write to the file from ArrayList 
        // NM.write(NM.fileName);

        // Add need of a user
        // Need nd = new Need();
        // nd.setName("User10");
        // nd.setAddress("Manali");
        // nd.setCategory("M");
        // nd.setTopWear(2);
        // nd.setBottomWear(2);
        // nd.setWinterWear(2);
        // nd.setBottomWear(2);
        // NM.addNeed(nd);

        // Display need of a user
        // Need nd = new Need();
        // nd.setName("User9");
        // System.out.println(NM.displayNeed(nd));

        // Update need of a user
        // Need nd = new Need();
        // nd.setName("User2");
        // nd.setAddress("Himachal");
        // nd.setCategory("M");
        // nd.setTopWear(3);
        // nd.setBottomWear(2);
        // nd.setWinterWear(8);
        // nd.setFootWear(0);
        // NM.updateNeed(nd);

        // Delete need of a user
        // Need nd = new Need();
        // nd.setName("User1");
        // NM.deleteNeed(nd);

//    }
}
