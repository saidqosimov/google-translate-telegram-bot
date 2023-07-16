package com.example.googletranslatetelegrambot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TelegramUser {
    private String chatId;
    private String lang;
    private String step;
}