/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class GiverEntity implements MoneyGiver, Serializable{
    
    private String name;
    private double money=10000;
    
    public void setName(String nam){
        name=nam;
    }
   
    
    public String getName(){
        return name;
    }
    
    public void setMoney(double mon){
        money=mon;
    }
    
    public double getMoney(){
        return money;
    }
    
    //GiveMoney
    @Override
    public double giveMoney(double amount){
        if(money >= amount){
            money -= amount;
            System.out.println(name + " gave " + amount + "$ to ");
            return money;
        } else {
            System.out.println(name + " does not have this amount!");
            //to do No Money exeption.
            return -1;
        }
        
    }
}
