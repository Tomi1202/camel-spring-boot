package com.tomek.camelspringboot.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("timer:hello?period=10s")
                .log("Timer invoked and the body ${body}")
                .pollEnrich("file:data/input?delete=true&readLock=none")
                .to("file:data/output");
    }
}
