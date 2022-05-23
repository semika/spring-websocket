package com.semika.controller;

import com.semika.responsemodel.Status;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.TimeUnit;

@RestController
public class PaymentStatusUpdateController {

    @Value("${mosaic.websocket.url.connector}")
    private String connectorUrl;

    @PostMapping("/update-payment_status")
    public void updatePaymentStatus(@RequestParam String status) throws Exception {

        WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

        StompSession stompSession = stompClient.connect(connectorUrl,
                new StompSessionHandlerAdapter() {
                }).get(10, TimeUnit.SECONDS);

        stompSession.send("/topic/payment-status", new Status(status));
    }

}
