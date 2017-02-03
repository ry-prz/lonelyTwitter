package ca.ualberta.cs.lonelytwitter;
import java.util.Date;


/**
 * This is the Happy subclass of Mood. Happy mood has the format
 * which indicates the current mood is happy.
 * See Mood superclass for inherited methods and variables.
 * @see Mood
 *
 * Created by ryanp on 2017-01-17.
 *  @author ryanp
 *  @version 1.0
 */
public class Happy extends Mood {

    /**
     * Constructor which sets the date to a default
     */
    public Happy() {
    }

    /**
     * Constructor which takes a date as an argument
     * @param date
     */
    public Happy(Date date) {
        super(date);
    }

    /**
     * format string indicating the mood is happy.
     */
    public String format() {
        return "Mood is happy :]";
    }



}
