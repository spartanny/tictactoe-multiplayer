package com.spartanny.strategy.impl;

import com.spartanny.entities.Board;
import com.spartanny.exceptions.ValidMoveException;
import com.spartanny.strategy.interfaces.IPlayModeStrategy;

import java.util.Scanner;

public class LocalPlayMode implements IPlayModeStrategy {

    private Board board;

    private final int p1 = 0, p2 = 1;

    public LocalPlayMode(Board board) {
        this.board = board;
    }

    @Override
    public void start() {
        int movesCount = 0;

        while(board.getWinner() != true) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt(), j = scanner.nextInt();
            int currentPlayer = movesCount % 2 == 0 ? p1 : p2;
            ++movesCount;
            try {
                board.playMove(i, j, currentPlayer);
            }
            catch (ValidMoveException ignored) {
                // Already printing the exception in console
            }
        }
    }
}
