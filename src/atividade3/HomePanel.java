/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author danilo
 */
public class HomePanel extends JPanel {
    HomePanel(GameFrame gameFrame) {
        super();

        JButton startButton = new JButton("Start game");
        startButton.addActionListener((ActionEvent e) -> {
            gameFrame.startGame();
        });
        this.add(startButton);
        
        JButton quitButton = new JButton("Quit game");
        quitButton.addActionListener((ActionEvent e) -> {
            gameFrame.quitGame();
        });
        this.add(quitButton);
    }
}
