package com.curses.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorizer")
public class ProductCategorizer {
    private final ChatClient chatClient;
    public ProductCategorizer(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String generate(String product) {
        var system = "you are a product categorizer";
        return this.chatClient.prompt()
                .system(system)
                .user(product)
                .options(ChatOptionsBuilder.builder()
                        .withTemperature(0.82)
                        .build())
                .call()
                .content();
    }
}
