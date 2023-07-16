

// by https://t.me/QosimovSaid

package com.example.googletranslatetelegrambot.controller;

import com.example.googletranslatetelegrambot.dto.TelegramUser;
import com.example.googletranslatetelegrambot.constants.BotData;
import com.example.googletranslatetelegrambot.constants.BotSteps;
import com.example.googletranslatetelegrambot.service.EnterLanguage;
import com.example.googletranslatetelegrambot.service.GoogleTranslate;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    ArrayList<TelegramUser> telegramUsers = new ArrayList<TelegramUser>();

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String chatId = update.getMessage().getChatId().toString();
            TelegramUser telegramUser = returnUser(chatId);
            Message message = update.getMessage();
            String text = message.getText();
            if (text.equals("/start")) {
                sendText(chatId, "\uD83C\uDDFA\uD83C\uDDFF Assalomu alaykum " + update.getMessage().getFrom().getFirstName() + ". Google translate botga xush kelibsiz.\n\n" +
                        "\uD83C\uDDEC\uD83C\uDDE7 Hello " + update.getMessage().getFrom().getFirstName() + ". Welcome to the Google translate bot\n\n" +
                        "\uD83C\uDDF7\uD83C\uDDFA Привет " + update.getMessage().getFrom().getFirstName() + ". Добро пожаловать в бота Google переводчика");
                execute(EnterLanguage.enterLanguage(chatId));
                telegramUser.setStep(BotSteps.SELECT_LANG);
            } else if (text.equals("/edit_lang")) {
                telegramUser.setStep(BotSteps.SELECT_LANG);
                execute(EnterLanguage.enterLanguage(chatId));
            } else if (telegramUser.getStep().equals(BotSteps.ENTER_TEXT)) {
                sendText(chatId, GoogleTranslate.translate(telegramUser.getLang(), text));
            }
        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            TelegramUser user = returnUser(update.getCallbackQuery().getFrom().getId().toString());
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setText(GoogleTranslate.translate(data, "Til tanlandi")+"✔️");
            editMessageText.setChatId(update.getCallbackQuery().getFrom().getId().toString());
            editMessageText.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
            execute(editMessageText);
            user.setLang(data);
            user.setStep(BotSteps.ENTER_TEXT);
        }
    }

    private TelegramUser returnUser(String chatId) {
        for (TelegramUser telegramUser : telegramUsers) {
            if (telegramUser.getChatId().equals(chatId)) {
                return telegramUser;
            }
        }
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setChatId(chatId);
        telegramUsers.add(telegramUser);
        return telegramUser;
    }

    private void sendText(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BotData.botName;
    }

    @Override
    public String getBotToken() {
        return BotData.botKey;
    }
}
