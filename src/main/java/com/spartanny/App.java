package com.spartanny;

import com.spartanny.entities.Board;
import com.spartanny.entities.Player;
import com.spartanny.strategy.impl.LocalPlayMode;
import com.spartanny.strategy.impl.OnlinePlayMode;
import com.spartanny.strategy.interfaces.IPlayModeStrategy;


/**
 * TIC_TAC_TOE Application
 */
public class App {

    public static void main(String[] args) {

        Player p1 = new Player("Spartanny", "X");
        Player p2 = new Player("Ghost", "O");
        Board board = new Board(p1, p2);

//        IPlayModeStrategy playMode = new LocalPlayMode(board);
        IPlayModeStrategy playMode = new OnlinePlayMode(board);

        playMode.start();

    }

}
