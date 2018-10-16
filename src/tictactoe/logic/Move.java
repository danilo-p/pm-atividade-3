/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.logic;

/**
 * Represents a player move.
 * 
 * As the board is a grid, the move corresponds to the cell that should be
 * filled by the move.
 * 
 * @author danilo
 */
public class Move {
    private final int i;
    private final int j;
    
    public Move(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
    public int getI() {
        return this.i;
    }
    
    public int getJ() {
        return this.j;
    }
}
