/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class ReceiverEntity implements MoneyReceiver, Serializable{
    
    private String name;
    private double money;
    
    public ReceiverEntity(String name, double money) {
        this.name = name;
        this.money = money;
    }
    
    public void setName(String n)
    {
        name=n;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setMoney(double m)
    {
        money=m;
    }
    
    public double getMoney()
    {
        return money;
    }
    
    //ReceiveMoney
    @Override
    public double receiveMoney(double amount){
        money += amount;
        System.out.println(name + " just got " + amount + " $. New "+name+" balance: " + money+"$");
        return money;
    }
    
}
