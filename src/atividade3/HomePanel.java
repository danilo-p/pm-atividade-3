/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author danilo
 */
public class HomePanel extends JPanel {
    HomePanel(GameFrame gameFrame) {
        super();

        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Tic Tac Toe", SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.CENTER);
        
        JPanel buttonsPanel = new JPanel();

        JButton startButton = new JButton("Start game");
        startButton.addActionListener((ActionEvent e) -> {
            gameFrame.startGame();
        });
        buttonsPanel.add(startButton);

        JButton quitButton = new JButton("Quit game");
        quitButton.addActionListener((ActionEvent e) -> {
            gameFrame.quitGame();
        });
        buttonsPanel.add(quitButton);

        this.add(buttonsPanel, BorderLayout.PAGE_END);
    }
}
