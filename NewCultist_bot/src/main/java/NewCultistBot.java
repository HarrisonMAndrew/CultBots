

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class NewCultistBot {
	
	private static final String botToken = "305480759:AAFj6LyL5an1bzveCYNtjW2H7hPPO_QDzBI";
	public static void main(String[] args) {
		final TelegramBot bot = TelegramBotAdapter.build(botToken);
		
				

		bot.setUpdatesListener(new UpdatesListener() {
			
		    public int process(List<Update> updates) {
		    		Update up = updates.get(updates.size() -1);
					if(up.message().text().equals("hi")){
						chatId = up.message().chat().id();
			
						SendMessage request = new SendMessage(chatId, "Welcome back")
				        .parseMode(ParseMode.HTML)
				        .disableWebPagePreview(true)
				        .disableNotification(true);
		
				
				SendResponse sendResponse = bot.execute(request);
				boolean ok = sendResponse.isOk();
				Message message = sendResponse.message();
				return UpdatesListener.CONFIRMED_UPDATES_ALL;
				}
				return UpdatesListener.CONFIRMED_UPDATES_ALL;
		       
		    }
		});
	}
}
