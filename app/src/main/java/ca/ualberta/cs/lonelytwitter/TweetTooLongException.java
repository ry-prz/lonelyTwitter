package ca.ualberta.cs.lonelytwitter;

/**
 * Subclass of Exception which handles the event that
 * a tweet message is over the allowed specified tweet length.
 *
 * Created by ryanp on 2017-01-17.
 * @author rperez
 * @version 1.0
 */
public class TweetTooLongException extends Exception {

    /**
     * Constructor which takes the detailed message as an argument.
     * @param detailMessage the detailed message parameter
     */
    public TweetTooLongException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructor of TweetTooLongException
     */
    public TweetTooLongException() {
    }
}
