/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author danilo
 */
public class BoardPanel extends JPanel {
    private final BoardButton[][] buttons = new BoardButton[3][3];

    BoardPanel(GameFrame gameFrame) {
        super();
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setLayout(new GridLayout(3, 3, 15, 15));
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                this.buttons[i][j] = new BoardButton(gameFrame, i, j);
                this.add(this.buttons[i][j]);
            }
        }
    }
    
    public void refresh() {
        for (BoardButton[] buttonsRow : buttons) {
            for (BoardButton button : buttonsRow) {
                button.refresh();
            }
        }
    }
}
