/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import tictactoe.logic.Game;

/**
 * Display the end game screen
 * 
 * This is the component that is presented to the user when the game ends. This
 * should show who won the game, if somebody won.
 *
 * @author danilo
 */
public class EndScreen extends GameScreen {
    private final JLabel winnerLabel;

    public EndScreen(Game game) {
        super(game);
        this.winnerLabel = new JLabel("", SwingConstants.CENTER);
    }

    @Override
    public void init() {
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setLayout(new BorderLayout());
        this.setBackground(GameFrame.GAME_DARK_COLOR);

        this.add(winnerLabel, BorderLayout.CENTER);
        winnerLabel.setAlignmentX(CENTER_ALIGNMENT);
        winnerLabel.setFont(GameFrame.GAME_TITLE_FONT);
        winnerLabel.setForeground(GameFrame.GAME_LIGHT_COLOR);
        
        Game game = this.getGame();

        JButton playAgainButton = new JButton("Play again");
        playAgainButton.setFont(GameFrame.GAME_BUTTON_FONT);
        playAgainButton.setBackground(GameFrame.GAME_DARK_COLOR);
        playAgainButton.setForeground(GameFrame.GAME_LIGHT_COLOR);
        playAgainButton.addActionListener((ActionEvent e) -> {
            game.start();
        });
        
        
        JButton quitButton = new JButton("Quit game");
        quitButton.setFont(GameFrame.GAME_BUTTON_FONT);
        quitButton.setBackground(GameFrame.GAME_DARK_COLOR);
        quitButton.setForeground(GameFrame.GAME_LIGHT_COLOR);
        quitButton.addActionListener((ActionEvent e) -> {
            game.quit();
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(GameFrame.GAME_DARK_COLOR);
        buttonsPanel.add(playAgainButton);
        buttonsPanel.add(quitButton);
        
        this.add(buttonsPanel, BorderLayout.PAGE_END);
    }
    
    
    public void setWinner(int winner) {
        String message = "";
        
        switch (winner) {
            case -1:
                message = "Nobody won<br>'-'";
                break;
            case 1:
                message = "You won!<br>:D";
                break;
            case 2:
                message = "The computer won!<br>¯\\_(ツ)_/¯";
                break;
        }

        winnerLabel.setText("<html><body><center>" + message + "</center></body></html>");
    }
}
