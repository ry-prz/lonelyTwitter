package ca.ualberta.cs.lonelytwitter;

import java.util.Date;



/**
 * This is the Normaltweet subclass of Tweet. IsImportant() method for
 * these types of tweet returns FALSE.
 * See Tweet superclass for inherited methods and variables.
 * @see Tweet superclass
 *
 * Created by ryanp on 2017-01-17.
 *  @author rperez
 *  @version 1.0
 */
public class NormalTweet extends Tweet {

    /**
     * Instantiates a new Normal tweet.
     *
     * @param date    the date
     * @param message the message for terrt
     */
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message of tweet
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Public method returns FALSE indicating the tweet is
     * a normal tweet.
     * @return Boolean.FALSE the normal tweet indicator
     */
    public Boolean isImportant() {
        //never important, so always return false.
        return Boolean.FALSE;
    }


}
