/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

import java.util.Random;

/**
 *
 * @author danilo
 */
public class ComputerPlayer extends Player{
    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public Move makeMove(char[][] board) {
        int i = -1, j = -1;
        Random random = new Random();

        while (i == -1 || j == -1) {
            i = random.nextInt(3);
            j = random.nextInt(3);
            
            if (board[i][j] != ' ') {
                i = -1;
                j = -1;
            }
        }

        return new Move(i, j);
    }
}
