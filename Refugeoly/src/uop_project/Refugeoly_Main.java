
//Georgios Lampris AM:2022202200105
//Leonidas Kalafatas AM:2022202200063

package uop_project;

import java.util.Scanner;

public class Refugeoly_Main {


    public static void main(String[] args) {
        
        int players;
        int opt;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Refugeoly!!\nSelect the num. of action:\n1.Play\n2.Reload previous game\n3.Exit");
        opt = scanner.nextInt();
        
        //Getting in the game
        if(opt==1){
            do{
                System.out.println("How many players are going to play?");
                players = scanner.nextInt();
            }while((players<1)||(players>4));

            Game game = new Game(players);
            game.Play(players);
            
        }else if(opt==2){     //Loading a potential previous save
            System.out.println("Give me the name of your previous save: ");
            scanner.nextLine(); // Consume the newline character
            String loadFileName = scanner.nextLine();
            Game game = new Game(0);
            game.loadGame("src/uop_project/game_saves", loadFileName);
            System.out.println("How many players were playing on the \""+ loadFileName+"\" game save?");
            players = scanner.nextInt();
            game.Play(players);
        }else if(opt==3){    //Just ending the code
            System.out.println("Exiting...");
            System.out.println("Thank you for playing Refugeoly, a game created by Leonidas Kalafatas and Georgios Lampris!");
            System.exit(0);
        }else {
            System.out.println("Please select a valid option.");
        }
        scanner.close();
        
    }
    
}
