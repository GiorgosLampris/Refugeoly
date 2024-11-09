/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class GoToAction implements Action, Serializable{
    
    private int dice;
    private int current;
    
    @Override
    public void act(Refugee ref){
        dice=ref.getDice();
        current=ref.getCurrentSquare();
        
        
        if((current+dice)>39){      //In case the player exceedes box num 39
            ref.setCurrentSquare(39-((dice+current)-39));
            System.out.println("You exceeded the last box (39), you will go back to box number: " +(39-((dice+current)-39)));
        }else{
            
            ref.setCurrentSquare(dice+current);

            switch (ref.getCurrentSquare()) { 
                case 5:
                    System.out.println("(5)Border 1. Go back to war box (0)");
                    ref.setCurrentSquare(0);
                    break;
                case 4:
                    System.out.println("(4)Army Control. Go back to war box (0)");
                    ref.setCurrentSquare(0);
                    break;
                case 15:
                    System.out.println("(15)Border 2. Go back to Border 1 (5)");
                    ref.setCurrentSquare(5);
                    break;
                case 18:
                    System.out.println("(18)Red Cross Shelter. Jump to river crossing box (22)");
                    ref.setCurrentSquare(22);
                    break;
                case 23:
                    System.out.println("(23)NGO lift. Jump to family reunion box (29)");
                    ref.setCurrentSquare(29);
                    break;
                case 25:
                    System.out.println("(25)Border 3. Go back to Border 2 (15)");
                    ref.setCurrentSquare(15);
                    break;
                case 29:
                    System.out.println("(29)Family Reunion. Jump to bus box (31)");
                    ref.setCurrentSquare(31);
                    break;
                case 30:
                    System.out.println("(30)Right Wing Militia. Back to Border police box (24)");
                    ref.setCurrentSquare(24);
                    break;
                case 33:
                    System.out.println("(33)Asylum Seeker Application rejected. Back to Train box (17) and you roll again");
                    ref.setCurrentSquare(17);
                    break;
                case 35:
                    System.out.println("(35)Border 2. Go back to Border 1 (25)");
                    ref.setCurrentSquare(25);
                    break;
                case 38:
                    System.out.println("(38)Deported. You are sent back to war box (0)");
                    ref.setCurrentSquare(0);
                    break;
                default:
                    Square square = ref.getBoard().getSquare(ref.getCurrentSquare());
                    square.act(ref);
                    break;
            }
        }
        
    }
}
