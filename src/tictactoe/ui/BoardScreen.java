/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import tictactoe.logic.Game;
import tictactoe.logic.Move;

/**
 * Display the game board
 * 
 * This component display the current state of the board, creating the buttons
 * for user interaction and updating it when requested by the game.
 * 
 * @author danilo
 */
public class BoardScreen extends GameScreen {
    private final BoardButton[][] buttons = new BoardButton[3][3];

    public BoardScreen(Game game) {
        super(game);
    }
    
    @Override
    public void init() {
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setLayout(new GridLayout(3, 3, 15, 15));
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                this.buttons[i][j] = new BoardButton(this.getGame(),
                    new Move(i, j));
                this.buttons[i][j].init();
                this.add(this.buttons[i][j]);
            }
        }
    }
    
    public void update() {
        for (BoardButton[] buttonsRow : buttons) {
            for (BoardButton button : buttonsRow) {
                button.update();
            }
        }
    }
}
