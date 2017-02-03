package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * This interface indicates what methods are available
 * as public methods, which are getMessage() and getDate() methods.
 *
 * Created by ryanp on 2017-01-17.
 *  @author rperez
 *  @version 1.0
 */
public interface Tweetable {

    /**
     * gets message of the tweet
     * @return message the message of the tweet
     */
    public String getMessage();

    /**
     * gets the date at which the tweet was posted
     * @return date the date at which the tweet was posted
     */
    public Date getDate();

}
