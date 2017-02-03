package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is the Happy subclass of Mood. Happy mood has the format
 * which indicates the current mood is happy.
 * See Mood superclass for inherited methods and variables.
 * @see Mood superclass
 *
 * Created by ryanp on 2017-01-17.
 *  @author rperez
 *  @version 1.0
 */
public class Sad extends Mood {

    /**
     * Constructor which sets the date to a default
     */
    public Sad() {
    }

    /**
     * Constructor which takes a date as an argument
     * @param date
     */
    public Sad(Date date) {
        super(date);
    }

    /**
     * format string indicating the mood is sad
     */
    public String format() {
        return "Mood is sad :[";
    }
}
