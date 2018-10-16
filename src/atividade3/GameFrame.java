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
    private String board[][] = new String[3][3];
    private final BoardPanel boardPanel = new BoardPanel(this);
    private final HomePanel homePanel = new HomePanel(this);
    private final EndPanel endPanel = new EndPanel(this);
    private boolean userOrComputer = true; // true for user, false for computed

    public GameFrame() {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setContentPane(this.homePanel);
        this.setVisible(true);
    }

    public void startGame() {
        this.setContentPane(this.boardPanel);
        this.board = new String[3][3];
        this.userOrComputer = true;
        this.boardPanel.refresh();
    }
    
    public void quitGame() {
        this.dispose();
    }
    
    public void makeMovement(int i, int j) {
        if (this.board[i][j] != null) {
            return;
        }

        this.board[i][j] = this.userOrComputer ? "x" : "o";

        int winner = this.checkGameEnd();
        if (winner != 0) {
            this.endPanel.setWinner(winner);
            this.setContentPane(this.endPanel);
            this.revalidate();
        } else {
            this.userOrComputer = !this.userOrComputer;
            this.boardPanel.refresh();
        }
    }
    
    private int checkGameEnd() {
        boolean flag;
        int i, j;

        // Checking row direction
        for (i = 0; i < this.board.length; i++) {
            flag = true;
            for (j = 0; j < this.board[i].length - 1; j++) {
                if (
                    this.board[i][j] == null ||
                    !this.board[i][j].equals(this.board[i][j + 1])
                ) {
                    flag = false;
                }
            }
            if (flag) {
                return this.board[i][0].equals("x") ? 1 : 2;
            }
        }
        
        // Checking columns direction
        for (i = 0; i < this.board.length; i++) {
            flag = true;
            for (j = 0; j < this.board[i].length - 1; j++) {
                if (
                    this.board[j][i] == null
                    || !this.board[j][i].equals(this.board[j + 1][i])
                ) {
                    flag = false;
                }
            }
            if (flag) {
                return this.board[0][i].equals("x") ? 1 : 2;
            }
        }
        
        // Checking first diagonal direction
        flag = true;
        for (i = 0; i < this.board.length - 1; i++) {
            if (
                this.board[i][i] == null
                || !this.board[i][i].equals(this.board[i + 1][i + 1])
            ) {
                flag = false;
            }
        }
        if (flag) {
            return this.board[0][0].equals("x") ? 1 : 2;
        }
        
        // Checking second diagonal direction
        flag = true;
        for (i = 0; i < this.board.length - 1; i++) {
            if (
                this.board[this.board.length - i - 1][i] == null ||
                !this.board[this.board.length - i - 1][i]
                    .equals(this.board[this.board.length - i - 2][i + 1])
            ) {
                flag = false;
            }
        }
        if (flag) {
            return this.board[this.board.length - 1][0].equals("x") ? 1 : 2;
        }
        
        // Checking if board is full
        flag = true;
        for (i = 0; i < this.board.length; i++) {
            for (j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == null) {
                    flag = false;
                }
            }
        }
        if (flag) {
            return -1;
        }
        
        return 0;
    }

    public String getBoardCell(int i, int j) {
        return this.board[i][j];
    }
}
