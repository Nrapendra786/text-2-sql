package com.techwaala;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
@Slf4j
public class SqlGenerator {

    private final ChatClient chatClient;

    public SqlGenerator(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    String generate(String question) {
        String response = chatClient
                .prompt(question)
                .call()
                .content();

        log.debug(response);

        boolean isSelectQuery = Objects.requireNonNull(response).startsWith("SELECT");
        if (!isSelectQuery) {
            throw new InvalidQueryException(response);
        }
        return response;
    }
}
