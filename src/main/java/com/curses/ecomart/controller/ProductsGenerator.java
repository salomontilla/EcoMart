package com.curses.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsGenerator {
    private final ChatClient chatClient;
    public ProductsGenerator(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    @RequestMapping("/generate")
    public String generate() {
        var inputUser = "generate 5 ideas of eco products";
        return this.chatClient.prompt()
                .user(inputUser)
                .call()
                .content();
    }
}
