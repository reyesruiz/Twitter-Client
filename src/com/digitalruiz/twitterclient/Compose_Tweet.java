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
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class Compose_Tweet extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose__tweet);
		
		
		RequestParams params = new RequestParams("status", "this is a test");
		
		

			

				
				

				
			
		
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
		RequestParams params = new RequestParams("status", "this is a test");
		
		TwitterClientApp.getRestClient().postTweet(params, new JsonHttpResponseHandler(){
			
		});
		
	} 

}
