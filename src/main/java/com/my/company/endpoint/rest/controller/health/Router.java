package com.my.company.endpoint.rest.controller.health;

import com.my.company.Service.Handler;
import io.javalin.Javalin;

public class Router {
    public static void configure(Javalin app) {
        Handler handler = new Handler();

        app.get("/stored-int", ctx -> {
            ctx.result(handler.getStoredInt());
        });
    }
}
