package com.azure.test.processorissue.rpc;

import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.function.Function;

@Component
public class FunctionTest implements Function<String, String> {
    @Override
    public String apply(String s) {
        return s.toUpperCase(Locale.ROOT);
    }
}
