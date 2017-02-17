package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
/**
 * Created by ryanp on 2017-02-14.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

    }
    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet ("Another test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = new NormalTweet("Another test Tweet");
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());


    }


    public void testHasTweetv2() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("a tweet");
        Tweet tweet2 = new NormalTweet("a tweet2");
        Tweet tweet3 = new NormalTweet("a tweet");
        boolean has = false;

        tweets.add(tweet);
        tweets.add(tweet2);
        tweets.add(tweet3);

        assertTrue(tweets.hasTweetv2());
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));

    }

    public void testStrings(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should star with 't'", "test".startsWith("t"));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");
        Tweet tweet2 = new NormalTweet("Last tweet");
        boolean has = false;

        tweets.add(tweet);

        assertFalse(tweets.hasTweet(tweet2));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("tweet");
        Tweet tweet2 = new NormalTweet("tweet2");

        tweets.add(tweet);
        tweets.add(tweet2);

        assertEquals(tweets.getCount(),2);

    }









}
