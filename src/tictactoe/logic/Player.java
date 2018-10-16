/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.logic;

/**
 * Generic player class.
 * 
 * The game player should know his symbol and make his moves when requested. The
 * logic for the moves should be implemented for whom is extending the class.
 * 
 * @author danilo
 */
public abstract class Player {
    private final char symbol;
    
    public Player(char symbol) {
        this.symbol = symbol;
    }

    abstract public Move makeMove(char[][] board);
}
