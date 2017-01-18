package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ryanp on 2017-01-17.
 */

public class Sad extends Mood {


    public Sad() {
    }

    public Sad(Date date) {
        super(date);
    }

    public String format() {
        return "Mood is sad :[";
    }
}
