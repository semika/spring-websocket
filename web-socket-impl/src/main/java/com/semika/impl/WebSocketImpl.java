package com.semika.impl;

import com.semika.api.WebSocketApi;

public class WebSocketImpl implements WebSocketApi {

    @Override
    public String handshake() {
        System.out.println("Handshake done.....!");
        return "success";
    }
}
