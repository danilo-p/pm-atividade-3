/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.logic;

import tictactoe.ui.GameFrame;

/**
 * Contains the game logic.
 * 
 * It controls the game state updating the UI and receiving user interactions.
 * 
 * @author danilo
 */
public class Game {
    public static String TITLE = "Tic Tac Toe";
    public static int BOARD_SIZE = 3;
    public static char USER_SYMBOL = 'x';
    public static int USER_ID = 1;
    public static char COMPUTER_SYMBOL = 'o';
    public static int COMPUTER_ID = 2;
    public static char EMPTY_SYMBOL = ' ';
    public static int NOBODY_ID = -1;
    
    private final GameFrame gameFrame = new GameFrame(this);
    private final ComputerPlayer computerPlayer
        = new ComputerPlayer(Game.COMPUTER_SYMBOL);
    private final char board[][]
        = new char[Game.BOARD_SIZE][Game.BOARD_SIZE];

    public void init() {
        this.gameFrame.init();
        this.gameFrame.goToHomeScreen();
    }

    public void start() {
        this.resetBoard();
        this.gameFrame.goToBoardScreen();
    }
    
    public void quit() {
        this.gameFrame.dispose();
    }
    
    public void makeUserMovement(Move userMove) {
        if (
            this.board[userMove.getI()][userMove.getJ()]
            != Game.EMPTY_SYMBOL
        ) {
            return;
        }
        this.board[userMove.getI()][userMove.getJ()] = Game.USER_SYMBOL;
        int winnerId = this.checkGameEnd();
        if (winnerId != 0) {
            this.gameFrame.goToEndScreen(winnerId);
        } else {
            this.makeComputerMovement();
        }
    }
    
        public char getBoardCell(int i, int j) {
        return this.board[i][j];
    }
    
    private void makeComputerMovement() {
        Move computerMove = this.computerPlayer.makeMove(board.clone());
        this.board[computerMove.getI()][computerMove.getJ()] =
            Game.COMPUTER_SYMBOL;
        int winnerId = this.checkGameEnd();
        if (winnerId != 0) {
            this.gameFrame.goToEndScreen(winnerId);
        } else {
            this.gameFrame.updateBoardScreen();
        }
    }
    
    private int checkGameEnd() {
        boolean flag;
        int i, j;

        // Checking row direction
        for (i = 0; i < Game.BOARD_SIZE; i++) {
            flag = true;
            for (j = 0; j < Game.BOARD_SIZE - 1; j++) {
                if (
                    this.board[i][j] == Game.EMPTY_SYMBOL
                    || this.board[i][j] != this.board[i][j + 1]
                ) {
                    flag = false;
                }
            }
            if (flag) {
                return this.board[i][0] == Game.USER_SYMBOL
                    ? Game.USER_ID
                    : Game.COMPUTER_ID;
            }
        }
        
        // Checking columns direction
        for (i = 0; i < Game.BOARD_SIZE; i++) {
            flag = true;
            for (j = 0; j < Game.BOARD_SIZE - 1; j++) {
                if (
                    this.board[j][i] == Game.EMPTY_SYMBOL
                    || this.board[j][i] != this.board[j + 1][i]
                ) {
                    flag = false;
                }
            }
            if (flag) {
                return this.board[0][i] == Game.USER_SYMBOL
                    ? Game.USER_ID
                    : Game.COMPUTER_ID;
            }
        }
        
        // Checking first diagonal direction
        flag = true;
        for (i = 0; i < Game.BOARD_SIZE - 1; i++) {
            if (
                this.board[i][i] == Game.EMPTY_SYMBOL
                || this.board[i][i] != this.board[i + 1][i + 1]
            ) {
                flag = false;
            }
        }
        if (flag) {
            return this.board[0][0] == Game.USER_SYMBOL
                ? Game.USER_ID
                : Game.COMPUTER_ID;
        }
        
        // Checking second diagonal direction
        flag = true;
        for (i = 0; i < Game.BOARD_SIZE - 1; i++) {
            if (
                (
                    this.board[Game.BOARD_SIZE - i - 1][i]
                    == Game.EMPTY_SYMBOL
                ) || (
                    this.board[Game.BOARD_SIZE - i - 1][i]
                    != this.board[Game.BOARD_SIZE - i - 2][i + 1]
                )
            ) {
                flag = false;
            }
        }
        if (flag) {
            return (
                this.board[Game.BOARD_SIZE - 1][0]
                == Game.USER_SYMBOL
            ) ? Game.USER_ID : Game.COMPUTER_ID;
        }
        
        // Checking if board is full
        flag = true;
        for (i = 0; i < Game.BOARD_SIZE; i++) {
            for (j = 0; j < Game.BOARD_SIZE; j++) {
                if (this.board[i][j] == Game.EMPTY_SYMBOL) {
                    flag = false;
                }
            }
        }
        if (flag) {
            return Game.NOBODY_ID;
        }
        
        return 0;
    }
    
    private void resetBoard() {
        for (int i = 0; i < Game.BOARD_SIZE; i++) {
            for (int j = 0; j < Game.BOARD_SIZE; j++) {
                this.board[i][j] = Game.EMPTY_SYMBOL;
            }
        }
    }
}
