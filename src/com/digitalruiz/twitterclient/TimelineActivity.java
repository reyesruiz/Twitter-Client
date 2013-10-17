package com.digitalruiz.twitterclient;

import org.json.JSONArray;

import com.digitalruiz.twitterclient.R;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class TimelineActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		
		
		TwitterClientApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONArray jsonTweets) {
				Log.d("DEBUG", jsonTweets.toString());
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timeline, menu);
		return true;
	}

}
