package com.digitalruiz.twitterclient;

import java.util.ArrayList;

import org.json.JSONArray;


import com.activeandroid.ActiveAndroid;
import com.digitalruiz.twitterclient.R;
import com.digitalruiz.twitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TimelineActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ActiveAndroid.initialize(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		
		
		TwitterClientApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONArray jsonTweets) {
				ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
				
				
				ListView lvTweets = (ListView)findViewById(R.id.lvTweets);
				TweetsAdapter adapter = new TweetsAdapter(getBaseContext(), tweets);
				lvTweets.setAdapter(adapter);
				
			//	Log.d("DEBUG", jsonTweets.toString());
				
			//	Log.d("DEBUG", tweets.toString());
				
				
			}
		});
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timeline, menu);
		return true;
		
	}
	
	public void onComposeTweet(MenuItem menu){
    	Intent menu_compose_tweet = new Intent(getApplicationContext(), Compose_Tweet.class);
		startActivity(menu_compose_tweet);
    	
    }

}
