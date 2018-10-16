/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

/**
 *
 * @author danilo
 */
public abstract class Player {
    private final char symbol;
    
    Player(char symbol) {
        this.symbol = symbol;
    }

    abstract public Move makeMove(char[][] board);
}
