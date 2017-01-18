package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ryanp on 2017-01-17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }



    // type boolean
    public Boolean isImportant() {
        return Boolean.TRUE;
    }


    @Override
    // way to protect yourself that overriding intent is
    // compiler makes sure ur overriding a message
    // so if you
    public String getMessage() {

        return super.getMessage() + " !!!";
    }


}
