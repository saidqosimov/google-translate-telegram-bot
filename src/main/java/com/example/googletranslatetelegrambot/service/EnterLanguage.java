package com.example.googletranslatetelegrambot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class EnterLanguage {
    public static SendMessage enterLanguage(String chatId) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("\uD83C\uDDFA\uD83C\uDDFF Kerakli tilni tanlang\n\n" +
                "\uD83C\uDDEC\uD83C\uDDE7 Select the required language\n\n" +
                "\uD83C\uDDF7\uD83C\uDDFA Выберите нужный язык \uD83D\uDC47\uD83D\uDC47\uD83D\uDC47");
        sendMessage.setChatId(chatId);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> td = new ArrayList<InlineKeyboardButton>();

        InlineKeyboardButton inlineKeyboardButtonUz = new InlineKeyboardButton();
        inlineKeyboardButtonUz.setText("\uD83C\uDDFA\uD83C\uDDFF Uz");
        inlineKeyboardButtonUz.setCallbackData("uz");
        td.add(inlineKeyboardButtonUz);

        InlineKeyboardButton inlineKeyboardButtonEng = new InlineKeyboardButton();
        inlineKeyboardButtonEng.setText("\uD83C\uDDEC\uD83C\uDDE7 Eng");
        inlineKeyboardButtonEng.setCallbackData("en");
        td.add(inlineKeyboardButtonEng);

        InlineKeyboardButton inlineKeyboardButtonRu = new InlineKeyboardButton();
        inlineKeyboardButtonRu.setText("\uD83C\uDDF7\uD83C\uDDFA Ru");
        inlineKeyboardButtonRu.setCallbackData("ru");
        td.add(inlineKeyboardButtonRu);

        InlineKeyboardButton inlineKeyboardButtonAr = new InlineKeyboardButton();
        inlineKeyboardButtonAr.setText("\uD83C\uDDE6\uD83C\uDDEA Ar");
        inlineKeyboardButtonAr.setCallbackData("ar");
        td.add(inlineKeyboardButtonAr);

        List<InlineKeyboardButton> td1 = new ArrayList<InlineKeyboardButton>();

        InlineKeyboardButton inlineKeyboardButtonKo = new InlineKeyboardButton();
        inlineKeyboardButtonKo.setText("\uD83C\uDDF0\uD83C\uDDF7 Ko");
        inlineKeyboardButtonKo.setCallbackData("ko");
        td1.add(inlineKeyboardButtonKo);

        InlineKeyboardButton inlineKeyboardButtonTr = new InlineKeyboardButton();
        inlineKeyboardButtonTr.setText("\uD83C\uDDF9\uD83C\uDDF7 Tr");
        inlineKeyboardButtonTr.setCallbackData("tr");
        td1.add(inlineKeyboardButtonTr);

        InlineKeyboardButton inlineKeyboardButtonIt = new InlineKeyboardButton();
        inlineKeyboardButtonIt.setText("\uD83C\uDDEE\uD83C\uDDF9 It");
        inlineKeyboardButtonIt.setCallbackData("it");
        td1.add(inlineKeyboardButtonIt);

        InlineKeyboardButton inlineKeyboardButtonDe = new InlineKeyboardButton();
        inlineKeyboardButtonDe.setText("\uD83C\uDDE9\uD83C\uDDEA De");
        inlineKeyboardButtonDe.setCallbackData("de");
        td1.add(inlineKeyboardButtonDe);

        List<InlineKeyboardButton> td2 = new ArrayList<InlineKeyboardButton>();

        InlineKeyboardButton inlineKeyboardButtonFr = new InlineKeyboardButton();
        inlineKeyboardButtonFr.setText("\uD83C\uDDEB\uD83C\uDDF7 Fr");
        inlineKeyboardButtonFr.setCallbackData("fr");
        td2.add(inlineKeyboardButtonFr);

        InlineKeyboardButton inlineKeyboardButtonJa = new InlineKeyboardButton();
        inlineKeyboardButtonJa.setText("\uD83C\uDDEF\uD83C\uDDF5 Ja");
        inlineKeyboardButtonJa.setCallbackData("ja");
        td2.add(inlineKeyboardButtonJa);

        InlineKeyboardButton inlineKeyboardButtonKk = new InlineKeyboardButton();
        inlineKeyboardButtonKk.setText("\uD83C\uDDF0\uD83C\uDDFF Kk");
        inlineKeyboardButtonKk.setCallbackData("kk");
        td2.add(inlineKeyboardButtonKk);

        InlineKeyboardButton inlineKeyboardButtonTg = new InlineKeyboardButton();
        inlineKeyboardButtonTg.setText("\uD83C\uDDF9\uD83C\uDDEF Tg");
        inlineKeyboardButtonTg.setCallbackData("tg");
        td2.add(inlineKeyboardButtonTg);

        List<List<InlineKeyboardButton>> tr = new ArrayList<List<InlineKeyboardButton>>();
        tr.add(td);
        tr.add(td1);
        tr.add(td2);

        inlineKeyboardMarkup.setKeyboard(tr);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }
}
