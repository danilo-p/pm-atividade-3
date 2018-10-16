/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import tictactoe.logic.Game;

/**
 * Display the game initial actions and the game title.
 * 
 * Should present controls that initialize the game for the user.
 *
 * @author danilo
 */
public class HomeScreen extends GameScreen {
    public HomeScreen(Game game) {
        super(game);
    }

    @Override
    public void init() {
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel(Game.TITLE, SwingConstants.CENTER);
        titleLabel.setFont(GameFrame.GAME_TITLE_FONT);
        this.add(titleLabel, BorderLayout.CENTER);

        Game game = this.getGame();

        JButton startButton = new JButton("Start game");
        startButton.setFont(GameFrame.GAME_BUTTON_FONT);
        startButton.addActionListener((ActionEvent e) -> {
            game.start();
        });        

        JButton quitButton = new JButton("Quit game");
        quitButton.setFont(GameFrame.GAME_BUTTON_FONT);
        quitButton.addActionListener((ActionEvent e) -> {
            game.quit();
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(startButton);
        buttonsPanel.add(quitButton);
        this.add(buttonsPanel, BorderLayout.PAGE_END);
    }
}
