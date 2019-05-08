package com.tomek.camelspringboot.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    private final Environment environment;

    @Autowired
    public CamelRoute(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void configure() {
        from("{{startRoute}}")
                .log("Timer invoked and the body " + environment.getProperty("message"))
                .pollEnrich("{{fromRoute}}")
                .to("{{toRoute}}");
    }
}
