package com.example.googletranslatetelegrambot.config;

import com.example.googletranslatetelegrambot.controller.TelegramBot;
import lombok.SneakyThrows;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component

public class BotInitializer {
    final
    TelegramBot telegramBot;

    public BotInitializer(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @SneakyThrows
    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(telegramBot);
    }
}
