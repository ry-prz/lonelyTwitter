package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IllegalFormatCodePointException;
import java.util.Collections;
/**
 * Created by ryanp on 2017-02-14.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet (Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {

        return tweets.get(index);
    }

    public void addTweet(Tweet tweet) {
        if (hasTweet(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return tweets;
    }


    public boolean hasTweetv2(){
        for(Tweet i : tweets) {

            Tweet current = i;
            for(Tweet j : tweets) {

                if(i!=j & j.getMessage().equals(current.getMessage()));
                return true;
            }
        }
        return false;
    }


    public int getCount(){
        return tweets.size();
    }





}
