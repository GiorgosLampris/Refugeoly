/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;
import java.io.Serializable;

public class Refugee implements Serializable{
    private String name;
    private double money;
    public Board board;
    int currentSquare;
    private double expenses; 
    private int dice;
    private boolean can_play=true; //For StayAction class
    private int counter_box26 = 2; //For Box26Action class
    private int lives = 0; //For ExtraLifeAction class
    private boolean win=false; //For WinAction class
    private boolean game_over=false; //In case a player loses
    
    //Creating the ref object
    public Refugee(String name, Board board,int currentSquare, double expenses){
        this.name = name; 
        this.money = 10000; 
        this.board = board;
        this.currentSquare = currentSquare;
        this.expenses = 0;
    }
    
    //ReceiveMoney
    public void receiveMoney(double amount){
        money += amount;
        System.out.println(name + " just got " + amount + " $. New balance: " + money);
    }
    
    //GiveMoney
    public double giveMoney(double amount){
        if(money >= amount){
            money -= amount;
            expenses=+ amount;
            System.out.println("Player: "+name + " payed " + amount + "$/n");
            return money;
        } else {
            System.out.println(name + " does not have this amount!");
            game_over=true;
            System.out.println("\nPlayer "+name+".You lost all your money or you are just unable to pay a fee, so you are out of the game!\n\n------GAME OVER!!------\n");
            return -1;
        }
    }
    
    //Getters and Setters
    
    public String getName(){
        return name;
    }
    
    public double  getMoney(){
        return money;
    }
    
    public Board getBoard(){
        return board;
    }
    
    public int getCurrentSquare(){
        return currentSquare;
    }
    
    public int getDice(){
        return dice;
    }
    
    public boolean getCan_play(){
        return can_play;
    }
    
    public int getCounter_box26(){
        return counter_box26;
    }
    
    public int getLives(){
        return lives;
    }
    
    public boolean getWin(){
        return win;
    }
    
    public double getExpenses(){
        return expenses;
    }
    
    public boolean getGame_over(){
        return game_over;
    }
   
    
    
    public void setName(String n){
        name=n;
    }
    
    public void  setMoney(double m){
        money+=m;
    }
    
    public void setExpenses(double exp){
        expenses=exp;
    }
    
    public void setCurrentSquare(int sq){
        currentSquare=sq;
    }
    
    public void setDice(int dc){
        dice=dc;
    }
    
    public void setCan_play(boolean cp){
        can_play=cp;
    }
    
    public void setCounter_box26(int counter){
        counter_box26=counter;
    }
    
    public void setLives(int lv){
        lives+= lv;
    }
    
    public void setWin(boolean w){
        win=w;
    }
    
    public void setGame_over(boolean go){
        game_over=go;
    }
    
}
