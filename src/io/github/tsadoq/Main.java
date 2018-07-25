package io.github.tsadoq;
import io.github.tsadoq.WhoisBot.WhoIsQuery.WhoIsQuery;
import io.github.tsadoq.WhoisBot.WhoIsQuery.WhoisServerList;
import io.github.tsadoq.bot.TelegramBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new TelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
