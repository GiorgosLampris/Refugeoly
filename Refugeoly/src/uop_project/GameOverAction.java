/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class GameOverAction implements Action, Serializable{
    //In case of box 10
    @Override
    public void act(Refugee ref){
       if(ref.getLives()==0){
           ref.setGame_over(true);
       } else{  //In case the player has extra lives because of box 7
           System.out.println("You were saved due to a life vest!!");
           ref.setLives(-1);
       }
       
    }
}
