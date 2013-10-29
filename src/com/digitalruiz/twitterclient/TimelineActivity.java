package com.digitalruiz.twitterclient;

import java.util.ArrayList;

import org.json.JSONArray;


import com.activeandroid.ActiveAndroid;
import com.digitalruiz.twitterclient.R;
import com.digitalruiz.twitterclient.fragments.TweetsListFragment;
import com.digitalruiz.twitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.digitalruiz.twitterclient.fragments.*;

public class TimelineActivity extends FragmentActivity implements TabListener {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ActiveAndroid.initialize(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		setUpNavigationTabs();
		
		
		
	}
	
	


	private void setUpNavigationTabs() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		Tab tabHome = actionBar.newTab().setText("Home")
			.setTag("HomeTimeLineFragment").setIcon(R.drawable.ic_home)
			.setTabListener(this);
		
		Tab tabMentions = actionBar.newTab().setText("Mentions")
				.setTag("MentionsTimeLineFragment").setIcon(R.drawable.ic_mentions)
				.setTabListener(this);
		
		actionBar.addTab(tabHome);
		actionBar.addTab(tabMentions);
		actionBar.selectTab(tabHome);
	}

	public void onProfileView(MenuItem mi) {
		Intent i = new Intent(this, ProfileActivity.class);
		i.putExtra("user","reyes_ruiz");
		startActivity(i);
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




	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = manager.beginTransaction();
		
		if (tab.getTag() == "HomeTimeLineFragment") {
			fts.replace(R.id.frame_container, new HomeTimeLineFragment());
		} else {
			fts.replace(R.id.frame_container, new MentionsFragment());
		}
		fts.commit();
	}




	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
