package com.digitalruiz.twitterclient.fragments;

import org.json.JSONArray;

import android.content.Intent;
import android.os.Bundle;

import com.digitalruiz.twitterclient.TwitterClientApp;
import com.digitalruiz.twitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class UserTimelineFragment extends TweetsListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	Intent intent = getIntent();
	//	String user = intent.getStringExtra("user");
		String user = getActivity().getIntent().getExtras().getString("user");
	//	setContentView(R.layout.activity_timeline);
		
	//	fragmentTweets = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentTweets);
	//	String user = "reyes_ruiz";
		
		TwitterClientApp.getRestClient().getUserTimeline(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONArray jsonTweets) {
			//	ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
				getAdapter().addAll(Tweet.fromJson(jsonTweets));
			}
		}, user);
	}

}