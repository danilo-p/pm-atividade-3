/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author danilo
 */
public class BoardButton extends JButton {
    private final int i;
    private final int j;
    private final GameFrame gameFrame;

    BoardButton(GameFrame gameFrame, int i, int j) {
        this.i = i;
        this.j = j;
        this.gameFrame = gameFrame;
        this.addActionListener((ActionEvent e) -> {
            gameFrame.makeMovement(i, j);
        });
    }

    public void refresh() {
        this.setText(this.gameFrame.getBoardCell(this.i, this.j));
    }
}
