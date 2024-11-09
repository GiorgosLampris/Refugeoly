/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class ReceiveMoneyAction implements Action, Serializable{
    
    final GiverEntity name ;
    
    public ReceiveMoneyAction(GiverEntity name){
        this.name = name;
    }
    
    @Override
    public void act(Refugee ref){
        if(name.getMoney()>1000){
            ref.receiveMoney(1000);
            name.giveMoney(1000);
        }else{
            System.out.println("Unfortunately NGO bank has run out of money!");
        }
    }
}
