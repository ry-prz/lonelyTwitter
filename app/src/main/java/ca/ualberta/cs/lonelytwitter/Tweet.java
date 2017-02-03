package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ryanp on 2017-01-17.
 *
 * The Abstract Tweet classm which implements the Tweetable interface
 * @author rperez
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet implements Tweetable {
    public Date date;
    private String message;
    // each tweet will have a list of moods
    private ArrayList<Mood> moodArrayList = new ArrayList<Mood>();

    /**
     * adds a mood to the array list of list of moods.
     * @param mood the mood to add to the moods list
     */
    public void addMood(Mood mood){
        moodArrayList.add(mood);
    }

    /**
     * Tweet constructor with date and message as parameters
     * @param date of the tweet
     * @param message of the tweet
     */
    public Tweet(Date date, String message)  {
        this.date = date;
        this.message = message;
    }

    /**
     * Tweet constructor with message as parameter
     * @param message of the tweet
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date(); // current time and date
    }

    /**
     * returns whether or not the tweet instance is important.
     * This will be determined by subclass
     * @return BOOLEAN , TRUE is important, FALSE is normal tweet
     */
    public abstract Boolean isImportant();

    /**
     * Modified toString method which will be return
     * the date with a separator, and then the message
     * @return date.toString() + " | " + message the resulting
     * string of this method
     */
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }

    /**
     * Returns the date of a tweet's posting
     * @return date the date at which the tweet was posted
     */
    public Date getDate() {
        return date;
    }

    /**
     * Mdds a specified date to a tweet
     * @param date the specified date to set the tweet's post date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the message of the tweet
     * @return message the message of the tweet
     */
    public String getMessage()  {
            return message;
    }

    /**
     * sets the message argument as the message of a tweet
     * @param message the message to set for the tweet
     * @throws TweetTooLongException throws this exception
     * if message argument length is greater than
     * the integer specified in this method
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 144) {
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }


}
