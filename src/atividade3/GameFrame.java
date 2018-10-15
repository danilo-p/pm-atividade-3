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
    private BoardPanel boardPanel = new BoardPanel(this);
    private HomePanel homePanel = new HomePanel(this);

    public GameFrame() {
        super("GameFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setContentPane(this.homePanel);
        this.setVisible(true);
    }

    public void startGame() {
        this.setContentPane(this.boardPanel);
        this.board = new String[3][3];
        this.boardPanel.refresh();
    }
    
    public void quitGame() {
        this.dispose();
    }
    
    public void setBoardCell(int i, int j, String symbol) {
        this.board[i][j] = symbol;
        this.boardPanel.refresh();
    }

    String getBoardCell(int i, int j) {
        return this.board[i][j];
    }
}
