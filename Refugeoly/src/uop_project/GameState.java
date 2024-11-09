package uop_project;

import java.io.Serializable;
//For saving the game in the given name
public class GameState implements Serializable {
    public String fileName;
    public Refugee[] ref;
    public Board board;
    public int[] lives;
    public GiverEntity NGOBank;
    public ReceiverEntity MafiaBank;

    public GameState(String fileName, Refugee[] ref, Board board, int[] lives, GiverEntity NGOBank, ReceiverEntity MafiaBank) {
        this.fileName = fileName;
        this.ref = ref;
        this.board = board;
        this.lives = lives;
        this.NGOBank = NGOBank;
        this.MafiaBank = MafiaBank;
    }
}


