/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;

import java.util.Random;
import java.io.Serializable;

public class RollDiceAction implements Action ,Serializable{
       
    // Generate random integers in range 1 to 6 to simulate a dice
    Random rand = new Random();
  
    @Override
    public void act(Refugee ref){
        int dice = rand.nextInt(6) +1;
        System.out.println("\nYou rolled: "+dice);//Rolling the dice
                
        if((ref.getCurrentSquare()+dice)>39){       //In case a player exceeds box 39
            ref.setCurrentSquare(39-((dice+ref.getCurrentSquare())-39));
            System.out.println("You exceeded the last box (39), you will go back to box number: " +(39-((dice+ref.getCurrentSquare())-39)));
        }else{           
            if(ref.getCurrentSquare()==22){     //To go backwards in case of box 22
                ref.setCurrentSquare(ref.getCurrentSquare()-dice);
            }else{
                ref.setCurrentSquare(dice+ref.getCurrentSquare());
            }
            System.out.println("\n("+ref.getBoard().getSquare(ref.getCurrentSquare()).getNumber()+")"+ref.getBoard().getSquare(ref.getCurrentSquare()).getText());
            switch (ref.getCurrentSquare()) { 
                case 5:
                    ref.setCurrentSquare(0);
                    break;
                case 4:
                    ref.setCurrentSquare(0);
                    break;
                case 15:
                    ref.setCurrentSquare(5);
                    break;
                case 18:
                    ref.setCurrentSquare(22);
                    break;
                case 23:
                    ref.setCurrentSquare(29);
                    break;
                case 25:
                    ref.setCurrentSquare(15);
                    break;
                case 29:
                    ref.setCurrentSquare(31);
                    break;
                case 30:
                    ref.setCurrentSquare(24);
                    break;
                case 33:
                    ref.setCurrentSquare(17);
                    break;
                case 35:
                    ref.setCurrentSquare(25);
                    break;
                case 38:
                    ref.setCurrentSquare(0);
                    break;
                case 2:
                case 9:
                case 12:
                case 16:
                case 17:
                case 22:
                case 28:
                case 31:
                    Square square = ref.getBoard().getSquare(ref.getCurrentSquare());
                    System.out.println("\n("+ref.getBoard().getSquare(ref.getCurrentSquare()).getNumber()+")"+ref.getBoard().getSquare(ref.getCurrentSquare()).getText());
                    square.act(ref);
                    break;
                default:
                    square = ref.getBoard().getSquare(ref.getCurrentSquare());
                    square.act(ref);
                    break;
            }
       
        }
    }   
}
