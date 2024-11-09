/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class StayAction implements Action, Serializable{
    
    @Override
    public void act(Refugee ref){
        if(ref.getCan_play()){
            ref.setCan_play(false);
        } else{
            if(ref.getCurrentSquare() == 26){
                if(ref.getCounter_box26()==2){
                    ref.setCounter_box26(1);
                }else{
                    ref.setCounter_box26(2);
                    ref.setCan_play(true);
                }                    
            }else{
                ref.setCan_play(true);
            }
        }
    }
}
