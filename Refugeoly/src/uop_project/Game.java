/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class Game {
    
    public Refugee[] ref;
    Board board = new Board(); //Game board
    public int[] lives;
    GiverEntity NGOBank = new GiverEntity();//NGO
    ReceiverEntity MafiaBank = new ReceiverEntity("MafiaBank",0);  //MafiaBank
    
        
    public Game(int players){
        
        try {
            // Create a Scanner to read the file
            Scanner scanner = new Scanner(new File("src/uop_project/refugeoly-squares-win.txt"));

            while (scanner.hasNextLine()) {
                String numberStr = scanner.nextLine().trim();
                
                // Check if the line is not empty
                if (!numberStr.isEmpty()) {
                    int number = Integer.parseInt(numberStr);

                    String text = scanner.nextLine().trim();

                    String description = "";
                    if (scanner.hasNextLine()) {
                        description = scanner.nextLine().trim();
                    }
                    
                    // Create a Square object and add it to the list along with it's actions 
                    
                    switch(number){
                        case 0:
                            board.addSquare(new Square(number,text,description));
                        break;
                        case 1:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,100)));
                        break;
                        case 2:
                            board.addSquare(new Square(number,text,description,new RollDiceAction()));
                        break;
                        case 3:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,300)));
                        break;
                        case 4:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 5:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 6:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,1000)));
                        break;
                        case 7:
                            board.addSquare(new Square(number,text,description,new ExtraLifeAction())); 
                        break;
                        case 8:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 9:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,3000),new RollDiceAction()));
                        break;
                        case 10:                          
                            board.addSquare(new Square(number,text,description,new GameOverAction()));
                        break;
                        case 11:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 12:
                            board.addSquare(new Square(number,text,description,new RollDiceAction()));
                        break;
                        case 13:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,200)));
                        break;
                        case 14:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 15:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 16:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,500),new RollDiceAction()));
                        break;
                        case 17:
                            board.addSquare(new Square(number,text,description,new RollDiceAction()));
                        break;
                        case 18:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 19:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 20:
                            board.addSquare(new Square(number,text,description,new ReceiveMoneyAction(NGOBank)));
                        break;
                        case 21:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,1500)));
                        break;
                        case 22:
                            board.addSquare(new Square(number,text,description,new RollDiceAction()));
                        break;
                        case 23:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 24:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 25:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 26:
                            board.addSquare(new Square(number,text,description,new Box26Action(MafiaBank,1000)));
                        break;
                        case 27:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 28:
                            board.addSquare(new Square(number,text,description,new RollDiceAction()));
                        break;
                        case 29:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 30:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 31:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,800),new RollDiceAction()));
                        break;
                        case 32:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 33:
                            board.addSquare(new Square(number,text,description,new GoToAction(),new RollDiceAction()));
                        break;
                        case 34:
                            board.addSquare(new Square(number,text,description,new StayAction()));
                        break;
                        case 35:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 36:
                            board.addSquare(new Square(number,text,description,new WinAction())); 
                        break;
                        case 37:
                            board.addSquare(new Square(number,text,description,new PayMoneyAction(MafiaBank,100)));
                        break;
                        case 38:
                            board.addSquare(new Square(number,text,description,new GoToAction()));
                        break;
                        case 39:
                            board.addSquare(new Square(number,text,description,new WinAction()));
                        break;
                    }
                }
            }

            scanner.close();
            
        }catch (FileNotFoundException e) {
            System.err.println("File not found: " + e);
        }
        
        //Creating every player, setting their money value to 10.000 and their location to box number 0
        this.ref = new Refugee[players];
        for(int i=0;i<players;i++){
                System.out.print("What is the name of the player number "+(i+1)+": ");
                Scanner input = new Scanner(System.in);
                //input.close();
                this.ref[i] = new Refugee(input.nextLine(),board,0,0);                
        }
    }
    
    public void Play(int players){
        //Starting to play the game, player by player
        do{
            for(int i=0;i<players;i++){
                if(ref[i].getGame_over()){
                    continue;
                }
                if(ref[i].getCan_play()==false){
                    System.out.println("\nIt is player's "+ref[i].getName()+" turn, but they miss this round!\n");
                    StayAction stay = new StayAction();
                    stay.act(ref[i]);
                    continue;
                }
                System.out.println("It is player's " + ref[i].getName() + " turn to play! Choose one of the option below:\n1. Roll the dice\n2. Save the game");
                ref[i].setDice(0);
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                switch(option){
                    case 1:   //In case of rolling the dice
                            RollDiceAction dice = new RollDiceAction();
                            dice.act(ref[i]);  
                        System.out.println("\nPlayer's money: "+ref[i].getMoney()+"$\nPlayer's expenses: "+ref[i].getExpenses()+"$\nNGO's money: "+NGOBank.getMoney()+"$\nMafiaBank's money: "+MafiaBank.getMoney()+"$");
                    break;


                    case 2:     //In case of saving the game for the next time
                        scanner.nextLine();
                        String saveFilePath = "src/uop_project/game_saves/";
                        System.out.print("Enter the file name: ");
                        String saveFileName = scanner.nextLine();
                        saveGame(saveFilePath, saveFileName);
                        System.out.println("Press 0 to exit or 1 to cotinue playing");
                        int input = scanner.nextInt();
                        do{
                            if(input == 0){
                                System.out.println("Thank you for playing!");
                                System.exit(0);
                            } else{
                                System.out.println("Sellect a valid option.");
                            }
                        }while(input!=1);
                    break;
            }
                if(ref[i].getWin()){
                    System.out.println("Congratulations!! You managed to be the first refugee to reach home!!\n\nThank you for playing!!");
                    System.exit(0);
                }
                int counter=0;
                for(int j=0;j<players;j++){
                    if(ref[j].getGame_over())
                            counter++;     
                } 
                if(counter==players){
                        System.out.println("\nIt seems that every player lost. It is GAME OVER!!\n");
                        System.exit(0);
                } 
            }
        }while(true);
    }    
    
    //Saving the game inside a file with the giver name
    public void saveGame(String filePath, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath+fileName))) {
            GameState gameState = new GameState(fileName, ref, board, lives, NGOBank, MafiaBank);
            oos.writeObject(gameState);
            System.out.println("Game saved successfully to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Loading the game from the file with the given name
    public void loadGame(String directoryPath, String fileName) {
        String filePath = directoryPath + File.separator + fileName;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            GameState gameState = (GameState) ois.readObject();
            this.ref = gameState.ref;
            this.board = gameState.board;
            this.lives = gameState.lives;
            this.NGOBank = gameState.NGOBank;
            this.MafiaBank = gameState.MafiaBank;
            System.out.println("Game loaded successfully from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


