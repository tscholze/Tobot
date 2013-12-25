import org.jibble.pircbot.PircBot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;

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
            // Random generator
            if (message.startsWith("!random"))
            {
                // Split it
                String[] parts = message.split(" ");

                // If invalid syntax
                if (parts.length == 1)
                {
                    sendMessage(channel, "Use !random <name1> <name2>");
                    return;
                }

                // Removed obsolete parts
                parts = Arrays.copyOfRange(parts,1, parts.length);

                // If only one argument is given
                if (parts.length == 1)
                {
                    sendMessage(channel, "Easy decision: " + parts[0]);
                    return;
                }

                // If default use
                int randomIndex = (int) (Math.random() * parts.length) + 1;
                sendMessage(channel, "Random result: " + parts[randomIndex - 1]);
            }

            // Returns current date time in english locale
            else if (message.startsWith("!time"))
            {
                SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMAN);
                String now = formatter.format(GregorianCalendar.getInstance().getTime());
                sendMessage(channel, "Current time: " + now);
            }
        }
    }
}
