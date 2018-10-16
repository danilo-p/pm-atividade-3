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
public class EndPanel extends JPanel {
    private final JLabel winnerLabel;

    EndPanel(GameFrame gameFrame) {
        super();
        
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setLayout(new BorderLayout());
        
        this.winnerLabel = new JLabel("", SwingConstants.CENTER);

        this.add(winnerLabel, BorderLayout.CENTER);
        winnerLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel buttonsPanel = new JPanel();

        JButton playAgainButton = new JButton("Play again");
        playAgainButton.addActionListener((ActionEvent e) -> {
            gameFrame.startGame();
        });
        buttonsPanel.add(playAgainButton);
        
        JButton quitButton = new JButton("Quit game");
        quitButton.addActionListener((ActionEvent e) -> {
            gameFrame.quitGame();
        });
        buttonsPanel.add(quitButton);
        
        this.add(buttonsPanel, BorderLayout.PAGE_END);
    }
    
    public void setWinner(int winner) {
        String message = "";
        
        switch (winner) {
            case -1:
                message = "Nobody won '-'";
                break;
            case 1:
                message = "You won! :D";
                break;
            case 2:
                message = "The computer won! ¯\\_(ツ)_/¯";
                break;
        }
        
        winnerLabel.setText(message);
    }
}
