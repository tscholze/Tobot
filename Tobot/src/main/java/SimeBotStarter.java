import org.jibble.pircbot.IrcException;

import java.io.IOException;

/**
 * Starter class for a SimpleTobot.
 * @see SimpleTobot
 */
public class SimeBotStarter
{
    /**
     * Starts a SimpleTobot.
     * Connects to a default test channel
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SimpleTobot simpleTobot = new SimpleTobot();
        simpleTobot.setVerbose(true);

        try
        {
            simpleTobot.connect("irc.german-elite.net");
            simpleTobot.joinChannel("#tobot-test");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (IrcException e)
        {
            e.printStackTrace();
        }


    }
}
