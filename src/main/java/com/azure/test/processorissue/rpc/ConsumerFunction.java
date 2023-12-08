package com.azure.test.processorissue.rpc;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ConsumerFunction implements Consumer<Message<String>> {
    @Override
    public void accept(Message<String> stringMessage) {
        System.out.println("EVENTS: " + stringMessage.getPayload());
    }
}
