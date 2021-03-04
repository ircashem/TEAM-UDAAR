/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donatemanager;

/**
 *
 * @author ircashem
 */
public class Donate {
    private String name = "";
    private String address = "";
    private String category;
    private int top_wear = 0;
    private int bottom_wear = 0;
    private int winter_wear = 0;
    private int foot_wear = 0;

    ////////////////////////////////////////////////////////////////////////////////////////////
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setAddress(String address){
        this.address = address;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setTopWear(int quantity){
        if (quantity >= 0){
            this.top_wear = quantity;
        }
    }
    public void setBottomWear(int quantity){
        if (quantity >= 0){
            this.bottom_wear = quantity;
        }
    }
    public void setWinterWear(int quantity){
        if (quantity >= 0){
            this.winter_wear = quantity;
        }
    }
    public void setFootWear(int quantity){
        if (quantity >= 0){
            this.foot_wear = quantity;
        }
    }

    public String getAddress(){
        return address;
    }

    public String getCategory(){
        return this.category;
    }

    public int getTopWear(){
        return this.top_wear;
    }
    public int getBottomWear(){
        return this.bottom_wear;
    }
    public int getWinterWear(){
        return this.winter_wear;
    }
    public int getFootWear(){
        return this.foot_wear;
    }

    public String displayString(){
        return "\nName: \t\t\t"+ name +"\nAddress: \t\t" + address + "\nCategory: \t\t" 
                + category + "\nTop Wear: \t\t" + top_wear + "\nBottom Wear: \t\t" + bottom_wear 
                + "\nWinter Wear: \t\t" + winter_wear+ "\nFoot Wear: \t\t" + foot_wear;
    }

    public String toString(){
        return name + "|" + address + "|" + category + "|" + top_wear + "|" + bottom_wear 
        + "|" + winter_wear + "|" +  foot_wear + "\n";
    }

}
