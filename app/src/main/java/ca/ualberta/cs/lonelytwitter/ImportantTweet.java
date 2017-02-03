package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * This is the Important subclass of Tweet. These tweets have
 * exclamation marks at the end indicating importance. isImportant()
 * method of this type returns TRUE
 * See Tweet superclass for inherited methods and variables.
 * @see Tweet superclass
 *
 * Created by ryanp on 2017-01-17.
 *  @author rperez
 *  @version 1.0
 */
public class ImportantTweet extends Tweet {

    /**
     * Constructor which takes three arguments: date, message, TweetTooLongException
     * @param date the date at which the tweet is posted
     * @param message the message of the tweet
     * @throws TweetTooLongException exception handled if message is too long.
     */
    public ImportantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    /**
     * Constructor which takes two arguments: message, and TweetTooLongException
     * @param message the message of the tweet
     * @throws TweetTooLongException exception handled if message is too long.
     */
    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }


    /**
     * Public method returns TRUE indicating the tweet is important
     * @return Boolean.TRUE the important tweet indicator
     */
    public Boolean isImportant() {
        return Boolean.TRUE;
    }


    @Override
    /**
     * Override inherited method getMessage to append " !!!" to show importance in
     * the tweet message.
     */
    public String getMessage() {

        return super.getMessage() + " !!!";
    }


}
