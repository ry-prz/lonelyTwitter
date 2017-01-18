package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ryanp on 2017-01-17.
 */

import java.util.Date;


public abstract class Mood {
    private Date date;

    //getters and setters
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    // constructor which sets date to default
    public Mood() {
        this.date = new Date();
    }

    // constructor which takes date as an argumrnt.
    public Mood(Date date) {
        this.date = date;
    }


    // format method which is dependent on the specific mood
    public abstract String format();
}
