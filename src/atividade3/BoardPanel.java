/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author danilo
 */
public class BoardPanel extends JPanel {
    private final JButton topLeftButton = new JButton("");
    private final JButton topButton = new JButton("");
    private final JButton topRightButton = new JButton("");
    private final JButton middleLeftButton = new JButton("");
    private final JButton middleButton = new JButton("");
    private final JButton middleRightButton = new JButton("");
    private final JButton bottomLeftButton = new JButton("");
    private final JButton bottomButton = new JButton("");
    private final JButton bottomRightButton = new JButton("");
    private final GameFrame gameFrame;

    BoardPanel(GameFrame gameFrame) {
        super();
        this.gameFrame = gameFrame;
        this.setLayout(new GridLayout(3, 3, 0, 0));
        this.topLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(0, 0, "x");
            }
        });
        this.add(this.topLeftButton);
        this.topButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(0, 1, "x");
            }
        });
        this.add(this.topButton);
        this.topRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(0, 2, "x");
            }
        });
        this.add(this.topRightButton);
        this.middleLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(1, 0, "x");
            }
        });
        this.add(this.middleLeftButton);
        this.middleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(1, 1, "x");
            }
        });
        this.add(this.middleButton);
        this.middleRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(1, 2, "x");
            }
        });
        this.add(this.middleRightButton);
        this.bottomLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(2, 0, "x");
            }
        });
        this.add(this.bottomLeftButton);
        this.bottomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(2, 1, "x");
            }
        });
        this.add(this.bottomButton);
        this.bottomRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setBoardCell(2, 2, "x");
            }
        });
        this.add(this.bottomRightButton);
    }
    
    public void refresh() {
        this.topLeftButton.setText(this.gameFrame.getBoardCell(0, 0));
        this.topButton.setText(this.gameFrame.getBoardCell(0, 1));
        this.topRightButton.setText(this.gameFrame.getBoardCell(0, 2));
        this.middleLeftButton.setText(this.gameFrame.getBoardCell(1, 0));
        this.middleButton.setText(this.gameFrame.getBoardCell(1, 1));
        this.middleRightButton.setText(this.gameFrame.getBoardCell(1, 2));
        this.bottomLeftButton.setText(this.gameFrame.getBoardCell(2, 0));
        this.bottomButton.setText(this.gameFrame.getBoardCell(2, 1));
        this.bottomRightButton.setText(this.gameFrame.getBoardCell(2, 2));
    }
}
