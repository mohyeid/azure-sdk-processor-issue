package com.azure.test.processorissue.rpc;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
@Component
public class ProducerFunction implements Supplier<Message<String>> {
    @Override
    public Message<String> get() {
        return null;
    }
}
