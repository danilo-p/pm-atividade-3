/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import javax.swing.JPanel;
import tictactoe.logic.Game;

/**
 * Generic class for a game screen.
 * 
 * This represents a screen of the game. A screen should have the game instance
 * and initialize the elements that it has.
 * 
 * @author danilo
 */
abstract public class GameScreen extends JPanel {
    private final Game game;

    public GameScreen(Game game) {
        super();
        this.game = game;
    }
    
    abstract public void init();
    
    public Game getGame() {
        return this.game;
    }
}
