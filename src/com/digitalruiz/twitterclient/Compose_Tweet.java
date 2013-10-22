package com.digitalruiz.twitterclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;




import com.digitalruiz.twitterclient.models.Tweet;
import com.digitalruiz.twitterclient.models.User;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;



public class Compose_Tweet extends Activity {
	
	EditText etTweet;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose__tweet);
		etTweet = (EditText) findViewById(R.id.etTweet);
		
		
		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compose__tweet, menu);
		return true;
	}
	
	
	public void onCancel(View v){
		finish();
	}
	
	
	public void postData(View v) {
		
		String new_tweet = etTweet.getText().toString();
		RequestParams params = new RequestParams("status", new_tweet);
		
		TwitterClientApp.getRestClient().postTweet(params, new JsonHttpResponseHandler(){
			  
			
		});
		
		Intent onToTimeline = new Intent(getApplicationContext(), TimelineActivity.class);
    	startActivity(onToTimeline);
		
	} 
	

}
