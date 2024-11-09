/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class ExtraLifeAction implements Action , Serializable{
    
    @Override
    public void act(Refugee ref){
        ref.setLives(1); //In case of box 7
    }
}
