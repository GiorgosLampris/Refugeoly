/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class PayMoneyAction implements Action, Serializable{
    
    final ReceiverEntity name;
    int amount;
    

    public PayMoneyAction(ReceiverEntity name, int amount){
        this.name = name;
        this.amount = amount;
    }
    
    
    
    @Override
    public void act(Refugee ref){
        int num = ref.getCurrentSquare();
        if ((num == 1)||(num == 21)){
            ref.giveMoney(amount);           
        }else{
            ref.giveMoney(amount);
            name.receiveMoney(amount);
        }       
    }
}
