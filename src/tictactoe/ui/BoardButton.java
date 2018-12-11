/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import tictactoe.logic.Move;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import tictactoe.logic.Game;

/**
 * Display the board button.
 * 
 * This component is a button on the board, and is responsible for initializing
 * the event listeners to react to the user interaction and inform it to the
 * game.
 * 
 * @author danilo
 */
public class BoardButton extends JButton {
    private final Move move;
    private final Game game;

    public BoardButton(Game game, Move move) {
        this.move = move;
        this.game = game;
    }
    
    public void init() {
        this.setFont(GameFrame.GAME_TITLE_FONT);
        this.setBackground(GameFrame.GAME_DARK_COLOR);
        this.setForeground(GameFrame.GAME_LIGHT_COLOR);
        this.addActionListener((ActionEvent e) -> {
            BoardButton.this.game.makeUserMovement(BoardButton.this.move);
        });
    }

    public void update() {
        char symbol = this.game.getBoardCell(this.move.getI(),
            this.move.getJ());
        this.setText("" + symbol);
    }
}
