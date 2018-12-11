/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import tictactoe.logic.Game;

/**
 * Wrapper for all the game screens.
 * 
 * This component create and control all the screens that the game has. It is
 * controlled by the game, and should create and initialize the screens.
 *
 * @author danilo
 */
public class GameFrame extends JFrame {
    public static int WINDOW_SIZE = 500;
    public static String GAME_FONT_NAME = "Monospaced";
    public static int GAME_FONT_STYLE = Font.PLAIN;
    public static int GAME_TITLE_FONT_SIZE = 30;
    public static int GAME_BUTTON_FONT_SIZE = 12;
    public static Font GAME_TITLE_FONT = new Font(GameFrame.GAME_FONT_NAME,
        GameFrame.GAME_FONT_STYLE, GameFrame.GAME_TITLE_FONT_SIZE);
    public static Font GAME_BUTTON_FONT = new Font(GameFrame.GAME_FONT_NAME,
        GameFrame.GAME_FONT_STYLE, GameFrame.GAME_BUTTON_FONT_SIZE);
    public static Color GAME_DARK_COLOR = Color.BLACK;
    public static Color GAME_LIGHT_COLOR = Color.WHITE;

    private final Game game;
    private final BoardScreen boardScreen;
    private final HomeScreen homeScreen;
    private final EndScreen endScreen;

    public GameFrame(Game game) {
        super(Game.TITLE);
        this.game = game;
        this.boardScreen = new BoardScreen(game);
        this.boardScreen.init();
        this.homeScreen = new HomeScreen(game);
        this.homeScreen.init();
        this.endScreen = new EndScreen(game);
        this.endScreen.init();
    }
    
    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GameFrame.WINDOW_SIZE, GameFrame.WINDOW_SIZE);
        this.setVisible(true);
    }

    public void goToHomeScreen() {
        this.setContentPane(this.homeScreen);
        this.revalidate();
    }

    public void goToBoardScreen() {
        this.setContentPane(this.boardScreen);
        this.boardScreen.update();
    }
    
    public void updateBoardScreen() {
        this.boardScreen.update();
    }
    
    public void goToEndScreen(int winnerId) {
        this.endScreen.setWinner(winnerId);
        this.setContentPane(this.endScreen);
        this.revalidate();
    }
}
