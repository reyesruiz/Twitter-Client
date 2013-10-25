package com.digitalruiz.twitterclient.fragments;

import org.json.JSONArray;

import com.digitalruiz.twitterclient.TwitterClientApp;
import com.digitalruiz.twitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;

public class MentionsFragment extends TweetsListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_timeline);
		
	//	fragmentTweets = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentTweets);
		
		TwitterClientApp.getRestClient().getMentions(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONArray jsonTweets) {
			//	ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
				getAdapter().addAll(Tweet.fromJson(jsonTweets));
			}
		});
	}

}
