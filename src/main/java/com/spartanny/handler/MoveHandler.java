package com.spartanny.handler;

import com.spartanny.entities.Board;
import com.spartanny.exceptions.ValidMoveException;
import com.spartanny.helper.HttpHelper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class MoveHandler implements HttpHandler {
    private Board board;

    private static final String MOVE_REGISTERED = "Move registered successfully !";
    private static int count = 0;
    private static int p1 =0, p2 = 1;

    public MoveHandler(Board board) {
        this.board = board;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Map<String, Object> params = HttpHelper.getQueryParams(exchange.getRequestURI().getQuery());
        StringBuilder res = new StringBuilder();

        if(params.get("cell") != null) {
            int cell =  Integer.parseInt((String) params.get("cell")) - 1;
            int r = cell / 3;
            int c = cell % 3;
            try {
                board.playMove(r, c, count % 2 == 0 ? p1 : p2);

                res.append(MOVE_REGISTERED).append("\n").append(board.getBoardState());
                if(board.getWinnerDetails() != null) {
                    res.append("\n").append(board.getWinnerDetails().getName() + " WON !");
                }
                MoveHandler.count ++;

            } catch (ValidMoveException e) {
                res = new StringBuilder(e.getMessage());
            }

            exchange.sendResponseHeaders(200, res.toString().getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(res.toString().getBytes());
            os.close();
        }

    }
}
