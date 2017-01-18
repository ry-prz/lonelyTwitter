package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ryanp on 2017-01-17.
 */
// right click, generate > constructors. GENEATE first two
public class TweetTooLongException extends Exception {

    public TweetTooLongException(String detailMessage) {
        super(detailMessage);
    }

    public TweetTooLongException() {
    }
}
