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
public class Move {
    private final int i;
    private int j;
    
    Move(int i, int j) {
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
