
package uop_project;

import java.util.ArrayList;

import java.io.Serializable;

public class Board implements Serializable{
    private ArrayList<Square> squares= new ArrayList<Square>();
    //Creating every square on the board
    public void addSquare(Square square){
        squares.add(square);
    }
    
    public Square getSquare(int num){
        
        return squares.get(num);
    }
}

