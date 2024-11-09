/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

import java.util.Random;
import java.util.Scanner;

public class Box26Action extends PayMoneyAction implements Action, Serializable{
    
    public Box26Action(ReceiverEntity name, int amount) {
        super(name, amount);
    }

    @Override
    public void act(Refugee ref){
        try (Scanner scanner = new Scanner(System.in)) {
            ref.giveMoney(amount);
            name.receiveMoney(amount);
            System.out.print("What option do you choose, A or B? --> ");
            char opt = scanner.nextLine().charAt(0);
            if(Character.toUpperCase(opt) == 'A'){
                System.out.println("You chose option A. You pay $1500 to Mafia Bank and roll the dice again");

                //pay, reroll and go to the box
                ref.giveMoney(1500);
                name.receiveMoney(1500);
                Random rand = new Random();
                int dice = rand.nextInt(6) +1;
                int num = ref.getCurrentSquare();
                System.out.println("You rolled: "+dice);
                ref.setCurrentSquare(dice+num);
                Square square = ref.getBoard().getSquare(ref.getCurrentSquare());
                scanner.nextLine();
                square.act(ref);
                if(square.getAct()>1){
                    System.out.println("\n("+square.getNumber()+")"+square.getText());
                }
                
            } else if(Character.toUpperCase(opt) == 'B'){
                System.out.println("You chose option B. You don't pay anything but you stay 2 turns");
                //TODO stay twice in main
            }
        }
    }
}
