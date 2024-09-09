package com.spartanny.handler;

import com.spartanny.entities.Board;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class ResetHandler implements HttpHandler {

    private Board board;

    public ResetHandler(Board board) {
        this.board = board;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        OutputStream os = exchange.getResponseBody();
        board.resetBoard();
        String restartMsg = "Restarted ! \n";
        exchange.sendResponseHeaders(200, restartMsg.getBytes().length);
        os.write(restartMsg.getBytes());
        os.close();
    }
}
