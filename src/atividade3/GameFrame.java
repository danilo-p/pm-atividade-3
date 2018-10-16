/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

import javax.swing.JFrame;

/**
 *
 * @author danilo
 */
public class GameFrame extends JFrame {
    public static int WINDOW_SIZE = 500;
    public static int BOARD_SIZE = 3;
    public static char USER_SYMBOL = 'x';
    public static int USER_ID = 1;
    public static char COMPUTER_SYMBOL = 'o';
    public static int COMPUTER_ID = 2;
    public static char EMPTY_SYMBOL = ' ';
    public static int NOBODY_ID = -1;
    
    private final BoardPanel boardPanel = new BoardPanel(this);
    private final HomePanel homePanel = new HomePanel(this);
    private final EndPanel endPanel = new EndPanel(this);
    private final ComputerPlayer computerPlayer
        = new ComputerPlayer(GameFrame.COMPUTER_SYMBOL);
    private char board[][]
        = new char[GameFrame.BOARD_SIZE][GameFrame.BOARD_SIZE];

    public GameFrame() {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GameFrame.WINDOW_SIZE, GameFrame.WINDOW_SIZE);
        this.setContentPane(this.homePanel);
        this.setVisible(true);
    }

    public void startGame() {
        this.setContentPane(this.boardPanel);
        this.resetBoard();
        this.boardPanel.refresh();
    }
    
    public void quitGame() {
        this.dispose();
    }
    
    public void makeUserMovement(Move userMove) {
        if (this.board[userMove.getI()][userMove.getJ()] != GameFrame.EMPTY_SYMBOL) {
            return;
        }
        this.board[userMove.getI()][userMove.getJ()] = GameFrame.USER_SYMBOL;
        int winnerId = this.checkGameEnd();
        if (winnerId != 0) {
            this.goToEndGame(winnerId);
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
            GameFrame.COMPUTER_SYMBOL;
        int winnerId = this.checkGameEnd();
        if (winnerId != 0) {
            this.goToEndGame(winnerId);
        } else {
            this.boardPanel.refresh();
        }
    }
    
    private void goToEndGame(int winnerId) {
        this.endPanel.setWinner(winnerId);
        this.setContentPane(this.endPanel);
        this.revalidate();
    }
    
    private void resetBoard() {
        for (int i = 0; i < GameFrame.BOARD_SIZE; i++) {
            for (int j = 0; j < GameFrame.BOARD_SIZE; j++) {
                this.board[i][j] = GameFrame.EMPTY_SYMBOL;
            }
        }
    }
    
    private int checkGameEnd() {
        boolean flag;
        int i, j;

        // Checking row direction
        for (i = 0; i < GameFrame.BOARD_SIZE; i++) {
            flag = true;
            for (j = 0; j < GameFrame.BOARD_SIZE - 1; j++) {
                if (
                    this.board[i][j] == GameFrame.EMPTY_SYMBOL
                    || this.board[i][j] != this.board[i][j + 1]
                ) {
                    flag = false;
                }
            }
            if (flag) {
                return this.board[i][0] == GameFrame.USER_SYMBOL
                    ? GameFrame.USER_ID
                    : GameFrame.COMPUTER_ID;
            }
        }
        
        // Checking columns direction
        for (i = 0; i < GameFrame.BOARD_SIZE; i++) {
            flag = true;
            for (j = 0; j < GameFrame.BOARD_SIZE - 1; j++) {
                if (
                    this.board[j][i] == GameFrame.EMPTY_SYMBOL
                    || this.board[j][i] != this.board[j + 1][i]
                ) {
                    flag = false;
                }
            }
            if (flag) {
                return this.board[0][i] == GameFrame.USER_SYMBOL
                    ? GameFrame.USER_ID
                    : GameFrame.COMPUTER_ID;
            }
        }
        
        // Checking first diagonal direction
        flag = true;
        for (i = 0; i < GameFrame.BOARD_SIZE - 1; i++) {
            if (
                this.board[i][i] == GameFrame.EMPTY_SYMBOL
                || this.board[i][i] != this.board[i + 1][i + 1]
            ) {
                flag = false;
            }
        }
        if (flag) {
            return this.board[0][0] == GameFrame.USER_SYMBOL
                ? GameFrame.USER_ID
                : GameFrame.COMPUTER_ID;
        }
        
        // Checking second diagonal direction
        flag = true;
        for (i = 0; i < GameFrame.BOARD_SIZE - 1; i++) {
            if (
                (
                    this.board[GameFrame.BOARD_SIZE - i - 1][i]
                    == GameFrame.EMPTY_SYMBOL
                ) || (
                    this.board[GameFrame.BOARD_SIZE - i - 1][i]
                    != this.board[GameFrame.BOARD_SIZE - i - 2][i + 1]
                )
            ) {
                flag = false;
            }
        }
        if (flag) {
            return this.board[GameFrame.BOARD_SIZE - 1][0] == GameFrame.USER_SYMBOL
                ? GameFrame.USER_ID
                : GameFrame.COMPUTER_ID;
        }
        
        // Checking if board is full
        flag = true;
        for (i = 0; i < GameFrame.BOARD_SIZE; i++) {
            for (j = 0; j < GameFrame.BOARD_SIZE; j++) {
                if (this.board[i][j] == GameFrame.EMPTY_SYMBOL) {
                    flag = false;
                }
            }
        }
        if (flag) {
            return GameFrame.NOBODY_ID;
        }
        
        return 0;
    }
}
