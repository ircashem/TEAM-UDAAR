/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categorizemanager;

import donatemanager.Donate;
import donatemanager.DonationManager;
import postneedmanager.Need;
import postneedmanager.NeedManager;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

/**
 *
 * @author ircashem
 */
public class CategorizeManager {
    
    private LinkedHashMap<String, Integer> hashmap = new LinkedHashMap<>();


    public boolean updateStockAfterAddingDonate(List<Donate> donateList){
        boolean res = false;
        Integer i = donateList.size() - 1;
        if (i >= 0){
        String key = donateList.get(i).getCategory() + "_top_wear";
        this.hashmap.put(key, this.hashmap.getOrDefault(key,0) + donateList.get(i).getTopWear());
        key = donateList.get(i).getCategory() + "_bottom_wear";
        this.hashmap.put(key, this.hashmap.getOrDefault(key,0) + donateList.get(i).getBottomWear());
        key = donateList.get(i).getCategory() + "_winter_wear";
        this.hashmap.put(key, this.hashmap.getOrDefault(key,0) + donateList.get(i).getWinterWear());
        key = donateList.get(i).getCategory() + "_foot_wear";
        this.hashmap.put(key, this.hashmap.getOrDefault(key,0) + donateList.get(i).getFootWear());
        }
        this.write();
        res = true;
        // System.out.println(this.hashmap);
        return res;
    }
    
    public boolean updateStockAfterDeletingDonate(Donate d){
        boolean res = false;
        String key = d.getCategory() + "_top_wear";
        
        this.hashmap.put(key, this.hashmap.get(key) - d.getTopWear());
        key = d.getCategory() + "_bottom_wear";
        this.hashmap.put(key, this.hashmap.get(key) - d.getBottomWear());
        key = d.getCategory() + "_winter_wear";
        this.hashmap.put(key, this.hashmap.get(key) - d.getWinterWear());
        key = d.getCategory() + "_foot_wear";
        this.hashmap.put(key, this.hashmap.get(key) - d.getFootWear());
        this.write();
        res = true;
          
        return res;
    }
    
    public boolean updateStockAfterUpdatingDonate(Donate d){
        boolean res = false;
        return res;
    }
    

    public String matchStock(List<Need> needList){
        String name = "";
        String top_key,bottom_key,winter_key,foot_key;
        Integer top_quantity,bottom_quantity,winter_quantity,foot_quantity;
        for (int i = 0;i < needList.size();i++){
            
            top_key = needList.get(i).getCategory() + "_top_wear";
            top_quantity = needList.get(i).getTopWear();
            
            bottom_key = needList.get(i).getCategory() + "_bottom_wear";
            bottom_quantity = needList.get(i).getBottomWear();
            
            winter_key = needList.get(i).getCategory() + "_winter_wear";
            winter_quantity = needList.get(i).getWinterWear();
            
            foot_key = needList.get(i).getCategory() + "_foot_wear";
            foot_quantity = needList.get(i).getFootWear();
            
            if(( this.hashmap.get(top_key) >= top_quantity ) && (this.hashmap.get(bottom_key) >= bottom_quantity) && (this.hashmap.get(winter_key) >= winter_quantity) && this.hashmap.get(foot_key) >= foot_quantity)
            {
                name =  needList.get(i).getName();
                // Updating hashmap to reduce the quantity of stock available by the amount of need that can be fullfilled.
                this.hashmap.put(top_key, this.hashmap.get(top_key) - top_quantity);
                this.hashmap.put(bottom_key, this.hashmap.get(bottom_key) - bottom_quantity);
                this.hashmap.put(winter_key,this.hashmap.get(winter_key) -  winter_quantity);
                this.hashmap.put(foot_key,this.hashmap.get(foot_key) -  foot_quantity);
                // System.out.println(this.hashmap);
                this.write();
                break;
            }
        }
        return name;
    }

    public LinkedHashMap<String, Integer> getStock(){
        return this.hashmap;
    }

    public void write(){
        BufferedWriter bw = null;
		try {
            bw = new BufferedWriter(new FileWriter("/home/ircashem/Desktop/stockDb.txt"));
            for (Entry<String, Integer> entry : this.hashmap.entrySet()) {
                // System.out.println(entry);
                bw.write(entry.toString() + "\n");    
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
}

    public boolean init(String fileName){
        boolean result = false;
        BufferedReader bufReader = null;
        StringTokenizer st = null;
        try {
            bufReader = new BufferedReader(new FileReader(fileName));
            String oneLine = bufReader.readLine();
            while (oneLine != null){
                st = new StringTokenizer(oneLine, "=");
                this.hashmap.put(st.nextToken(),Integer.parseInt(st.nextToken()));
                oneLine  = bufReader.readLine();
            }
            result = true;
            // System.out.println(this.hashmap);
        } catch (Exception e) {
            System.out.println("Exception occurred" + e);
        }
        
        return result;
    }



//    public static void main(String[] args) {
//    
//    }
//    
    
}
