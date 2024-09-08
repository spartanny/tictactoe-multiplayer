package com.spartanny.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HealthHandler implements HttpHandler {

    private static final String HEALTH = "Systems are working fine ;)";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200 , HEALTH.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(HEALTH.getBytes());
        os.close();
    }
}
