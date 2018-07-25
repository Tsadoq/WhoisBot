//              .                       The information contained on current file (the "Service") is for general information purposes only.
//              |\                      
//              | \
//              |  \                    In no event shall be liable for any special, direct, indirect, consequential, or incidental damages  
//              |  |                    or any damages whatsoever, whether in an action of contract, negligence or other tort, arising out of
//              |  |)                   or in connection with the use of the Service or the contents of the Service. reserves the right to make 
//              |  | )                  additions, deletions, or modification to the contents on the Service at any time without prior notice.
//              |  |_)
//             /|  / /
//            /_| /_/|                  © by Matteo Villosio. All rights reserved
//            | | | ||
//            | | | ||
//            | | | ||\                 Informations and contacts @ tsadoq.github.io
//           /| | | || \
//          / | | | ||  \
//         /  | | | ||   \
//        /   | | | ||    \
//       /    | | | ||     \
//      /     | | | ||      \
//      \  ___| | | ||___   /
//       --   | | | ||\  ---
//           /| | | |\  \
//          / \_/ \_/ \___|
//         /  |     |  \
//         \__|     |__/


package io.github.tsadoq.bot;
import io.github.tsadoq.WhoisBot.WhoIsQuery.WhoIsQuery;
import io.github.tsadoq.WhoisBot.WhoIsQuery.WhoisServerList;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot{
    private String name = "Domain_lookup_Bot";
    private String token = "nope"; //this is not the token obv
    private WhoisServerList db;

    public TelegramBot() {
        this.db = new WhoisServerList();
    }

    @Override
    public void onUpdateReceived(Update update){
        if (update.hasMessage() && update.getMessage().hasText()) {

            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText("Your query is being processed");
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            String url =update.getMessage().getText();
            WhoIsQuery query = new WhoIsQuery(url,db.getServer(url));

            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(query.getReply().toString());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
