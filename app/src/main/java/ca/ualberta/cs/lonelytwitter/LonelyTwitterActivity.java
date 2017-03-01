package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of the project. <br> In this class, user interaction
 * and file manipulation is performed.
 * All files are in the form "json" files that are storeed in Emulator's accessible from Android Device Monitor:
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data -> data -> ca.ualberta.cs.lonelytwitter -> files -> files.sav
 * </pre>
 * <code> begin <br>
 * some pseudo code <br>
 * end.</code>
 * The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant.
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ul>
 * <ol>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ol>
 *
 *  @author kassenov
 *  @version 1.0
 *  @see Tweet
 *  @since 0.5
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are saved there. The format of the file is JSON.
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */

	private LonelyTwitterActivity activity = this;

	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING}
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayAdapter<Tweet> adapter;
	private ArrayList<Tweet> tweetList;


	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	/**
	 * Called when the activity is first created.
	 * */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);



		try {
			// try catch will handle the first tweet, HAS OPTION of tweeting, or no tweeting at all
			Tweet tweet = new NormalTweet("First tweet"); // this is upcasted to Tweet
			//Tweet tweet2 = new Tweet(new Date(), "My second tweet");
			tweet.setMessage("this is a message");

			NormalTweet normalTweet = new NormalTweet("i'm normal");

			ImportantTweet importantTweet = new ImportantTweet("very important");
			importantTweet.getDate();

			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
			arrayList.add(tweet);

			// example of casting
			arrayList.add((Tweet) importantTweet);

			arrayList.add(normalTweet);

			// adding a mood
			Sad sad = new Sad();
			Happy happy = new Happy();
			importantTweet.addMood(sad);
			normalTweet.addMood(happy);


		} catch (TweetTooLongException e) {
			e.printStackTrace();
		}


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpaces(text);

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});

		// Added for lab exercise
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);

				// clear tweetList, screen is cleared
				tweetList.clear();

				//delete file, tweets on the disk are removed
				deleteFile("file.sav");

				// update list view
				adapter.notifyDataSetChanged();


			}
		});

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
				intent.putExtra("message", tweetList.get(position).getMessage());
				startActivity(intent);
			}
		});


	}

	/**
	 * Called right after onCreate(Bundle)
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Trims extra spaces using regular expression.
	 * @param inputString string that needs to be cleared of extra spaces
	 * @return inputString the formatted form of the string
     */
	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+", " ");
		return inputString;
	}

	/**
	 * This method sorts items in the tweet list and refreshes the adapter.
	 * @param ordering ordering to be used
     */
	private void sortTweetListItems(TweetListOrdering ordering) {

	}

	/**
	 * Loads tweets from specified file.
	 *
	 * @throws TweetTooLongException if the text is too long.
	 * @exception FileNotFoundException if the file is not created first.
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			//Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			// 2017-01-24 18:19PM
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);


		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Saves tweets to a specified file in JSON format.
	 * @throws FileNotFoundException if file folder doesn't exist
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Handle the Exception properly later
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}