import org.jibble.pircbot.PircBot;

/**
 * Created by tobias on 25/12/13.
 */
public class SimpleTobot extends PircBot
{
    /**
     * Contains the name of the bot.
     */
    private String name = "Tobot";

    /**
     * Default constructor.
     * Sets the name.
     */
    public SimpleTobot()
    {
        setName(name);
    }

    /**
     * Raised on every channel's message.
     * @param channel Name of the channel
     * @param sender Nickname of the sender
     * @param login Loginname of the sender (e.g. ~tobo)
     * @param hostname Hostname of the sender (e.g. GE-3786B8F5.domain.com)
     * @param message Sender's message string.
     */
    public void onMessage(String channel, String sender,
                          String login, String hostname, String message)
    {
        message = message.toLowerCase();

        // Entry point for bot-related commands
        if (message.contains(name.toLowerCase()))
        {
            if (message.contains("ping"))
            {
                sendMessage(channel, "Ping you self "+ sender + "!");
            }
            else if (message.contains("popo"))
            {
                sendMessage(channel, "Popo? Hhahaha Pfzzz. - Minions");
            }
        }

        // Global message-related commands
        else
        {
            if (sender.contains("onkelhotte"))
            {
                sendMessage(channel, "My "+sender+" !");
            }
        }
    }
}
