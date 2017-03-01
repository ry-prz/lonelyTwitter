package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class EditTweetActivity extends Activity {

    private ArrayList<Tweet> tweetList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        TextView t = (TextView) findViewById(R.id.textView);
        String msg = getIntent().getExtras().getString("message");

        t.setText(msg);
    }



}
