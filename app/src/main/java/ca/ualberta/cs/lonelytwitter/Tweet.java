/**
 * Created by ryanp on 2017-01-17.
 */


package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet implements Tweetable {
    public Date date;
    private String message;

    // each tweet will have a list of moods
    private ArrayList<Mood> moodArrayList = new ArrayList<Mood>();

    public void addMood(Mood mood){
        moodArrayList.add(mood);
    }

    public Tweet(Date date, String message)  {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date(); // current time and date
    }

    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage()  {

            return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 144) {   //140??
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }


}
