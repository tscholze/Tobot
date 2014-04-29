import org.jibble.pircbot.IrcException;

import java.io.IOException;

/**
 * Starter class for a SimpleTobot.
 * @see SimpleTobot
 */
public class SimpleBotStarter
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
            simpleTobot.connect("atlas.fr.eu.SwiftIRC.net");
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
