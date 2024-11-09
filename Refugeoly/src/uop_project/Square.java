/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uop_project;

import java.util.ArrayList;
import java.io.Serializable;

public class Square implements Serializable{
    private int number;
    private String text;
    private String description;
    //maybe add 
    public Board board;
    public ArrayList<Action> actions;
   
    //According to the parameters of a square, it is going to use the right constructor
    public Square(int number, String text, String description){
        this.number = number;
        this.text = text;
        this.description = description;
        this.actions = new ArrayList<>();
    }
    
    public Square(int number,String text,String description,Action action){
        this.number = number;
        this.text = text;
        this.description = description;
        this.actions = new ArrayList<>();
        addAction(action);
    }
    
    public Square(int number,String text,String description,Action action1,Action action2){
        this.number = number;
        this.text = text;
        this.description = description;
        this.actions = new ArrayList<>();
        addAction(action1);
        addAction(action2);
    }
    
    
    //Set and get for number, text and actions
    
    public int getNumber(){
        return number;
    }
    
    public String getText(){
        return text;
    }    
    public String getDescription(){
        return description;
    }
    
    public int getAct(){
        return actions.size();
    }
    
    public void setNumber(int n){
        number = n;
    }
    
    public void setText(String t){
        text=t;
    }    
    
    public void setDescription(String de){
        description=de;
    }
    
    public final void addAction(Action act){
        actions.add(act);
    }
    
    public void act(Refugee ref){
        Action[] acts = new Action[2];
        for (int i = 0; i < actions.size(); i++){
            acts[i] = actions.get(i);
            Action act = actions.get(i);
            act.act(ref);
        }
    }
}
