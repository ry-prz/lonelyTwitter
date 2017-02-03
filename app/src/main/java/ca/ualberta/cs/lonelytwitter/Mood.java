package ca.ualberta.cs.lonelytwitter;



import java.util.Date;


/**
 * This is an abstract class of the subclasses Happy and Sad.
 * Each Mood will have a date of when the mood was felt, getters and
 * setters of the date, and a format string which will specify
 * specifically what mood the user is feeling.
 *
 * Created by ryanp on 2017-01-17.
 *  @author rperez
 *  @version 1.0
 */
public abstract class Mood {
    private Date date;

    /**
     * returns the date of when the mood was felt.
     * @return date, the date which the user was feeling this mood.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the current date of when the mood was felt.
     * @param date, sets the current date into the date of the mood instance.
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * constructor which sets date to default
     */
    public Mood() {
        this.date = new Date();
    }

    /**
     * constructor which takes date as an argumrnt.
     */
    public Mood(Date date) {
        this.date = date;
    }


    /**
     * format  which is dependent on the specific mood
     */
    public abstract String format();
}
