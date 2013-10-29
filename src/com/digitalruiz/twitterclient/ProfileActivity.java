package com.digitalruiz.twitterclient;


import org.json.JSONObject;


import com.digitalruiz.twitterclient.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends FragmentActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);

		loadProfileInfo();
		
	}

	private void loadProfileInfo() {
		TwitterClientApp.getRestClient().getMyInfo(
				new JsonHttpResponseHandler () { 
                    @Override
                    public void onSuccess(JSONObject json) {
                            User u = User.fromJson(json);
                            getActionBar().setTitle("@" + u.getScreenName());
                            populateProfileHeader(u);
                           
                    }

					private void populateProfileHeader(User u) {
						 TextView tvName = (TextView) findViewById(R.id.tvName);
			             TextView tvTagline = (TextView) findViewById(R.id.tvTagline);
			             TextView tvFollowers = (TextView) findViewById(R.id.tvFollowers);
			             TextView tvFollowing = (TextView) findViewById(R.id.tvFollowing);
			             ImageView ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
			                
			             tvName.setText(u.getName());
			             tvTagline.setText(u.getTagline());
			             tvFollowers.setText(u.getFollowersCount() + " Followers");
			             tvFollowing.setText(u.getFriendsCount() + " Following");
			             ImageLoader.getInstance().displayImage(u.getProfileImageUrl(), ivProfileImage);
			              //load profile image
						
					}

            
            });        
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}
