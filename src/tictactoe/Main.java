/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import tictactoe.logic.Game;

/**
 * The executable project class.
 * 
 * @author danilo
 */
public class Main {
    /**
     * Just start the game
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }
}
