package com.spartanny.strategy.impl;

import com.spartanny.entities.Board;
import com.spartanny.handler.HealthHandler;
import com.spartanny.handler.MoveHandler;
import com.spartanny.strategy.interfaces.IPlayModeStrategy;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;

import java.net.InetSocketAddress;

public class OnlinePlayMode implements IPlayModeStrategy {

    private static final String BASE_PATH = "/api/v1";
    private static final int PORT = 8080;

    private Board board;

    public OnlinePlayMode(Board board) {
        this.board = board;
    }

    @SneakyThrows
    @Override
    public void start() {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        initialiseContext(httpServer);
        httpServer.start();
        System.out.println("Server started on port " + PORT);
    }

    private void initialiseContext(HttpServer httpServer) {
        httpServer.createContext("/health", new HealthHandler());
        httpServer.createContext(BASE_PATH + "/move", new MoveHandler(board));
    }
}
